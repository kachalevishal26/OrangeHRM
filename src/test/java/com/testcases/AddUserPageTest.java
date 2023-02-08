package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.AddUserPage;
import com.pages.LoginPage;
import com.utils.DataSupplier;
import com.utils.TestUtil;

public class AddUserPageTest extends TestBase {
	AddUserPage addUserPage;
	LoginPage loginPage;
	
	private static final Logger logger =LogManager.getLogger(AddUserPageTest.class);
	
	public AddUserPageTest() {
		super();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object data[][] = DataSupplier.getReport("admin_login");
		
		return data;
	}
	
	@BeforeTest()
	public void setup() {
		initialization();
		addUserPage = new AddUserPage();
		loginPage = new LoginPage();
	logger.info("launch browser");	
	}
	
	@Test(priority = 0, dataProvider = "getData")
	public void navAddUser(String uName,String pwd) {
		loginPage.loginTest(uName, pwd);
		addUserPage.hover();
		addUserPage.navToAddUser();
		logger.info("login and nav to add user page");
	}
	
	@DataProvider
	public Object[][] getExData() {
		Object data[][] = TestUtil.getReport("add_user");
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getExData")
	public void addUser(String role, String eName, String uName, String status, String pwd,
			String cPwd) throws InterruptedException {
		addUserPage.addUser(role, eName, uName, status, pwd, cPwd);
		Thread.sleep(2000);
		addUserPage.searchUser(uName);
		
		logger.info("add user");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("close the browser");
	}
}
