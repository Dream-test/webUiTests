package org.webproject;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WebUiTests {

    String userLogin = "standard_user";
    String password = "secret_sauce";

    @BeforeAll
    public static void setUp() {
        open("https://www.saucedemo.com/");
    }

    @AfterEach
    public void logOut() {
        $("#react-burger-menu-btn").click();
        $("#logout_sidebar_link").click();
    }

    @Test
    public void loginTest() {
        $(".login_logo").shouldHave(text("Swag Labs"));

        $("#user-name").setValue(userLogin);
        $("#password").setValue(password);
        $("#login-button").click();

        $(".title").shouldBe(visible).shouldHave(text("Products"));

        sleep(10000);
    }

    @Test
    public void addToCard() {
        $("#user-name").setValue(userLogin);
        $("#password").setValue(password);
        $("#login-button").click();

        SelenideElement item = $x("//*[@id=\"inventory_container\"]/div/div[1]");
        item.shouldBe(visible);

        SelenideElement itemName =$("#item_4_title_link");
        itemName.$(".inventory_item_name ").shouldHave(text("Sauce Labs Backpack"));

        item.$("#add-to-cart-sauce-labs-backpack").click();
        item.$("#remove-sauce-labs-backpack").shouldBe(visible);

        SelenideElement shippingCart = $(".shopping_cart_link");
        shippingCart.$("[data-test='shopping-cart-badge']").shouldBe(visible).shouldHave(text("1"));

        SelenideElement filter = $(".product_sort_container");
        filter.click();
        filter.selectOption("Price (low to high)");
        $(".active_option").shouldHave(text("Price (low to high)"));
    }

    @Test
    public void itemDescription() {
        $("#user-name").setValue(userLogin);
        $("#password").setValue(password);
        $("#login-button").click();

        $("#item_0_title_link").click();
        $("[data-test='inventory-item-name']").shouldBe(visible).shouldHave(text("Sauce Labs Bike Light"));

       // $("#react-burger-menu-btn").click();
       // $("#logout_sidebar_link").click();
    }
}
