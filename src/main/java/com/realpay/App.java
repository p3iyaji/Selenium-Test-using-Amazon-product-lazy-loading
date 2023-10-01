package com.realpay;

public class App {
	public static void main(String[] args) {

		// to import test class from src/test to src/main change contains test in
		// buildpath of amazoneAssignment form No to Yes
		AmazonLazyLoadingTest myTest = new AmazonLazyLoadingTest();
		myTest.openWebpage();
		myTest.testLazyLoading();
		myTest.getNthProdDetails();
		myTest.getAllDisplayedProducts();
		myTest.scrollDownProducts();
		myTest.closeWebpage();
	}
}
