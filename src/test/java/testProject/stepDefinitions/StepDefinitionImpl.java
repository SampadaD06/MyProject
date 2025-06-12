package testProject.stepDefinitions;

import java.io.IOException;
import testProject.TestComponents.BaseTest;
import testProject.pageobjects.CartPage;
import testProject.pageobjects.CheckoutPage;
import testProject.pageobjects.ConfirmationPage;
import testProject.pageobjects.LandingPage;
import testProject.pageobjects.OrderPage;
import testProject.pageobjects.ProductCataloguePage;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//public class StepDefinitionImpl extends BaseTest{
//	public LandingPage landingPage;
//	public ProductCataloguePage productCataloguePage;
//	
//	@Given ("lands on homepage")
//	public void lands_on_homepage() throws IOException {
//		
//		
//		landingPage = launchApplication();
//		
//	}
//	
//	@Given ("^Logged in with username (.+) and password (.+)$")
//	public void logged_in_with_username_and_password(String name, String password) {
//		productCataloguePage = landingPage. login(name, password);
//	}
//	
//	
//}

public class StepDefinitionImpl extends BaseTest{

	public LandingPage landingPage;
	public ProductCataloguePage productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		//code
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.login(username,password);
	}
	
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) throws InterruptedException
	{
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductAddedToCart(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
		checkoutPage.selectCountry("india");
		 confirmationPage = checkoutPage.goToConfirmationPage();
	}
	

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
    	String confirmMessage = confirmationPage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
    }
    
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
   
    	Assert.assertEquals(landingPage.getErrorMessage(),strArg1);
    	driver.close();
    }


	

    
	
	
	
	
	
}
