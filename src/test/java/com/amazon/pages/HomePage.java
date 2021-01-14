package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	public WebElement searchSubmitBtn;

	public void searchForItem(String itemName) {
		searchBox.sendKeys(itemName);
		searchSubmitBtn.click();
	}
}
