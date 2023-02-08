package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.utils.DataSupplier;
import com.utils.Log;
import com.utils.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		logger.info("launching chrome browser");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object data[][] = DataSupplier.getReport("admin_login");
		
		return data;
	}
	
	@Test
	public void forgotPwdLinkVerify() {
		loginPage.forgotPwdLinkVisible();
		logger.info("verify forgot password link");
	}
	
	@Test(dataProvider = "getData")
	public void login(String uName, String uPwd) {
		loginPage.loginTest(uName, uPwd);
		loginPage.verifyLogin();
		logger.info("login");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("closing the browser");
	}
}
