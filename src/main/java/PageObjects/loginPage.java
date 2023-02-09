package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	 public loginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(id="input-email")
	 private WebElement emailfield;
	 
	 @FindBy(id="input-password")
	 private WebElement passwordfield;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 private WebElement loginbutton;
	 
	 public WebElement getemailfield()
	 {
		 return emailfield;
	 }
	 public WebElement getpasswordfield()
	 {
		 return passwordfield;
	 }
	 public WebElement loginbutton()
	 {
		 return loginbutton;
	 }
}
