package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.AddEmployeePage;
import com.pages.LoginPage;
import com.utils.DataSupplier;
import com.utils.TestUtil;

public class AddEmployeePageTest extends TestBase {
	AddEmployeePage addEmp;
	LoginPage loginPage;
	
	private static final Logger logger = LogManager.getLogger(AddEmployeePageTest.class);

	@BeforeTest
	public void setup() {
		initialization();
		addEmp = new AddEmployeePage();
		loginPage = new LoginPage();
		logger.info("launch browser");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object data[][] = DataSupplier.getReport("admin_login");

		return data;
	}

	@Test(dataProvider = "getLoginData")
	public void login(String uName, String uPwd) {
		loginPage.loginTest(uName, uPwd);
		logger.info("login");
	}

	@DataProvider
	public Object[][] getRegData() {
		Object data[][] = TestUtil.getReport("add_employee");
		return data;
	}
	
	@DataProvider
	public Object[][] getsearchEmpData() {
		Object data[][] = TestUtil.getReport("search_employee");
		return data;
	}

	@Test(dataProvider = "getRegData")
	public void addEmpTest(String firstName, String midName, String lastName, String profilePic, String userName,
			String password, String cPassword, String status) throws InterruptedException {
		addEmp.hover();
		addEmp.addEmployee();
		addEmp.fillDetails(firstName, midName, lastName, profilePic, userName, password, cPassword, status);
		logger.info("add employee test");
	}
	
	@Test(dataProvider = "getsearchEmpData")
	public void searchEmp(String fName) throws InterruptedException {
		Thread.sleep(2000);
		addEmp.hover();
		addEmp.empList();
		addEmp.searchEmp(fName);
		logger.info("search employee");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("close browser");
	}
}
