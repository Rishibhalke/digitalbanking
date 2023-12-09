package pages;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


@Test
public class Base {
	
	public static WebDriver driver;
	public static ExtentReports extentreports;
	 public static ExtentTest extentTest;
	public static void getbrowser() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://dbankdemo.com/bank/login");
		Thread.sleep(5000);
		//driver.findElement(By.id("username")).sendKeys("mrishikeshkumar2007@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("Naveen@12345");
		//driver.findElement(By.id("submit")).submit();
		
		
	}
	@BeforeTest
	public void getnameMethod(ITestContext context)
	{
	extentTest=	extentreports.createTest(context.getName());
	}

	@BeforeSuite  
	public void InitalizeExtentReport()
	{
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("MyReport.html");
	extentreports = new ExtentReports();
	extentreports.attachReporter(sparkreporter);
	// on the report display more information about OS, browser, java etc
	extentreports.setSystemInfo("OS", System.getProperty("os.name"));
	extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));
	 extentreports.setSystemInfo("Host Name", System.getProperty("user.name"));
	 extentreports.setSystemInfo("Browser Name", "Chrome");
	}

	@AfterSuite
	public void generateReports() throws IOException
	{
	extentreports.flush();
	Desktop.getDesktop().browse(new File("MyReport.html").toURI());
	}


	//@AfterMethod
	public String takeScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path ="C:\\Users\\INDIA\\Pictures\\Screenshots\\myscreenshot_"+System.currentTimeMillis()+".png";
		File target = new File(path);
		FileUtils.copyFile(source, target);
		String targetPath = target.getAbsolutePath();
		return targetPath;
	}

}
	
