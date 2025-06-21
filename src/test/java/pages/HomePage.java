package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h1[@class='site-header__logo']/a[1]/img[@itemprop='logo']")
    private WebElement logoImage;
    @FindBy(css = "a svg.icon-search")
    private WebElement searchButton;
    @FindBy(xpath = "//button[@type='submit']/following-sibling::input")
    private WebElement searchField;
    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement cookieAcceptBtn;
    @FindBy(css = "button[aria-label='Close dialog']")
    private WebElement closeTeaserButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoVisible() {
        return isElementVisible(logoImage);
    }

    public boolean isSearchLayoutVisible() {
        closeTeaserIfPresent();
        click(searchButton);
        return isElementVisible(searchField);
    }

    public String getHomePageTitle() {
        return getTitle();
    }

    public SearchPage searchItem(String key) {
        acceptCookiesIfPresent();
        sendKeys(searchField, key + Keys.ENTER);
        closeTeaserIfPresent();
        return new SearchPage(driver);
    }


    public void acceptCookiesIfPresent() {
        try {
            if (isElementVisible(cookieAcceptBtn)) {
                click(cookieAcceptBtn);
            }
        } catch (Exception e) {
            // Cookie bar is not shown, continue
        }
    }

    public void closeTeaserIfPresent() {
        try {
            if (isElementVisible(closeTeaserButton)) {
                click(closeTeaserButton);
            }
        } catch (Exception e) {
            // Cookie bar is not shown, continue
        }

    }
}

