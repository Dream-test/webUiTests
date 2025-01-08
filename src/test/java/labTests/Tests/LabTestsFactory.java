package labTests.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import labTests.Pages.LoginPageFactory;
import labTests.Pages.ProductPageFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LabTestsFactory {
    private static WebDriver driver;
    String userLogin = "standard_user";
    String password = "secret_sauce";

    @BeforeAll
    public static void setUp() {
        //set Selenide parameters
        Configuration.timeout = 10000;
        Configuration.headless = true;
        Configuration.browserSize = "1366x768";

        //set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        if (Configuration.headless) {
            options.addArguments(("--headless"));
        }
        options.addArguments("--window-size=" + Configuration.browserSize);

        //create WebDriver with set options
        driver = new ChromeDriver(options);

        //setup WebDriver in the Selenide
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginTest() {
        driver.get("https://www.saucedemo.com/");
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        ProductPageFactory productPageFactory = new ProductPageFactory(driver);

        loginPageFactory.waitForPageIsLoaded();
        loginPageFactory.enterUsername(userLogin);
        loginPageFactory.enterPassword(password);
        loginPageFactory.clickLoginButton();


        productPageFactory.waitForProductPageFactoryIsLoaded();

    }

    @Test
    public void addToCartTest() {
        driver.get("https://www.saucedemo.com/");
        LoginPageFactory loginPageFactory =new LoginPageFactory(driver);
        ProductPageFactory productPageFactory = new ProductPageFactory(driver);

        loginPageFactory.login(userLogin, password);

        productPageFactory.waitForProductPageFactoryIsLoaded();
        productPageFactory.checkProductCart();
        productPageFactory.addToCart();
        productPageFactory.openCart();
        //Selenide.back();
    }

    @Test
    public void filterItemTest() {
        driver.get("https://www.saucedemo.com/");
        LoginPageFactory loginPageFactory =new LoginPageFactory(driver);
        ProductPageFactory productPageFactory = new ProductPageFactory(driver);

        loginPageFactory.login(userLogin, password);
        productPageFactory.filterLowToHigh();
    }
}
