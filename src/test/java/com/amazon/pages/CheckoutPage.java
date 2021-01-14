package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Driver;

public class CheckoutPage {
	public CheckoutPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")
	public WebElement itemPrice;

	@FindBy(id = "hlb-ptc-btn-native")
	public WebElement proceedToCheckoutBtn;



}
