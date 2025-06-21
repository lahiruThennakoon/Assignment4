package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-section='productList']")
    WebElement productCountTab;
    @FindBy(xpath = "//div[contains(text(),'Sort by')]")
    WebElement sortDropDown;

    @FindBy(xpath = "//div[@class='kuResults']//li")
    List<WebElement> productList;

    @FindBy(css = "div.kuSort[data-value='PRICE_ASC']")
    WebElement dropDownLowToHigh;


    public String getSearchPageTitle() {
        return getTitle();
    }

    public int getNumberOfSearchProducts() {
        return Integer.parseInt(productCountTab.getText().split(" ")[0]);
    }

    public void sortProductListPriceLowToHigh() {
        click(sortDropDown);
        waitForVisibility(dropDownLowToHigh);
        click(dropDownLowToHigh);
    }

    public ProductDisplayPage clickProduct(int index) {
        waitForVisibility(productList.get(0));
        driver.findElement(By.xpath("(//div[@class='kuResults']//li)[" + index + "]")).click();
        return new ProductDisplayPage(driver);
    }

    public ArrayList<Float> getProductPriceList() {
        refreshPage();
        ArrayList<Float> productPriceList = new ArrayList<>();
        for (WebElement product : productList) {
            String priceText;
            try {
                WebElement salePrice = product.findElement(By.xpath(".//div[@class='kuPrice']/span[2]"));
                priceText = salePrice.getText();
            } catch (Exception e) {
                WebElement regularPrice = product.findElement(By.xpath(".//div[@class='kuPrice']/span"));
                priceText = regularPrice.getText();
            }
            priceText = priceText.replaceAll("[^\\d.]", "");
            productPriceList.add(Float.parseFloat(priceText));
        }
        return productPriceList;
    }


}
