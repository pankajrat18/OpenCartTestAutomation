package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 01. By Locator

	private By logoutlink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchIcon = By.xpath("//button[contains(@class,'btn btn-default btn-lg')]");
	private By accountPageHeaders = By.xpath("//div[contains(@id,'content')]/h2");

	// 02. constuctor

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 03 - Page Actions

	public String getAccountPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.SMALL_DEFAULT_TIMEOUT);
		System.out.println("Acc Page Title is " + title);
		return title;
	}

	public String getAccountPageUrl() {
		String url = eleUtil.waitForUrl(AppConstants.SMALL_DEFAULT_TIMEOUT, AppConstants.ACCOUNT_PAGE_URL_FRACTION);
		System.out.println("Acc login page url is " + url);
		return url;
	}

	public boolean isLogouttLinkExist() {
		return eleUtil.waitForElementVisible(logoutlink, AppConstants.MEDIUM_DEFAULT_TIMEOUT).isDisplayed();
	}

	public boolean isSearchFieldExist() {
		return eleUtil.waitForElementVisible(searchField, AppConstants.MEDIUM_DEFAULT_TIMEOUT).isDisplayed();
	}

	public List<String> getAccountSectionHeader() {
		return eleUtil.getAllElementsTextList(accountPageHeaders, AppConstants.MEDIUM_DEFAULT_TIMEOUT);
	}

	// common page Actions

	public SearchResultPage doSearch(String productName) {
		System.out.println("searching for " + productName);
		eleUtil.doSendKeysWithWait(searchField, AppConstants.MEDIUM_DEFAULT_TIMEOUT, productName);
		eleUtil.doClick(searchIcon);
		return new SearchResultPage(driver);

	}

}
