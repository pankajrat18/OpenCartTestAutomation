package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	public static final int SMALL_DEFAULT_TIMEOUT = 5;
	public static final int MEDIUM_DEFAULT_TIMEOUT = 10;
	public static final int LONG_DEFAULT_TIMEOUT = 20;

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "route=account/account";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final List<String> EXPECTED_ACCOUNT_HEADERS_LIST = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	public static final String PRODUCT_SEARCH_TITLE = "MacBook Pro";
	public static final String REG_SUCCESS_MSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";

}
