package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class ProductSearchTest extends BaseTest {

	@BeforeClass
	public void productSearchSetup() {

		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook", "MacBook Air" }, { "Macbook", "MacBook Pro" },
				{ "Samsung", "Samsung Galaxy Tab 10.1" }

		};

	}

	@Test(dataProvider = "getProductData")
	public void productSearchPage(String searchKey, String productName) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.searchProduct(productName);
		String actProductHeaderName = productInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProductHeaderName, productName);

	}

	@DataProvider
	public Object[][] getImagesData() {
		return new Object[][] { { "Macbook", "MacBook Air", 4 }, { "Samsung", "Samsung Galaxy Tab 10.1", 7 },
				{ "imac", "iMac", 3 }, { "Macbook", "MacBook Pro", 4 } };
	}

	@Test(dataProvider = "getImagesData")
	public void getImagesCountTest(String searchKey, String productName, int imagesCount) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.searchProduct(productName);
		int actproductImagesTotalCount = productInfoPage.getImageCount();
		Assert.assertEquals(actproductImagesTotalCount, imagesCount);

	}

	@Test
	public void getProductTitleTest() {
		String actProductTitle = productInfoPage.getProductTitle();
		Assert.assertEquals(actProductTitle, AppConstants.PRODUCT_SEARCH_TITLE);

	}

	@Test
	public void checkAddToCartTest() {
		searchResPage = accPage.doSearch("Macbook");
		productInfoPage = searchResPage.searchProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.verifyAddToCartButton(), true);

	}

	@Test
	public void productDataTest() {
		searchResPage = accPage.doSearch("Macbook");
		productInfoPage = searchResPage.searchProduct("MacBook Pro");
		Map<String, String> actProductInfo = productInfoPage.getProductInfo();
		softAssert.assertEquals(actProductInfo.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfo.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfo.get("Reward Points"), "800");
		softAssert.assertEquals(actProductInfo.get("Availability"), "In Stock");
		softAssert.assertEquals(actProductInfo.get("productprice"), "$2,000.00");
		softAssert.assertEquals(actProductInfo.get("eExTaxPrice"), "Ex Tax: $2,000.00");

		softAssert.assertAll();

	}

}
