package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.AccountPage;
import PageObjects.landingPage;
import PageObjects.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import resources.Base;

public class login extends Base{
	
	WebDriver driver;
	 landingPage lp;
	 loginPage logp;
	 AccountPage ap;
	 @Given("^I navigate to the login page of the application$")
	    public void i_navigate_to_the_login_page_of_the_application() throws IOException, InterruptedException{
		 driver=initializeDriver(); 
		 driver.get(prop.getProperty("url"));
		 lp=new landingPage(driver);
		lp.myAccountDropDown().click();
		Thread.sleep(3000);
			lp.login().click();
	    }

	    @When("^I enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	    public void i_enter_username_as_something_and_password_as_something(String email, String passwrd) {
	    	logp=new loginPage(driver);
	    	
	    	logp.getemailfield().sendKeys(email);
			logp.getpasswordfield().sendKeys(passwrd);
			
	    }
	    @And("^I clicked on Login button$")
	    public void i_clicked_on_login_button() throws InterruptedException {
	    	Thread.sleep(3000);
	    	logp.loginbutton().click();
	    	Thread.sleep(3000);
	    }

	    @Then("^I should be able login successfully$")
	    public void i_should_be_able_login_successfully() throws InterruptedException {
	    	Thread.sleep(3000);
	       ap=new AccountPage(driver);
	    	Thread.sleep(3000);
	       Assert.assertTrue(ap.editAccount().isDisplayed());
	    }

	   
	    @After
	    public void closeBrowser()
	    {
	    	driver.close();
	    }
	   

}
