package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends Base
{
	@FindBy(id="username") 
	static WebElement TxtBox_username; 
	
	@FindBy(id="password") 
	static WebElement TxtBox_password; 
	
	@FindBy(id="submit") 
	static WebElement Btn_submit; 
	
	public void enterLoginDetails(String username,String password) 
	{ 
		TxtBox_username.sendKeys("mrishikeshkumar2007@gmail.com"); 
		
		TxtBox_password.sendKeys("Naveen@12345"); 
		
		Btn_submit.click();

	}
	public LoginPage() { 
		 PageFactory.initElements(driver, this);
		}

}

