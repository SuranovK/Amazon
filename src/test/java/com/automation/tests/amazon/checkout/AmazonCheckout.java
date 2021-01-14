package com.automation.tests.amazon.checkout;


import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import com.automation.pages.amazon.CheckoutPage;
import com.automation.pages.amazon.HomePage;
import com.automation.pages.amazon.ResultPage;
import com.automation.tests.amazon.TestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.automation.utilities.DynamicData;

public class AmazonCheckout extends TestBase {

	@Test(description = "This test is to verify items price in different stages of checkout process")
	public void veryPriceOfSearchedItem() {
		HomePage hp = new HomePage();
		ResultPage rp = new ResultPage();
		CheckoutPage checkout = new CheckoutPage();

		extentLogger = report.createTest("Amazon's Search and Checkout features test.");


		assertEquals(Driver.getDriver().getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		extentLogger.pass("Amazon Home Page is verified.");

		extentLogger.info("Entering desired search item name into Search box.");
		hp.searchForItem(ConfigurationReader.getProperty("searchItem"));
		BrowserUtils.waitForPageToLoad(10);

		extentLogger.info("Capturing the displayed price on Search result page.");
		BigDecimal originalPrice = DynamicData.combineTwoStringAsDecimalNumber(rp.itemPriceWhole.getText(),
				rp.itemPriceFraction.getText());
		extentLogger.info("The original price of the item is $" + originalPrice + ".");

		extentLogger.info("Selecting the first item from the result list.");
		rp.itemPriceWhole.click();

		BigDecimal priceInDetailsPage = DynamicData.convertStringToBigDecimal(rp.newBuyPrice.getText());
		assertEquals(priceInDetailsPage, originalPrice);

		extentLogger.pass("The price on details page has been verified with original price.");
		extentLogger.info("Expected price: " + priceInDetailsPage + ". Actual price " + originalPrice + ".");

		extentLogger.info("Clicking on Add to Cart button.");
		rp.addToCartBtn.click();

		BigDecimal priceInCheckoutPage = DynamicData.convertStringToBigDecimal(checkout.itemPrice.getText());
		assertEquals(priceInCheckoutPage, originalPrice);
		extentLogger.pass("The price on checkout page has been verified with original price.");
		
		extentLogger.info("Proceed to Checkout button is clicked.");
		checkout.proceedToCheckoutBtn.click();



	}

}
