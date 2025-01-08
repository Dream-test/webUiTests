package labTests.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import labTests.Pages.LoginPage;
import labTests.Pages.ProductPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LabTests {
    String userLogin = "standard_user";
    String password = "secret_sauce";

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        open("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest() {
        LoginPage.waitForPageIsLoaded();
        LoginPage.enterUsername(userLogin);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
        ProductPage.waitForProductPageIsLoaded();

    }

    @Test
    public void addToCartTest() {
        ProductPage.waitForProductPageIsLoaded();
        ProductPage.checkProductCart();
        ProductPage.addToCart();
        ProductPage.openCart();
        Selenide.back();
    }

    @Test
    public void filterItemTest() {
        ProductPage.filterLowToHigh();
    }
}
