package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
	private WebDriver driver;
	private By slider = By.tagName("input");
	private By sliderValue = By.id("range");

	public HorizontalSliderPage(WebDriver driver){
		this.driver = driver;
	}

	public void moveSlider(int moveSteps){
		for(var i =1; i<=moveSteps; i++){
			driver.findElement(slider).sendKeys(Keys.chord(Keys.ALT, Keys.ARROW_RIGHT));
		}
	}
	public String getSliderValue(){
		return  driver.findElement(sliderValue).getText();
	}
}
