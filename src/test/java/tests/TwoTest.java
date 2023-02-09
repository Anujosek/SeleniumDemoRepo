package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	
	@Test
	public void testtwo() throws IOException, InterruptedException
	{
		System.out.println("Inside testtwo");
		WebDriver driver=initializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
	}
	}
	
	
