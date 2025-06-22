package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDisplayPage extends BasePage {

    @FindBy(css = "h1.product-single__title")
    WebElement productName;
    @FindBy(xpath = "//div[@class='product-block']//span[text()='+']")
    WebElement addQuantityBtn;
    @FindBy(xpath = "//input[contains(@id,'Quantity')]")
    WebElement quantity;
    @FindBy(css = "button#AddToCart-")
    WebElement addToCartButton;
    @FindBy(css = "div#CartDrawer")
    WebElement cartDrawer;
    @FindBy(xpath = "//div[contains(@class,'cart__item-price-col')]")
    List<WebElement> cartItemList;
    @FindBy(xpath = "//div[@class='ajaxcart__subtotal']/following-sibling::div")
    WebElement subTotal;
    @FindBy(xpath = "//*[@id=\"gorgias-chat-messenger-button\"]")
    WebElement messengerButton;
    @FindBy(xpath = "//div[@id='CartDrawer']//button[@aria-label='next']")
    WebElement nextButton;


    public ProductDisplayPage(WebDriver driver) {
        super(driver);
    }

    public String getDisplayPageTitle() {
        return getTitle();
    }

    public String getProductName() {
        waitForVisibility(productName);
        return productName.getText();
    }

    public void increaseItemCount(int index) {
        for (int i = 1; i < index; i++) {
            performJSClick(addQuantityBtn);
        }
    }

    public int getSelectedQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public boolean isCartDrawerVisible() {
        return isElementVisible(cartDrawer);
    }

    public String getCartItemName(int itemIndex) {
        return cartItemList.get(itemIndex).findElement(By.xpath("//div[@class='cart__item-title']/a")).getText();

    }

    public int getCartItemSize() {
        waitForElementToBeClickable(nextButton);
        return cartItemList.size();
    }

    public int getItemCountAddedToCart(int itemIndex) {
        return Integer.valueOf(cartItemList.get(itemIndex).findElement(By.xpath("//input[@name='updates[]']")).getAttribute("value"));
    }

    public Float getProductPrice(int itemIndex) {
        return Float.valueOf(cartItemList.get(itemIndex).findElement(By.xpath("//div[contains(@class,'cart__item-price-col')]")).getText().replaceAll("[^\\d.]", ""));
    }

    public Float getSubTotal() {
        return Float.valueOf(getElementText(subTotal).replaceAll("[^\\d.]", ""));
    }

    public boolean isChatIconDisplayed() {
        switchToFrame("chat-button");
        return messengerButton.isDisplayed();
    }

}
