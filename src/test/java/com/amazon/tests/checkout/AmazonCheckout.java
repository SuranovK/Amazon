package com.amazon.tests.checkout;


import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.HomePage;
import com.amazon.pages.ResultPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.DynamicData;

public class AmazonCheckout extends TestBase {

	@Test
	public void priceVerification() {
		HomePage hp = new HomePage();
		ResultPage rp = new ResultPage();

		extentLogger = report.createTest("Amazon's Search and Checkout features test");

		extentLogger.info("Verifying Amazon Home Page");
		Assert.assertEquals(Driver.getDriver().getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

		extentLogger.info("Entering desired search item name into Search box");
		hp.searchForItem(ConfigurationReader.getProperty("searchItem"));

		extentLogger.info("Capturing the displayed price on Search result page");
		BigDecimal itemPrice = DynamicData.returnAsDecimal(rp.itemPriceWhole.getText(), rp.itemPriceFraction.getText());
		System.out.println("The original price of the item is $" + itemPrice);
		extentLogger.info("Verifying first price with the price on Item Details page");
		Assert.assertEquals(itemPrice, 10);
		// rp.itemPriceWhole.click();



	}

}
