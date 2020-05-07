package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
	private WebDriver driver;
	private By startButton = By.tagName("button");
	private By loadedText = By.id("finish");

	public DynamicLoadingExample2Page(WebDriver driver){
		this.driver = driver;
	}

	public void fluentWait(By element){
		FluentWait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}

	public void implicitWait( By element){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void startButtonClick(){
		driver.findElement(startButton).click();
		implicitWait(loadedText);
	}

	public String getLoadedText(){
		return driver.findElement(loadedText).getText();
	}

}
