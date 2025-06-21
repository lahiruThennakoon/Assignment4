package tests;

import base.BaseTest;
import data.TestConstants;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDisplayPage;
import pages.SearchPage;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Assignment4Test extends BaseTest {

    @Test(description = "Verify end-to-end flow: search > sort > product display > add to cart > validate cart")
    public void verifySearchSortAndAddToCartFlow() {

        // Step 1: Navigate to the home page and validate basic elements
        HomePage homePage = new HomePage(driver);
        softAssert.assertEquals(homePage.getHomePageTitle(), TestConstants.HOME_PAGE_TITLE);
        softAssert.assertTrue(homePage.isLogoVisible());

        // Step 2: Search for a product and validate the results
        softAssert.assertTrue(homePage.isSearchLayoutVisible());
        SearchPage searchPage = homePage.searchItem(TestConstants.SEARCH_KEY_CARS); // Navigate to search results
        softAssert.assertEquals(searchPage.getSearchPageTitle(), TestConstants.SEARCH_PAGE_TITLE);
        searchPage.getNumberOfSearchProducts();
        softAssert.assertTrue(searchPage.getNumberOfSearchProducts() > TestConstants.ZERO); // Assert search results are present

        // Step 3: Sort results by price (Low to High) and validate the sorting
        searchPage.sortProductListPriceLowToHigh();
        ArrayList<Float> sortedProductPriceList = searchPage.getProductPriceList();
        ArrayList<Float> manuallySortedList = new ArrayList<>(sortedProductPriceList);
        Collections.sort(manuallySortedList);
        softAssert.assertEquals(sortedProductPriceList, manuallySortedList); // Verify if sorting is correct

        // Step 4: Click on a product and verify product details
        ProductDisplayPage displayPage = searchPage.clickProduct(TestUtils.getRandomNumber(TestConstants.ITEMS_PER_PAGE));
        String productName = displayPage.getProductName();
        softAssert.assertEquals(displayPage.getDisplayPageTitle(), productName + TestConstants.COMMON_TITLE);
        displayPage.increaseItemCount(3);
        softAssert.assertEquals(displayPage.getSelectedQuantity(), 3);

        // Step 5: Add to cart and verify cart details
        displayPage.addToCart();
        softAssert.assertTrue(displayPage.isCartDrawerVisible());
        softAssert.assertEquals(displayPage.getCartItemSize(), 1);
        softAssert.assertEquals(displayPage.getCartItemName(0), productName);
        softAssert.assertEquals(displayPage.getItemCountAddedToCart(0), 3);
        Float productPrice = displayPage.getProductPrice(0);
        softAssert.assertEquals(displayPage.getSubTotal(), productPrice * 3);
        softAssert.assertTrue(displayPage.isChatIconDisplayed());
        softAssert.assertAll();

    }
}
