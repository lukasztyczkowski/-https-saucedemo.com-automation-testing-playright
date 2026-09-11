package pl.mruczekprogramista.tests.ui;


import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;


public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp () {
         playwright = Playwright.create();

         browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                 .setHeadless(false)
                 .setArgs(Arrays.asList(
                         "--disable-translate",
                         "--lang=en-US"
                 ))
         );
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setLocale("en-US")
        );
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        playwright.close();
    }
    public void openPage () {
        page.navigate("https://saucedemo.com");
    }

}
