package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic is for login feature of opencart application")
@Story("Design a story for login page with url,username,pswd, forgpt link")
public class LoginPageTest extends BaseTest {

	@Test
	@Description("TC-01: login page verification")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String actTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);

	}

	@Test
	@Description("TC-02: login page URL verification")
	@Severity(SeverityLevel.NORMAL)

	public void loginPageUrlTest() {
		String url = loginpage.getLoginPageUrl();
		Assert.assertEquals(url.contains(AppConstants.LOGIN_PAGE_URL_FRACTION), true);

	}

	@Test
	@Description("TC-03: Verify forgot link")
	@Severity(SeverityLevel.BLOCKER)
	public void forgotPswdLinkExistTest() {
		Assert.assertEquals(loginpage.isForgotLinkExist(), true);

	}

	@Test
	@Description("TC-04: Verify user should be able to login post valid credentials")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
	}

	@Test(enabled = false)
	public void footerTest() {
		System.out.println("check all footers");
	}

}
