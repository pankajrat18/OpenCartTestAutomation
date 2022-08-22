package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	By cartId = By.id("Cart");

	public boolean addToCart() {
		System.out.println("Product added to cart");
		return true;
	}

}
