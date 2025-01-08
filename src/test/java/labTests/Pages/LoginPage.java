package labTests.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static final SelenideElement title = $(".login_logo");
    public static final SelenideElement userName = $("#user-name");
    public static final SelenideElement password = $("#password");
    public static final SelenideElement loginButton = $("#login-button");

    public static void  waitForPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("Swag Labs"));
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
