package automationTests.Tests;

import automationTests.Pages.LoginAdminPage;
import automationTests.Pages.ManagementPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdminManagementTests {
    final private String roomName = "test";
    final private String roomPrice = "500";
    final private String userName = "admin";
    final private String password = "password";
    final private String roomType = "Single"; //cases: "Twin", "Double", "Family", "Suite".
    final private Boolean accessible = true;
    final private Boolean hasWiFi = true;
    final private Boolean hasTV = true;
    final private Boolean hasRadio = true;
    final private Boolean hasRefreshments = true;
    final private Boolean hasSafe = true;
    final private Boolean hasViews = true;

    @BeforeAll
    public static void configurationBrowser() {
        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void cleanBrowser() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @Test
    public void adminLoginTest() {
        Selenide.open("https://automationintesting.online/#/admin");
        login();
        ManagementPage.waitManagementPage();
    }

    @Test
    public void addRoomTest() {
        Selenide.open("https://automationintesting.online/#/admin");
        login();
        ManagementPage.waitManagementPage();
        ManagementPage.enterRoomName(roomName);
        ManagementPage.selectRoomType(roomType);
        ManagementPage.selectRoomAccessible(accessible);
        ManagementPage.enterRoomPrice(roomPrice);
        ManagementPage.selectCheckboxHasWiFi(hasWiFi);
        ManagementPage.selectCheckboxHasTV(hasTV);
        ManagementPage.selectCheckboxHasRadio(hasRadio);
        ManagementPage.selectCheckboxHasRefreshments(hasRefreshments);
        ManagementPage.selectCheckboxHasSafe(hasSafe);
        ManagementPage.selectCheckboxHasViews(hasViews);
        ManagementPage.createRoom();
        if (!ManagementPage.namesOfRoom().contains(roomName)) {
            throw new AssertionError("Room name \"" + roomName + "\" was not found in the list of room names.");
        };
    }

    private void login() {
        LoginAdminPage.waitForPageIsLoaded();
        LoginAdminPage.enterUsername(userName);
        LoginAdminPage.enterPassword(password);
        LoginAdminPage.clickLoginButton();
    }

}
