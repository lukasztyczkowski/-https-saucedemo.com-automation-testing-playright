package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final Locator username;
    private final Locator password;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        super(page);
        username = page.locator("#user-name");
        password = page.locator("#password");
        loginButton= page.locator("#login-button");
        errorMessage = page.locator("[data-test='error']");
    }
    public void login(String user, String pass) {
        username.fill(user);
        password.fill(pass);
        loginButton.click();
    }
    public Locator getErrorMessage() {
        return errorMessage;
    }
    public void loginSuccess () {
        username.fill("standard_user");
        password.fill("secret_sauce");
        loginButton.click();
    }
}
