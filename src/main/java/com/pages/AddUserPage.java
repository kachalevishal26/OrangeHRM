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

public class AddUserPage extends TestBase {
	
	private static final Logger logger = LogManager.getLogger(AddUserPage.class);
	
	Actions action = new Actions(driver);

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement admin;
	
	@FindBy(id = "menu_admin_UserManagement")
	WebElement userMgmt;
	
	@FindBy(id = "menu_admin_viewSystemUsers")
	WebElement users;
	
	@FindBy(id = "btnAdd")
	WebElement addUserBtn;
	
	@FindBy(id = "systemUser_userType")
	WebElement userRoleDd;
	
	@FindBy(id = "systemUser_employeeName_empName")
	WebElement empName;
	
	@FindBy(id = "systemUser_userName")
	WebElement userName;
	
	@FindBy(id = "systemUser_status")
	WebElement userStatus;
	
	@FindBy(id = "systemUser_password")
	WebElement uPwd;
	
	@FindBy(id = "systemUser_confirmPassword")
	WebElement uCpwd;
	
	@FindBy(id = "btnSave")
	WebElement saveBtn;
	
	@FindBy(id = "searchSystemUser_userName")
	WebElement searchBoxUser;
	
	@FindBy(id = "searchBtn")
	WebElement searchUserBtn;
	
	public AddUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void hover() {
		action.moveToElement(admin).build().perform();
		action.moveToElement(userMgmt).build().perform();
		users.click();
		logger.info("hover over the menu bar");
	}

	public void navToAddUser() {
		addUserBtn.click();
		logger.info("navigate to add user page");
	}
	
	public void addUser(String role, String eName, String uName, String status, String pwd,
			String cPwd) throws InterruptedException {
		Thread.sleep(1000);
		Select selRole = new Select(userRoleDd);
		selRole.selectByVisibleText(role);
		empName.sendKeys(eName);
		action.sendKeys(empName,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		userName.sendKeys(uName);
		Select selStatus = new Select(userStatus);
		selStatus.selectByVisibleText(status);
		uPwd.sendKeys(pwd);
		uCpwd.sendKeys(cPwd);
		Thread.sleep(2000);
		saveBtn.click();
		logger.info("details are filled and submit the form");
	}
	
	public void searchUser(String uName) throws InterruptedException {
		searchBoxUser.sendKeys(uName);
		Thread.sleep(1000);
		searchUserBtn.click();
		Thread.sleep(3000);
		logger.info("search user");
	}
}