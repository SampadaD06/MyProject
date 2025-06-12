package testProject.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testProject.TestComponents.BaseTest;
import testProject.pageobjects.CartPage;
import testProject.pageobjects.ProductCataloguePage;
import testProject.TestComponents.Retry;
public class ErrorValidationsTest extends BaseTest{
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
public void LoginErrorValidation() throws InterruptedException, IOException {
		
		landingPage.login("sampada@gmail.com","Sampada12");
		Assert.assertEquals("Incorrect email aor password.",landingPage.getErrorMessage());

	}

   
   @Test
   public void ProductErrorValidation() throws InterruptedException, IOException {
   		
	   String productName = "ZARA COAT 3";
		
		
		ProductCataloguePage productCataloguePage=landingPage.login("dipa1@gmail.com","Dipa1602");

		
			List<WebElement> products = productCataloguePage.getProductList();
			
		
	
			productCataloguePage.addProductToCart(productName);
			CartPage cartPage= productCataloguePage.goToCartPage();
			
			
	Boolean match = cartPage.VerifyProductAddedToCart("abc");
	Assert.assertFalse(match);

   	}
}
