package com.realpay;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonLazyLoadingTest {

	ChromeDriver driver = new ChromeDriver();
	String url = "https://amazon.in";

	@Test
	public void openWebpage() {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void testLazyLoading() {
		driver.get(url);

		// getting the webElements

		WebElement category = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

		Select selCategory = new Select(category);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		selCategory.selectByVisibleText("Electronics");

		searchBox.sendKeys("iPhone 13");
		searchBtn.click();

	}

	@Test
	public void getNthProdDetails() {

		int nthProd;

		Scanner getProduct = new Scanner(System.in);
		System.out.println("Please select a number between 1 - 26 of product to get Details: ");

		nthProd = getProduct.nextInt();

		System.out.println();

		driver.get(url);

		// getting the webElements

		WebElement category = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

		Select selCategory = new Select(category);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		selCategory.selectByVisibleText("Electronics");

		searchBox.sendKeys("iPhone 13");
		searchBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement nthItem = driver
				.findElement(By.xpath(" //div[@data-component-type='s-search-result'][" + nthProd + "]"));
		try {
			wait.until(ExpectedConditions.visibilityOf(nthItem));
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement nthItemTitle = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][" + nthProd
				+ "]" + "//span[contains(@class, 'a-size')]"));

		WebElement nthItemPrice = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][" + nthProd
				+ "]" + "//span[contains(@class, 'a-price-whole')]"));

		System.out.println("Nth Product Located With The Following Details:");
		System.out.println("=================================================");
		System.out.println("Product " + nthProd + " Title: " + nthItemTitle.getText());
		System.out.println("Product " + nthProd + " Price: " + nthItemPrice.getText());

		getProduct.close();

	}

	@Test
	public void getAllDisplayedProducts() {
		List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

		System.out.println("List of all Displayed Products:");

		for (int i = 1; i <= products.size(); i++) {
			try {
				WebElement nthItemTitle = driver.findElement(By.xpath("//div[@data-component-type='s-search-result']["
						+ i + "]" + "//span[contains(@class, 'a-size')]"));

				System.out.println("=================================================");
				System.out.println(i + ". Product Title: " + nthItemTitle.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Test
	public void scrollDownProducts() {
		driver.navigate().back();

		// getting the webElements

		WebElement category = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

		Select selCategory = new Select(category);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		selCategory.selectByVisibleText("Electronics");

		searchBox.sendKeys("iPhone 13");
		searchBtn.click();

		List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

		int lastElement = (products.size() - 1);
		WebElement lastProd = driver
				.findElement(By.xpath("//div[@data-component-type='s-search-result'][" + lastElement + "]"));
		JavascriptExecutor js = driver;
		// js.executeScript("window.scrollBy(0, 350)", "");
		js.executeScript("arguments[0].scrollIntoView();", lastProd);
	}

	public void closeWebpage() {
		// driver.close();
	}

}
