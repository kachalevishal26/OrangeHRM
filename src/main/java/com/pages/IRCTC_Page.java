package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase1;

public class IRCTC_Page extends TestBase1 {
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(xpath = "//div[@class='ng-tns-c19-2 ui-dialog-content ui-widget-content']")
	WebElement alertBox;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement alertBtn;

	@FindBy(xpath = "//input[@class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement fromLoc;

	@FindBy(xpath = "//input[@class='ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement toLoc;

	@FindBy(xpath = "//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")
	WebElement deptDate;

	public IRCTC_Page() {
		PageFactory.initElements(driver, this);
	}

	public void alerts() {
		if (alertBox.isDisplayed()) {
			alertBtn.click();
		}
	}

	public void location() throws InterruptedException {
		Thread.sleep(2000);
		fromLoc.sendKeys("Mumbai");
		Thread.sleep(2000);
		action.keyDown(fromLoc, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);
		toLoc.sendKeys("Hyderabad");
		Thread.sleep(2000);
		action.keyDown(toLoc, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void tripDate() throws InterruptedException {
		if (deptDate.isDisplayed()) {
			deptDate.click();
		}
		Thread.sleep(2000);

		String monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")).getText();
		System.out.println(monthYear);

		while (!(monthYear.equals("January2023"))) {
			driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']")).click();
			monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")).getText();
			System.out.println(monthYear);
		}
		driver.findElement(By.xpath("//td//a[text()='26']")).click();
	}
}
