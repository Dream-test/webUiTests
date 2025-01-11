package automationTests.Pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginAdminPage {
    public static final SelenideElement title = $(Selectors.byTagAndText("h2", "Log into your account"));
    public static final SelenideElement userName = $(By.id("username"));
    public static final SelenideElement password = $(By.id("password"));
    public static final SelenideElement loginButton = $(By.id("doLogin"));

    public static void  waitForLoginPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("Log into your account"));
    }

    public static void enterUsername(String value) {
        userName.setValue(value);
    }

    public static void enterPassword(String value) {
        password.setValue(value);
    }

    public static void clickLoginButton() {
        loginButton.click();
    }


}
