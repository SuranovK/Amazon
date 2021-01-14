package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Driver;

public class ResultPage {
	public ResultPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//span[@class='a-price-whole'][1]")
	public WebElement itemPriceWhole;

	@FindBy(xpath = "//span[@class='a-price-fraction'][1]")
	public WebElement itemPriceFraction;


}
