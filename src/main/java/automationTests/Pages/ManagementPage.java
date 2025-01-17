package automationTests.Pages;

import automationTests.PageElements.RoomFormElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ManagementPage {
    public static final SelenideElement title = $(Selectors.byTagAndText("a", "B&B Booking Management"));
    public static final ElementsCollection roomsList = $$(Selectors.byAttribute("data-testid", "roomlisting"));

    public static void waitManagementPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("B&B Booking Management"));
    }

    public static List<String> namesOfRoom() {
        return roomsList.stream()
                .map(room -> room.$("div.col-sm-1 p").getText())
                .toList();
    }

    public static void enterRoomName(String roomName) {
        RoomFormElement.enterRoomName(roomName);
    }

    public static void selectRoomType(String roomType) {
        switch (roomType) {
            case "Single": RoomFormElement.setSingleRoomType();break;
            case "Twin": RoomFormElement.setTwinRoomType();break;
            case "Double": RoomFormElement.setDoubleRoomType();break;
            case "Family": RoomFormElement.setFamilyRoomType();break;
            case "Suite": RoomFormElement.setSuiteRoomType();break;
            default: RoomFormElement.setSingleRoomType();break;
        }
    }

    public static void selectRoomAccessible(boolean accessible) {
        if (accessible) {
            RoomFormElement.setRoomAccessible();
        } RoomFormElement.setRoomNotAccessible();
    }

    public static void enterRoomPrice(String roomPrice) {
        RoomFormElement.enterRoomPrice(roomPrice);
    }

    public static void selectCheckboxHasWiFi(boolean hasWiFi) {
        if (hasWiFi) {
            RoomFormElement.checkboxHasWiFi();
        }
    }

    public static void selectCheckboxHasTV(boolean hasTV) {
        if (hasTV) {
            RoomFormElement.checkboxHasTV();
        }
    }

    public static void selectCheckboxHasRadio(boolean hasRadio) {
        if (hasRadio) {
            RoomFormElement.checkboxHasRadio();
        }
    }

    public static void selectCheckboxHasRefreshments(boolean hasRefreshments) {
        if (hasRefreshments) {
            RoomFormElement.checkboxHasRefreshments();
        }
    }

    public static void selectCheckboxHasSafe(boolean hasSafe) {
        if (hasSafe) {
            RoomFormElement.checkboxHasSafe();
        }
    }

    public static void selectCheckboxHasViews(boolean hasViews) {
        if (hasViews) {
            RoomFormElement.checkboxHasViews();
        }
    }

    public static void createRoom() {
        RoomFormElement.clickCreateButton();
    }

}
