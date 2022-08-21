package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertEquals(accPage.isLogouttLinkExist(), true);

	}

	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderTest() {
		List<String> actSectionHeaderList = accPage.getAccountSectionHeader();
		System.out.println("------actual headers" + actSectionHeaderList);
		Collections.sort(actSectionHeaderList);
		Collections.sort(AppConstants.EXPECTED_ACCOUNT_HEADERS_LIST);
		Assert.assertEquals(actSectionHeaderList, AppConstants.EXPECTED_ACCOUNT_HEADERS_LIST);
	}

}
