package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Base;
import pages.LoginPage;
import pages.SavingsPage;
import uties.XLs_DataProvider;

public class TestSavingPage extends Base{
	
	WebDriver d; 
	LoginPage l;
	SavingsPage s;
	@Test(priority = '1')
public void testLoginPage() { 
		
		//l.clicksubmitBtn(); 
		 
		l.enterLoginDetails("mrishikeshkumar2007@gmail.com","Naveen@12345"); 
	}
	
	@Test(priority = '2', dataProvider="testexcel")
	public void testSavingsPage(String trn) 
	{
		
		s.clickSavingPage(trn);
		
		
		
	}

	
	
	
	@BeforeTest()
	public void stepup() throws InterruptedException
	{ 
		getbrowser();
		l= new LoginPage();
		s= new SavingsPage();
		
		
		
	}
	
	
	
	@DataProvider(name="testexcel")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object[] [] input = XLs_DataProvider.getTestData("Sheet1");
		return input;
		
	}

	

}