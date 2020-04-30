package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
	public WebDriver driver;
	public By emailText = By.id("content");

			public EmailSentPage(WebDriver driver){
				this.driver = driver;
			}

			public String getEmailSentText(){
				return driver.findElement(emailText).getText();
			}
}
