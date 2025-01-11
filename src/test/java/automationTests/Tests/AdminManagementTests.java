package automationTests.Tests;

import automationTests.Pages.LoginAdminPage;
import automationTests.Pages.ManagementPage;
import automationTests.RandomRoomData;
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
        //Arrange
        Selenide.open("https://automationintesting.online/#/admin");

        //Act
        login();

        //Assert
        ManagementPage.waitManagementPageIsLoaded();
    }

    @Test
    public void addRoomTest() {
        //Arrange
        RandomRoomData roomData = new RandomRoomData();
        Selenide.open("https://automationintesting.online/#/admin");
        login();
        ManagementPage.waitManagementPageIsLoaded();

        //Act
        ManagementPage.enterRoomName(roomName);
        ManagementPage.selectRoomType(roomData.roomType());
        ManagementPage.selectRoomAccessible(roomData.hasMarker());
        ManagementPage.enterRoomPrice(roomPrice);
        ManagementPage.selectCheckboxHasWiFi(roomData.hasMarker());
        ManagementPage.selectCheckboxHasTV(roomData.hasMarker());
        ManagementPage.selectCheckboxHasRadio(roomData.hasMarker());
        ManagementPage.selectCheckboxHasRefreshments(roomData.hasMarker());
        ManagementPage.selectCheckboxHasSafe(roomData.hasMarker());
        ManagementPage.selectCheckboxHasViews(roomData.hasMarker());
        ManagementPage.createRoom();

        //Assert
        if (!ManagementPage.namesOfRoom().contains(roomName)) {
            throw new AssertionError("Room name \"" + roomName + "\" was not found in the list of room names.");
        }
    }

    private void login() {
        LoginAdminPage.waitForLoginPageIsLoaded();
        LoginAdminPage.enterUsername(userName);
        LoginAdminPage.enterPassword(password);
        LoginAdminPage.clickLoginButton();
    }

}
