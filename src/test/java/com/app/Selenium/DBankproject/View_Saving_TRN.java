package com.app.Selenium.DBankproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class View_Saving_TRN {
	
public static WebDriver driver;
	
	public static void getbrowser() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://dbankdemo.com/bank/login");
		driver.findElement(By.id("username")).sendKeys("mrishikeshkumar2007@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Naveen@12345");
		driver.findElement(By.id("submit")).submit();
		
		//driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/a']"));
		//Thread.sleep(6000);
		//driver.findElement(By.xpath("//*[@id='savings-menu']/i")).click();
		driver.findElement(By.xpath("//i[@class='menu-icon fa fa-money']")).click();
		//driver.findElement(By.xpath("//*[@id=\'savings-menu\']")).click();
		
		
		driver.findElement(By.xpath("//a[@id='view-savings-menu-item']")).click();
		//driver.findElement(By.xpath("//*[@id=\"transactionTable_filter\"]/label/input")).sendKeys("845586398");
		driver.findElement(By.xpath("//*[@type='search']")).sendKeys("845586398");
		Thread.sleep(5000);
		driver.close();
		
	}

}
