package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

	private WebDriver driver;
	private By userEmail = By.id("email");
	private By submitButton = By.id("form_submit");

	public ForgotPasswordPage(WebDriver driver){
		this.driver = driver;
	}

	public void setEmail(String email){
		driver.findElement(userEmail).sendKeys(email);

	}

	public EmailSentPage retrievePassword(){
		driver.findElement(submitButton).click();
		return new EmailSentPage(driver);
	}

}
