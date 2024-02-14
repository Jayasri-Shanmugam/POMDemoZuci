
package testScripts;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import base.TestBase;
import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
 
public class PlaceOrderTest {
	WebDriver driver;
	HomePage homePage;
	SearchResultPage resultPage;
	ShoppingCartPage cartPage;
	CheckOutPage chkoutPage;
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver=TestBase.getDriver();
		homePage=new HomePage(driver);
		resultPage=new SearchResultPage(driver);
		cartPage=new ShoppingCartPage(driver);
		chkoutPage=new CheckOutPage(driver);
	}
	@BeforeTest
	public void setup() {
		TestBase.openUrl("http://danube-webshop.herokuapp.com/");
	}
  @Test(priority=1)
  public void addToCartTest()
  {
	  homePage.searchItem("Parry Hotter");
	  resultPage.viewItemDetail();
	  resultPage.addToCart();
	  boolean isAdded=cartPage.isItemAdded();
	  Assert.assertTrue(isAdded);
  }
  @Test(priority=2)
  public void checkoutTest() {
	  cartPage.addCoupon();
	  cartPage.doCheckout();
  }
//  @Test(priority=3)
//  public void Button() {
//	 chkoutPage.radioButton();
//  }
  
  @Test(priority=3)
  public void checkoutPageTest() {
	  chkoutPage.checkMethodTest(driver);
	  chkoutPage.BuyButton();
  }
}
