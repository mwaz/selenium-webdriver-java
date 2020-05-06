package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
	private  WebDriver driver;
	private String leftFrame = "frame-left";
	private String topFrame = "frame-top";
	private String bottomFrame = "frame-bottom";
	private By bodyElement = By.tagName("body");

	public FramesPage(WebDriver driver){
		this.driver = driver;
	}

	public void switchToMainFrame(){
		driver.switchTo().parentFrame();
	}

	public void switchToBottomFrame(){
		driver.switchTo().frame(bottomFrame);

	}

	public void switchToLeftFrame(){
		driver.switchTo().frame(topFrame);
		driver.switchTo().frame(leftFrame);
	}

	public String  getFrameText(){
		String text = driver.findElement(bodyElement).getText();
		switchToMainFrame();
		return text;
	}

}
