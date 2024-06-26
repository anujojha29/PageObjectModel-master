package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@Test(priority=1)
	public void crmLogoImageTest(){
		String logo = homePage.validateCRMImage();
		Assert.assertEquals(logo,"Anuj Ojha");
	}


	@Test(priority=3)
	public void createContactsLinkTest() throws InterruptedException {
		homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
		Thread.sleep(4000);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
