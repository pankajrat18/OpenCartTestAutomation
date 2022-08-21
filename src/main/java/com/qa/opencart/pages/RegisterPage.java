package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// By locator

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By phone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPsw = By.id("input-confirm");

	private By subscriberYes = By.xpath("(//input[contains(@name,'newsletter')])[1]");
	private By subscriberNo = By.xpath("(//input[contains(@name,'newsletter')])[2]");

	private By checkbox = By.xpath("//input[contains(@type,'checkbox')]");
	private By submitButton = By.xpath("//input[contains(@type,'submit')]");
	private By successMsg = By.xpath("//div[contains(@id,'content')]/h1");

	private By registerLink = By.linkText("Register");
	private By logoutLink = By.linkText("Logout");

	// Constructor

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// page actions

	public boolean newUserRegistration(String firstName, String lastName, String email, String phone, String password,
			String subscribe) {
		eleUtil.doSendKeysWithWait(this.firstName, AppConstants.MEDIUM_DEFAULT_TIMEOUT, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.phone, phone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmPsw, password);

		if (subscribe.equalsIgnoreCase("Yes")) {
			eleUtil.doClick(subscriberYes);
		} else {
			eleUtil.doClick(subscriberNo);

		}

		eleUtil.doClick(checkbox);
		eleUtil.doClick(submitButton);
		String actualmsg = eleUtil.waitForElementVisible(successMsg, AppConstants.MEDIUM_DEFAULT_TIMEOUT).getText();
		System.out.println("Reg msg is " + actualmsg);

		if (actualmsg.contains(AppConstants.REG_SUCCESS_MSG)) {
			return true;
		}

		return false;
	}

	public void goToRegisterPage() {
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);
	}

}
