package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import resources.Base;

public class FourTest extends Base{

	public WebDriver driver;
	@Test
	public void testFour() throws IOException, InterruptedException
	{
		System.out.println("Inside testFour");
		driver=initializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		Assert.assertTrue(false);
		
		
	}
	@AfterMethod
	public void closure()
	{
		driver.close();
	}
}