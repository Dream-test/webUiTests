package labTests.Pages;

import com.codeborne.selenide.SelenideElement;
import labTests.PageElements.CartElement;
import labTests.PageElements.FilterElement;
import labTests.PageElements.ItemCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPageFactory {

    @FindBy(className = "title")
    private static WebElement title;

    public ProductPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void waitForProductPageFactoryIsLoaded() {
        if (title.isDisplayed() && title.getText().equals("Products")) {
            System.out.println("Page is opened");
        } System.out.println("Page isn't displayed");
    }

    public void checkProductCart() {
        ItemCard.checkItemName("Sauce Labs Backpack");
    }

    public void addToCart() {
        ItemCard.addToCartButtonClick();
        CartElement.verifyCart();
    }

    public void cancelAdd() {
        ItemCard.cancelAddButtonClick();
        CartElement.verifyEmptyCart();
    }

    public void filterLowToHigh() {
        FilterElement.setFilterLowToHigh();
    }

    public void openCart() {
        CartElement.openCart();
    }
}
