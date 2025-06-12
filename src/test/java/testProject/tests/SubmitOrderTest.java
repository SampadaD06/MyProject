package testProject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import testProject.TestComponents.BaseTest;
import testProject.pageobjects.CartPage;
import testProject.pageobjects.CheckoutPage;
import testProject.pageobjects.ConfirmationPage;
import testProject.pageobjects.LandingPage;
import testProject.pageobjects.OrderPage;
import testProject.pageobjects.ProductCataloguePage;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";
//   @Test(dataProvider="getData1",groups= {"Purchase"})
//	public void submitOrder(String username,String password,String productname) throws InterruptedException, IOException {
//		
//		
//		
//		ProductCataloguePage productCataloguePage=landingPage.login(username,password);
//
//		
//			List<WebElement> products = productCataloguePage.getProductList();
//			
//		
//	
//			productCataloguePage.addProductToCart(productname);
//			CartPage cartPage= productCataloguePage.goToCartPage();
//			
//			
//	Boolean match = cartPage.VerifyProductAddedToCart(productname);
//	Assert.assertTrue(match);
//	CheckoutPage checkoutPage= cartPage.goToCheckoutPage();
//	checkoutPage.selectCountry("india");
//	
//	ConfirmationPage confirmationPage = checkoutPage.goToConfirmationPage();	
//	String confirmMessage =confirmationPage.getConfirmMessage();
//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	
//	}
   @Test(dataProvider="getData",groups= {"Purchase2"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		
		
		
		ProductCataloguePage productCataloguePage=landingPage.login(input.get("email"), input.get("password"));

		
			List<WebElement> products = productCataloguePage.getProductList();
			
		
	
			productCataloguePage.addProductToCart(input.get("product"));
			CartPage cartPage= productCataloguePage.goToCartPage();
			
			
	Boolean match = cartPage.VerifyProductAddedToCart(input.get("product"));
	Assert.assertTrue(match);
	CheckoutPage checkoutPage= cartPage.goToCheckoutPage();
	checkoutPage.selectCountry("india");
	
	ConfirmationPage confirmationPage = checkoutPage.goToConfirmationPage();	
	String confirmMessage =confirmationPage.getConfirmMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
   @Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		
		ProductCataloguePage productCatalogue = landingPage.login("sampada@gmail.com", "Sampada123");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
}
   @DataProvider
	  public Object[][] getData1()
	  {
	    return new Object[][]  {{"sampada@gmail.com","Sampada123","ZARA COAT 3"}, {"dipa1@gmail.com","Dipa1602","ADIDAS ORIGINAL" } };
	    
	  }
   @DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\testProject\\data\\data.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}
}
