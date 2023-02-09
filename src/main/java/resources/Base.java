package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public Properties prop;
	WebDriver driver=null;
	public String takeScreenshot(String testName,WebDriver driver) throws IOException
	{
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFileToDirectory(src, new File(destinationFilePath));
		
		return destinationFilePath;
		
	}
	public WebDriver initializeDriver() throws IOException
	{
		
	
		prop=new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		
		String browsername=prop.getProperty("browsername");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("Microsoft Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

}
