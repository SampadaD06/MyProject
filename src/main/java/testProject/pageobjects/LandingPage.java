package testProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testProject.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	 
	@FindBy(id="login")
	WebElement elem;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCataloguePage login(String name,String pass)
	{
		userEmail.sendKeys(name);
		userPassword.sendKeys(pass);
		elem.click();
		ProductCataloguePage productCataloguePage= new ProductCataloguePage(driver);
		return productCataloguePage;
	}
	
	public void goTo()
	{driver.get("https://rahulshettyacademy.com/client");}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}

