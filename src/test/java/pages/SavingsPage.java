package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SavingsPage extends Base 
{
	@FindBy(xpath="//*[@id='savings-menu']/i")
	static WebElement Btn_savingsmenu;
	
	@FindBy(xpath="//a[@id='view-savings-menu-item']")
	static WebElement Btn_viewsavingsmenuitem;
	
	@FindBy(xpath="//*[@type='search']")
	static WebElement searchbox_transactionTablefilter;
	
	
	
	public SavingsPage() { 
		 PageFactory.initElements(driver,this); 
		 } 
	
	
	
	public void clickSavingPage(String trn) { 
		 
		// TODO Auto-generated method stub
		
		Btn_savingsmenu.click();
		Btn_viewsavingsmenuitem.click(); 
		searchbox_transactionTablefilter.sendKeys(trn);
		}

	
}
