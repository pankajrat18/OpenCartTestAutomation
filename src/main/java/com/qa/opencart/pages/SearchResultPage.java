package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 01- By locator
	By productCount = By.xpath("//div[@class='product-thumb']");

	// 02- page constuctor

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// Page Actions

	public int getSearchProductCount() {
		return eleUtil.waitForElementsToBeVisible(productCount, AppConstants.SMALL_DEFAULT_TIMEOUT).size();

	}

	public ProductInfoPage searchProduct(String searchProductName) {
		System.out.println("Search Product Name is " + searchProductName);
		By product = By.linkText(searchProductName);
		eleUtil.doClick(product);
		return new ProductInfoPage(driver);

	}
}
