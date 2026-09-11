package pl.mruczekprogramista.tests.ui;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckOutTest extends BaseTest{
    @Test
    public void shouldFinishCheckoutSuccessfully() {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();
        ProductPage productPage = new ProductPage(page);
        productPage.addFirstProductToCard();
        productPage.openCart();
        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckOut();
        CheckoutPage checkOutPage = new CheckoutPage(page);
        checkOutPage.enterUserData();
        checkOutPage.clickFinish();
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-complete.html");
        assertThat(checkOutPage.getThankYouMessage()).hasText("Thank you for your order!");


    }
    @Test
    public void shouldFinishCheckoutSuccessfullyAndBackToHomeAndLogout () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();

        ProductPage productPage = new ProductPage(page);
        productPage.addProductAndOpenCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.enterUserData();
        checkoutPage.clickFinish();
        checkoutPage.clickHome();
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

        productPage.logoutWithMenu();
        assertThat(page).hasURL("https://www.saucedemo.com/");
    }
    @Test
    public void shouldCheckoutwithemptyFirstName () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();

        ProductPage productPage = new ProductPage(page);
        productPage.addProductAndOpenCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.enterUserData("","Kot","88-400");
        checkoutPage.clickContiniue();
        assertThat(checkoutPage.getErrorMessage()).hasText("Error: First Name is required");
    }
    @Test
    public void sholuldCheckoutTheEmptyLastName () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();

        ProductPage productPage = new ProductPage(page);
        productPage.addProductAndOpenCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.enterUserData("Jan","","88-400");
        checkoutPage.clickContiniue();
        assertThat(checkoutPage.getErrorMessage()).hasText("Error: Last Name is required");

    }
    @Test
    public void sholudCheckoutTheEmptyPostalCode () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();

        ProductPage productPage = new ProductPage(page);
        productPage.addProductAndOpenCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.enterUserData("Jan","Kot","");
        checkoutPage.clickContiniue();
        assertThat(checkoutPage.getErrorMessage()).hasText("Error: Postal Code is required");
    }
    @Test
    public void shouldDisplayCorrectCheckoutTotal() {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();

        ProductPage productPage = new ProductPage(page);
        productPage.addThreeProductsToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckOut();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.enterUserData();
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-step-two.html");
        assertThat(checkoutPage.getTotalPrice()).hasText("Total: $60.45");
        assertThat(checkoutPage.getPriceWithoutTax()).hasText("Item total: $55.97");
        assertThat(checkoutPage.getTax()).hasText("Tax: $4.48");




    }

}
