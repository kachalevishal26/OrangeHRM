package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.utils.DataSupplier;
import com.utils.TestUtil;

public class EmployeeLoginPageTest extends TestBase {
	LoginPage loginPage;
	
	private static final Logger logger = LogManager.getLogger(EmployeeLoginPageTest.class);

	public EmployeeLoginPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		logger.info("launch browser");
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = DataSupplier.getReport("employee_login");
		return data;
	}

	@Test(dataProvider = "getData")
	public void login(String uName, String uPwd) {
		loginPage.loginTest(uName, uPwd);
		loginPage.verifyLogin();
		logger.info("Employee login");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("close browser");
	}
}
