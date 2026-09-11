package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    protected final Page page;
    protected final Locator cartBadge;
    protected final Locator cartButton;
    protected final Locator menuButton;
    protected final Locator logoutButton;

    public BasePage (Page page) {
        this.page=page;
        cartBadge = page.locator(".shopping_cart_badge");
        cartButton = page.locator(".shopping_cart_link");
        menuButton = page.locator("#react-burger-menu-btn");
        logoutButton =page.locator("#logout_sidebar_link");
    }

    public Locator getCartItemCount () {
        return cartBadge;
    }
    public void openCart() {
        cartButton.click();
    }
    public void openMenu() {
        menuButton.click();
    }
    public void logout () {
        logoutButton.click();
    }
    public void logoutWithMenu() {
        menuButton.click();
        logoutButton.click();
    }

}
