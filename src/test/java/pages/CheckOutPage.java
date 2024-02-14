package pages;
 
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CheckOutPage {
	@FindBy(id="s-name")
	WebElement name;
	
	@FindBy(id="s-surname")
	WebElement surname;
	
	@FindBy(id="s-address")
	WebElement address;
	
	@FindBy(id="s-zipcode")
	WebElement zipcode;
	
	@FindBy(id="s-city")
	WebElement city;
	
	@FindBy(id="s-company")
	WebElement company;
	
	@FindBy(xpath="//button[text()='Buy']")
	WebElement buyBtnClick;
	
	@FindBy(xpath="//label[contains(text(),'as soon as possible')]")
	WebElement radiobutton;
	@FindBy(id="billing-different")
	WebElement checkbx;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkMethodTest(WebDriver driver) {
		name.sendKeys("tamil");
		surname.sendKeys("KA");
		address.sendKeys("jsdnjsnfkdfk");
		zipcode.sendKeys("636119");
		city.sendKeys("Chennai");
		company.sendKeys("ZuciSystems");
		//checkbx.click();
//		WebDriverWait wait =new WebDriverWait(driver, Duration.	ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(buyBtnClick));
		
//		buyBtnClick.click();
	
	}
	
//	public void radioButton()
//	{
//		radiobutton.click();
//	}
	
	/*public void BuyButton()
	{
		buyBtnClick.click();
	}*/
	public void BuyButton()
	{
		try
		{
			buyBtnClick.click();
		}
		catch(Exception e)
		{
			for(int i=0;i<1;i++)
			{
				buyBtnClick.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
				if(buyBtnClick.isDisplayed())
				{
					buyBtnClick.click();
					break;
				}
			}
			if(!buyBtnClick.isDisplayed())
			{
				throw new NoSuchElementException("button not found");
			}
		}
	}
}