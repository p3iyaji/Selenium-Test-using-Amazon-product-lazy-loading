package com.realpay;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {
	@Test(groups = { "smoke", "login" })
	public void classTest1() {

		int a = 10;
		int b = 20;
		Assert.assertEquals(a, b);
	}

	@Test(groups = { "smoke" })
	public void classTest2() {
		System.out.println("this is test 2");
	}

	@Test(dependsOnMethods = { "classTest1" }, groups = { "login" })
	public void classTest3() {
		System.out.println("this is test 3");
	}
}
