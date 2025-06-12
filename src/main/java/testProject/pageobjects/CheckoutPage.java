package testProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testProject.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	By results = By.cssSelector(".ta-results");
	
	@FindBy(css=".action__submit")
	WebElement Submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	public void selectCountry(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		waitForElementToAppear(results);
		
		SelectCountry.click();
	}
	
	public ConfirmationPage goToConfirmationPage() {
		Submit.click();
		return new ConfirmationPage(driver);
	}
}
