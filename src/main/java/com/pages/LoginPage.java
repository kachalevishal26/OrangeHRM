package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	
	// Page Factory or Object Repository
	@FindBy(name = "username")
	WebElement uName;

	@FindBy(name = "password")
	WebElement uPwd;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement loginBtn;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement forgotPwdLink;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement welcomeMsg;

	// Initialize Page Factory or Object Repository
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean forgotPwdLinkVisible() {
		return forgotPwdLink.isDisplayed();
	}

	public void loginTest(String userName, String passWord) {
		uName.sendKeys(userName);
		uPwd.sendKeys(passWord);
		loginBtn.click();
		logger.info("login is performed");
	}

	public boolean verifyLogin() {
		
		logger.info("verify the login");
		return welcomeMsg.isDisplayed();
	}
}
