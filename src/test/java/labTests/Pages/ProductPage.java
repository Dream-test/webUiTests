package labTests.Pages;

import com.codeborne.selenide.SelenideElement;
import labTests.PageElements.CartElement;
import labTests.PageElements.FilterElement;
import labTests.PageElements.ItemCard;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ProductPage {
    private static final SelenideElement title = $(".title");
   // private static final SelenideElement item = $x("(//div[@class='inventory_item'])[1]");
   // private static final SelenideElement itemName = $("#item_4_title_link");

   // private static final SelenideElement addToCartButton = item.$("#add-to-cart-sauce-labs-backpack");
   //private static final SelenideElement cancelAdd = item.$("#remove-sauce-labs-backpack");

   // private static final SelenideElement shoppingCart = $(".shopping_cart_link");
   // private static final SelenideElement cartBadge = shoppingCart.$(".shopping_cart_badge");

   // private static final SelenideElement filterDropDown = $(".product_sort_container");
   // private static final SelenideElement filterOption =$(".active_option");

    public static void waitForProductPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("Products"));
    }

    public static void checkProductCart() {
        //item.shouldBe(visible);
        //item.$(".inventory_item_name ").shouldHave(text("Sauce Labs Backpack"));
        ItemCard.checkItemName("Sauce Labs Backpack");
    }

    public static void addToCart() {
        //addToCartButton.click();
        //cancelAdd.shouldBe(visible);
        //cartBadge.shouldBe(visible).shouldHave(text("1"));
        ItemCard.addToCartButtonClick();
        CartElement.verifyCart();
    }

    public static void cancelAdd() {
        //cancelAdd.click();
        //cartBadge.shouldBe(disappear);
        ItemCard.cancelAddButtonClick();
        CartElement.verifyEmptyCart();
    }

    public static void filterLowToHigh() {
        //filterDropDown.click();
        //filterDropDown.selectOption("Price (low to high)");
        //filterOption.shouldHave(text("Price (low to high)"));
        FilterElement.setFilterLowToHigh();
    }

    public static void openCart() {
        CartElement.openCart();
    }
}
