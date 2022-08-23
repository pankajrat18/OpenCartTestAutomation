package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 01- By locator

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registrationLink = By.linkText("Register");

	// 02- page constuctor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 03 - Page Actions
	@Step("getting login page title for Application")
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SMALL_DEFAULT_TIMEOUT);
		System.out.println("Page Title is " + title);
		return title;
	}

	@Step("getting login page URL")
	public String getLoginPageUrl() {
		String url = eleUtil.waitForUrl(AppConstants.SMALL_DEFAULT_TIMEOUT, AppConstants.LOGIN_PAGE_URL_FRACTION);
		System.out.println("login page url is " + url);
		return url;
	}

	@Step("Checking forgot link")
	public boolean isForgotLinkExist() {
		System.out.println("Checking fogot link");
		return eleUtil.waitForElementPresence(forgotPwdLink, AppConstants.SMALL_DEFAULT_TIMEOUT).isDisplayed();
	}

	@Step("login with username :{0} and password:{1}")
	public AccountPage doLogin(String username, String pwd) {
		System.out.println("App credential are " + username + ":" + pwd);
		eleUtil.doSendKeysWithWait(emailId, AppConstants.MEDIUM_DEFAULT_TIMEOUT, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		// return eleUtil.waitForTitleToBe(AppConstants.ACCOUNT_PAGE_TITLE,
		// AppConstants.SMALL_DEFAULT_TIMEOUT);
		return new AccountPage(driver);

	}

	@Step("Navigate to register page")
	public RegisterPage gotoRegisterPage() {
		System.out.println("checking navigation of register page");
		eleUtil.doClick(registrationLink);
		return new RegisterPage(driver);
	}

	// without login
	@Step("perform search for the product : {0}")
	public SearchResultPage performSearch(String name) {
		AccountPage accPage = new AccountPage(driver);
		return accPage.doSearch(name);

	}

}
