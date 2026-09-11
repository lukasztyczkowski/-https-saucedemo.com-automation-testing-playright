package pl.mruczekprogramista.tests.ui;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    void loginSucsessfully() {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce");
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }
    @Test
    void loginWithBadPassword () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user","badpassword");
        assertThat(page.locator("[data-test='error']"))
                .hasText("Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    void loginWithBadLogin () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("baduser","secret_sauce");
        assertThat(page.locator("[data-test='error']"))
                .hasText("Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    void  loginWithBlocedUser () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("locked_out_user","secret_sauce");
        assertThat(page.locator("[data-test='error']"))
                .hasText("Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    void loginWitchEmptyLogin() {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("","secret_sauce");
        assertThat(page.locator("[data-test='error']")).hasText("Epic sadface: Username is required");
    }
    @Test
    void logiWitchEmptyPassword () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user","");
        assertThat(page.locator("[data-test='error']"))
                .hasText("Epic sadface: Password is required");
    }
    @Test
    void loginWitchBadUserAndBadPassword () {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("badlogin","badpassword");
        assertThat(page.locator("[data-test='error']"))
                .hasText("Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    void loginSuccessAndLogout() {
        openPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginSuccess();
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
        ProductPage productPage = new ProductPage(page);
        productPage.openMenu();
        productPage.logout();
        assertThat(page).hasURL("https://www.saucedemo.com/");


    }



}
