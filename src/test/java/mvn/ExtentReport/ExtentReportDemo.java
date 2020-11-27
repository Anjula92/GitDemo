package mvn.ExtentReport;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);//class which configure the extent reoport
	reporter.config().setReportName("Autiomation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	extent = new ExtentReports();//Main class which generates the report
	extent.attachReporter(reporter);//have to pass the object of ExtentSparkReporter
	extent.setSystemInfo("Tester", "Anj");
	}

	@Test
	
	public void demo() {
		extent.createTest("Demo test");
		System.out.println("ExtentReport");
		Assert.assertTrue(true);
		extent.flush();
	}
}
