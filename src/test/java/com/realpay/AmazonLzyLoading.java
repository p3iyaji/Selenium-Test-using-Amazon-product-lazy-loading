package com.realpay;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonLzyLoading {
//	@Test(dataProvider = "loginD")
//	public void f(int n, int s) {
//	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//	}
//
//	@DataProvider
//	public String[][] loginData() {
//		return new String[][] { new String[] { "admin", "pwd" }, new String[] { "invalid", "valid" },
//				new String[] { "right", "wrong" }, };
//	}
//
//	@DataProvider
//	public int[][] loginD() {
//		return new int[][] { new int[] { 11, 2 }, new int[] { 12, 34 }, new int[] { 23, 45 }, };
//	}
//
//	@BeforeClass
//	public void beforeClass() {
//	}
//
//	@AfterClass
//	public void afterClass() {
//	}
//
//	@BeforeTest
//	public void beforeTest() {
//	}
//
//	@AfterTest
//	public void afterTest() {
//	}
//
//	@BeforeSuite
//	public void beforeSuite() {
//	}
//
//	@AfterSuite
//	public void afterSuite() {
//	}

	@Test
	public void Class2Test() {
		System.out.println("class 2 test begins");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("class 2 test before method");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("class 2 test after method");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("class 2 test before class");

	}

	@AfterClass
	public void afterClass() {
		System.out.println("class 2 test afterclass");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("class 2 test before test");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("class 2 test after test");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("class 2 test before suite");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("class 2 test after suite");

	}

}
