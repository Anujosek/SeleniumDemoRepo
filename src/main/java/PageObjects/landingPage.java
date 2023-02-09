package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@title='My Account']")
	private WebElement MyAccount;
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	public WebElement myAccountDropDown()
	{
		return MyAccount;
	}
	public WebElement login()
	{
		return login;
	}
}
