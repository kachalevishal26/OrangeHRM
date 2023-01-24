package com.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class AddEmployeePage extends TestBase {
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	
	// Page Factory
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pimHover;

	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmp;

	@FindBy(id = "firstName")
	WebElement fName;

	@FindBy(id = "middleName")
	WebElement mName;

	@FindBy(id = "lastName")
	WebElement lName;

	@FindBy(id = "photofile")
	WebElement photoUpload;

	@FindBy(id = "chkLogin")
	WebElement checkBoxLoginCred;

	@FindBy(id = "user_name")
	WebElement uName;

	@FindBy(id = "user_password")
	WebElement uPwd;

	@FindBy(id = "re_password")
	WebElement cPwd;

	@FindBy(id = "status")
	WebElement statusDd;

	@FindBy(id = "btnSave")
	WebElement saveBtn;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement empList;
	
	@FindBy(id = "empsearch_employee_name_empName")
	WebElement empTxtBox;

	// Initialize Page Factory
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void hover() {
		Actions action = new Actions(driver);
		action.moveToElement(pimHover).build().perform();
		logger.info("Hovering over the user icon");
	}

	public void addEmployee() {
		addEmp.click();
		logger.info("Navigate to add employee page");
	}

	public void fillDetails(String firstName, String midName, String lastName, String profilePic, String userName,
			String password, String cPassword, String status) throws InterruptedException {
		fName.sendKeys(firstName);
		mName.sendKeys(midName);
		lName.sendKeys(lastName);
		photoUpload.sendKeys(profilePic);
		checkBoxLoginCred.click();
		Thread.sleep(1000);
		uName.sendKeys(userName);
		uPwd.sendKeys(password);
		cPwd.sendKeys(cPassword);

		WebElement dd = statusDd;
		Select selectOpt = new Select(dd);
		selectOpt.selectByValue(status);
		saveBtn.click();
		logger.info("Details are filled and the Save button is clicked");
	}
	
	public void empList() throws InterruptedException {
		empList.click();
		Thread.sleep(2000);
		logger.info("Hover over the admmin bar");
	}
	
	public AddUserPage searchEmp(String fullName) throws InterruptedException {
		empTxtBox.sendKeys(fullName);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.sendKeys(empTxtBox,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		logger.info("Search employee");
		return new AddUserPage();
	}

}
