package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage{
    Page page;

    private final Locator firstName;
    private final Locator lastName;
    private final Locator postalCode;
    private final Locator continiueButton;
    private final Locator finishButton;
    private final Locator successMessage;
    private final Locator errorMessage;
    private final Locator homeButton;
    private final Locator totalPrice;
    private final Locator priceWithoutTax;
    private final Locator Tax;


    public CheckoutPage(Page page) {
        super(page);
        this.page = page;
        firstName = page.locator("#first-name");
        lastName = page.locator("#last-name");
        postalCode = page.locator("#postal-code");
        continiueButton = page.locator("#continue");
        finishButton = page.locator("#finish");
        successMessage = page.locator("[data-test='complete-header']");
        errorMessage = page.locator("[data-test='error']");
        homeButton = page.locator("#back-to-products");
        totalPrice = page.locator(".summary_total_label");
        priceWithoutTax = page.locator(".summary_subtotal_label");
        Tax = page.locator(".summary_tax_label");


    }
    public void enterUserData (String name, String surname, String code) {
        firstName.fill(name);
        lastName.fill(surname);
        postalCode.fill(code);
        continiueButton.click();
    }
    public void enterUserData() {
        firstName.fill("Jan");
        lastName.fill("Kowalski");
        postalCode.fill("80-250");
        continiueButton.click();
    }
    public void clickFinish () {
        finishButton.click();
    }
    public void clickHome () {
        homeButton.click();
    }
    public void clickContiniue () {
        continiueButton.click();
    }
    public Locator getErrorMessage () {
        return errorMessage;
    }
    public Locator getThankYouMessage () {
        return successMessage;
    }
    public Locator getTotalPrice () {
        return totalPrice;
    }
    public Locator getPriceWithoutTax () {
        return priceWithoutTax;
    }
    public Locator getTax () {
        return Tax;
    }





}
