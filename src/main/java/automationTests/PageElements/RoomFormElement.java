package automationTests.PageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RoomFormElement {
    public static final SelenideElement roomName = $(By.id("roomName"));
    public static final SelenideElement roomType = $(By.id("type"));
    public static final SelenideElement roomAccessible = $(By.id("accessible"));
    public static final SelenideElement roomPrice = $(By.id("roomPrice"));
    public static final SelenideElement hasWiFi = $(By.id("wifiCheckbox"));
    public static final SelenideElement hasTV = $(By.id("tvCheckbox"));
    public static final SelenideElement hasRadio = $(By.id("radioCheckbox"));
    public static final SelenideElement hasRefreshments = $(By.id("refreshCheckbox"));
    public static final SelenideElement hasSafe = $(By.id("safeCheckbox"));
    public static final SelenideElement hasViews = $(By.id("viewsCheckbox"));
    public static final SelenideElement createButton = $(By.id("createRoom"));

    public static void enterRoomName(String value) {
        roomName.setValue(value);
        roomName.shouldHave(Condition.value(value));
    }

    public static void setSingleRoomType() {
        roomType.click();
        roomType.selectOption("Single");
        roomType.shouldHave(text("Single"));
    }

    public static void setTwinRoomType() {
        roomType.click();
        roomType.selectOption("Twin");
        roomType.shouldHave(text("Twin"));
    }

    public static void setDoubleRoomType() {
        roomType.click();
        roomType.selectOption("Double");
        roomType.shouldHave(text("Double"));
    }

    public static void setFamilyRoomType() {
        roomType.click();
        roomType.selectOption("Family");
        roomType.shouldHave(text("Family"));
    }

    public static void setSuiteRoomType() {
        roomType.click();
        roomType.selectOption("Suite");
        roomType.shouldHave(text("Suite"));
    }

    public static void setRoomAccessible() {
        roomAccessible.click();
        roomAccessible.selectOption("true");
        roomAccessible.shouldHave(text("true"));
    }

    public static void setRoomNotAccessible() {
        roomAccessible.click();
        roomAccessible.selectOption("false");
        roomAccessible.shouldHave(text("false"));
    }

    public static void enterRoomPrice(String value) {
        roomPrice.setValue(value);
        roomPrice.shouldHave(Condition.value(value));
    }

    public static void checkboxHasWiFi() {
        hasWiFi.click();
        hasWiFi.shouldBe(Condition.selected);
    }

    public static void checkboxHasTV() {
        hasTV.click();
        hasTV.shouldBe(Condition.selected);
    }

    public static void checkboxHasRadio() {
        hasRadio.click();
        hasRadio.shouldBe(Condition.selected);
    }

    public static void checkboxHasRefreshments() {
        hasRefreshments.click();
        hasRefreshments.shouldBe(Condition.selected);
    }

    public static void checkboxHasSafe() {
        hasSafe.click();
        hasSafe.shouldBe(Condition.selected);
    }

    public static void checkboxHasViews() {
        hasViews.click();
        hasViews.shouldBe(Condition.selected);
    }

    public static void clickCreateButton() {
        createButton.click();
        roomName.shouldBe(empty);
    }


}
