package labTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageFactory {
    //public static final SelenideElement title = $(".login_logo");
    @FindBy(className = "login_logo")
    private static WebElement title;

    //public static final SelenideElement userName = $("#user-name");
    @FindBy(id = "user-name")
    private static WebElement userName;

    //public static final SelenideElement password = $("#password");
    @FindBy(id = "password")
    private static WebElement password;

    //public static final SelenideElement loginButton = $("#login-button");
    @FindBy(id = "login-button")
    private static WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    } //конструктор выполняющий инициализацию элементов на странице

    public void  waitForPageIsLoaded() {
        //title.shouldBe(visible).shouldHave(text("Swag Labs"));
        if (title.isDisplayed() && title.getText().equals("Swag Labs")) {
            System.out.println("Page is opened");
        } System.out.println("Page isn't displayed");
    }

    public void enterUsername(String value) {
        //userName.setValue(value);
        userName.sendKeys(value);
    }

    public void enterPassword(String value) {
        //password.setValue(value);
        password.sendKeys(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String userLogin, String password) {
        enterUsername(userLogin);
        enterPassword(password);
        clickLoginButton();
    }
}
