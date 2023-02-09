package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRpt {
	public static ExtentReports getExtentReport()
	{
		
	String extentreporterpath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(extentreporterpath);
	reporter.config().setReportName("Tutorials Ninja Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extentReporter =new ExtentReports();
	extentReporter.attachReporter(reporter);
	extentReporter.setSystemInfo("Operation System", "Windows 10");
	extentReporter.setSystemInfo("Tested By", "Arun Motoori");
	
	return extentReporter;
	}
	

}
