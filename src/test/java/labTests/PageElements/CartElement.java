package labTests.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartElement {
    private static final SelenideElement shoppingCart = $(".shopping_cart_link");
    private static final SelenideElement cartBadge = shoppingCart.$(".shopping_cart_badge");

    public static void verifyCart() {
        cartBadge.shouldBe(visible).shouldHave(text("1"));
    }

    public static void verifyEmptyCart() {
        cartBadge.shouldBe(disappear);
    }

    public static void openCart() {
        shoppingCart.click();

    }
}
