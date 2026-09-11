package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage  extends BasePage{
    Page page;

    private final Locator firstProductButton;
    private final Locator secondProductButton;
    private final Locator thirdProductButton;
    private final Locator removeFirstProductFromCart;




    public ProductPage (Page page) {
        super(page);
        this.page= page;
        firstProductButton= page.locator("#add-to-cart-sauce-labs-backpack");
        secondProductButton= page.locator("#add-to-cart-sauce-labs-bike-light");
        thirdProductButton= page.locator("#add-to-cart-sauce-labs-bolt-t-shirt");
        removeFirstProductFromCart= page.locator("#remove-sauce-labs-backpack");




    }
    public void addFirstProductToCard () {
        firstProductButton.click();
    }
    public void addSecondProductToCard () {
        secondProductButton.click();
    }
    public void addThirdProductToCard () {
        thirdProductButton.click();
    }
    public void removeFirstFromCartButton () {
        removeFirstProductFromCart.click();
    }



    public void addThreeProductsToCart() {
        firstProductButton.click();
        secondProductButton.click();
        thirdProductButton.click();
    }
    public void addProductAndOpenCart () {
        firstProductButton.click();
        cartButton.click();
    }


}
