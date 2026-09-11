package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {
    Page page;
    private final Locator checkOutButton;
    private final Locator remuweFirstProductButton;
    private final Locator continiueShoopingButton;
    private final Locator thankyouMessage;



    public CartPage(Page page) {
        super(page);
        this.page = page;
        checkOutButton = page.locator("#checkout");
        remuweFirstProductButton = page.locator("#remove-sauce-labs-bike-light");
        continiueShoopingButton = page.locator("#continue-shopping");
        thankyouMessage = page.locator("[data-test='complete-header']");


    }
    public void clickCheckOut() {
        checkOutButton.click();
    }

    public void remuweFirstProduct() {
        remuweFirstProductButton.click();
    }
    public void continiueShooping () {
        continiueShoopingButton.click();
    }

    public Locator getThankyouMessage () {
        return thankyouMessage;
    }

}
