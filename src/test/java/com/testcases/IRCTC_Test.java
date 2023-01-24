package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase1;
import com.pages.IRCTC_Page;

public class IRCTC_Test extends TestBase1 {
	IRCTC_Page irctc;
	
	public IRCTC_Test() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		irctc = new IRCTC_Page();
	}
	
	@Test
	public void call() throws InterruptedException {
		irctc.alerts();
		irctc.location();
		irctc.tripDate();
	}
}
