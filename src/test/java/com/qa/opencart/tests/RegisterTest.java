package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterTest extends BaseTest {

	@BeforeClass
	public void regSetUp() {
		regPage = loginpage.gotoRegisterPage();
	}

//	@DataProvider
//	public Object[][] getRegData() {
//		return new Object[][] {
//
//				{ "Pank", "Rat", "pank@gmail.com", "7878777777", "", "Yes" },
//				{ "Pon", "Ghu", "pon@gmail.com", "7878777790", "pon@1234", "No" },
//				{ "Garry", "Rad", "garry@gmail.com", "7878777755", "garry1234", "Yes" },
//
//		};
//
//	}

	public String randomEmail() {
		Random rand = new Random();
		String email = "automation" + rand.nextInt(500) + "@gmail.com";
		return email;

	}

	@DataProvider
	public Object[][] getExcelTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;

	}

	@Test(dataProvider = "getExcelTestData")
	public void userRegTest(String firstName, String lastName, String phone, String password, String subscribe) {
		boolean successFlag = regPage.newUserRegistration(firstName, lastName, randomEmail(), phone, password,
				subscribe);

		regPage.goToRegisterPage();

		Assert.assertEquals(successFlag, true);
	}

}
