package pl.mruczekprogramista.tests.ui;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductTest  extends  BaseTest{

    @Test
    public void shouldSingleProductAddSucessfully () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();
        ProductPage productPage = new ProductPage(page);
        productPage.addFirstProductToCard();
        assertThat(productPage.getCartItemCount()).hasText("1");



    }
    @Test
    public void addThreeProductsToCart () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();
        ProductPage productPage = new ProductPage(page);
        productPage.addThreeProductsToCart();
        assertThat(productPage.getCartItemCount()).hasText("3");

    }
    @Test
    public void addProductToCartAndRemoveOnProductPage () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();
        ProductPage productPage = new ProductPage(page);
        productPage.addFirstProductToCard();
        productPage.removeFirstFromCartButton();
        assertThat(productPage.getCartItemCount()).isHidden();
    }
    @Test
    public void addPrductToCartAndOpenCart () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();
        ProductPage productPage = new ProductPage(page);
        productPage.addThirdProductToCard();
        assertThat((productPage.getCartItemCount())).hasText("1");
        productPage.openCart();
        assertThat(page).hasURL("https://www.saucedemo.com/cart.html");

    }
    @Test
    public void shouldCompletePurchaseEndToEnd() {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();

        ProductPage productPage = new ProductPage(page);
        productPage.addFirstProductToCard();
        productPage.addSecondProductToCard();
        assertThat(productPage.getCartItemCount()).hasText("2");
        productPage.openCart();

        CartPage cartPage = new CartPage(page);
        cartPage.remuweFirstProduct();
        cartPage.continiueShooping();
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

    }

}
