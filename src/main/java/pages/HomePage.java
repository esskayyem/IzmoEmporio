package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(id = "logoImg")
	WebElement homePageTitle;

	@FindBy(xpath = "//ul//li[5]//a[contains(text(),'DEMO')]")
	WebElement demoLink;
	
	@FindBy(xpath = "//a[@href='https://nissan360.izmoemporio.com/emporio-en-us.htm']")
	WebElement nissanLink;
	

	@FindBy(xpath = "//img[@src='https://s3-us-west-2.amazonaws.com/assets.izmocars.com/userfiles/105987/brandlogos/Volkswagen.png']")
	WebElement nissanImg;

	@FindBy(xpath = "//a[contains(text(),'Nissan')]")
	WebElement nissanText;
	
	@FindBy(xpath = "//img[@src='https://d36rdz5czc3q29.cloudfront.net/resources/O41637e8e-a/logos/file_11955_lti_20210601-070922.jpg']")
	WebElement nissanAltima;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement nissanAltimaModal;

	@FindBy(xpath = "//h2[contains(text(),'Nissan Altima')]")
	@CacheLookup
	WebElement nissanAltimaText;

public  HomePage() { 
	PageFactory.initElements(driver, this);

}
	
public  void verifyHomePageTitle(){
	homePageTitle.isDisplayed();
	String title = homePageTitle.getAttribute("title"); 
	Assert.assertEquals(title, "izmoEmporio at San Francisco");		 
	System.out.println("The title displayed is: " + title);
	demoLink.click();
	nissanLink.click();
	driver.switchTo().frame(0);
     nissanAltima.click();
 	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
     Assert.assertTrue(nissanAltimaModal.isDisplayed());
     Assert.assertTrue(nissanAltimaText.isDisplayed());
 	 String text = nissanAltimaText.getText(); 
 	 Assert.assertEquals(text, "Nissan Altima");		 
 	 System.out.println("The text displayed is: " + text);

	}
	
}




