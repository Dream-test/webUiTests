package labTests.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FilterElement {
     private static final SelenideElement filterDropDown = $(".product_sort_container");
     private static final SelenideElement filterOption =$(".active_option");

     public static void setFilterLowToHigh() {
         filterDropDown.click();
         filterDropDown.selectOption("Price (low to high)");
         filterOption.shouldHave(text("Price (low to high)"));
     }
}
