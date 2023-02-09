package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.landingPage;
import PageObjects.loginPage;

import resources.Base;

public class loginTest extends Base {
	
	WebDriver driver;
	Logger log;
	@BeforeMethod
	public void openApplication() throws IOException
	{
		log = LogManager.getLogger(loginTest.class.getName());
        driver=initializeDriver(); 
		log.debug("Initialized browser");
		driver.get(prop.getProperty("url"));
		
	}
	@Test(dataProvider="getLoginData")
	public void login(String email,String passwrd,String expectedResult) throws IOException
	{
		
		
		landingPage lp=new landingPage(driver);
		log.debug("Navigated to landing page");
		lp.myAccountDropDown().click();
		lp.login().click();
		
		loginPage logp=new loginPage(driver);
		log.debug("Navigated to loginpage");
		logp.getemailfield().sendKeys(email);
		logp.getpasswordfield().sendKeys(passwrd);
		logp.loginbutton().click();
		
		AccountPage ap=new AccountPage(driver);
		log.debug("Navigated to Accountpage");
		
		String actualResult=null;
		try
		{
		if(ap.editAccount().isDisplayed())
		{
		     actualResult="success";
		     log.debug("User got logged in");
		}
		}catch(Exception e)
		{
			actualResult="failure";
			log.debug("logging infailure");
		}
		Assert.assertEquals(actualResult, expectedResult);
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			log.info("successful login");
		}else
		{
			log.error("Login failure");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data= {{"anu.aimit.2010@gmail.com","1234","success"},{"dummy@123@gmail.com","3456","failure"}};
		return data;
		
	}

}
