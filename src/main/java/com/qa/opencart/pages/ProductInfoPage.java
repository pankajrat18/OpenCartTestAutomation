package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 01. By Locator
	private By productHeader = By.xpath("//div[@id='content']//h1");
	private By prodImages = By.xpath("//a[@class='thumbnail']");
	private By addToCartButton = By.id("button-cart");
	private By productMetaData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]//li");
	private By productPriceData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][2]//li");

	private Map<String, String> productMap;

	// 02. constuctor

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public String getProductHeaderValue() {
		String prodHeaderValue = eleUtil.doElementGetText(productHeader);
		System.out.println("Product header val " + prodHeaderValue);
		return prodHeaderValue;

	}

	public int getImageCount() {
		int imageCount = eleUtil.waitForElementsToBeVisible(prodImages, AppConstants.SMALL_DEFAULT_TIMEOUT).size();
		System.out.println("Images count " + imageCount);
		return imageCount;

	}

	public String getProductTitle() {
		String productfinalsearchTitle = eleUtil.waitForTitleToBe(AppConstants.PRODUCT_SEARCH_TITLE,
				AppConstants.MEDIUM_DEFAULT_TIMEOUT);
		System.out.println("Product Page title is " + productfinalsearchTitle);
		return productfinalsearchTitle;

	}

	public boolean verifyAddToCartButton() {
		return eleUtil.waitForElementVisible(addToCartButton, AppConstants.SMALL_DEFAULT_TIMEOUT).isDisplayed();

	}

	public Map<String, String> getProductInfo() {
		// productMap = new HashMap<>();
		// productMap = new LinkedHashMap<>();
		productMap = new TreeMap<>();

		// add product name in map
		productMap.put("productname", getProductHeaderValue());
		getProductMetaData();
		getProductPriceData();
		System.out.println("Product info are : ");
		productMap.forEach((k, v) -> System.out.println(k + ":" + v));

		return productMap;

	}

	private void getProductMetaData() {

		List<WebElement> metadataList = eleUtil.getElements(productMetaData);

		for (WebElement e : metadataList) {
			String text = e.getText();
			String meta[] = text.split(":");
			String key = meta[0].trim();
			String value = meta[1].trim();
			productMap.put(key, value);
		}

	}

	private void getProductPriceData() {
		List<WebElement> metaPriceData = eleUtil.getElements(productPriceData);
		String productPrice = metaPriceData.get(0).getText().trim();
		String productExTaxPrice = metaPriceData.get(1).getText().trim();
		productMap.put("productprice", productPrice);
		productMap.put("eExTaxPrice", productExTaxPrice);

	}
}
