package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class clickWysiwygEditorPage {
	private WebDriver driver;
	private String editorIframeId = "mce_0_ifr";
	private By decreaseIndentButton = By.cssSelector("#mceu_12 button");
	private By textArea = By.id("tinymce");

	public clickWysiwygEditorPage(WebDriver driver){
		this.driver = driver;
	}

	public void switchToEditArea(){
		driver.switchTo().frame(editorIframeId);
	}

	public void clearTextArea(){
		switchToEditArea();
		driver.findElement(textArea).clear();
		switchToMainArea();
	}

	private void switchToMainArea(){
		driver.switchTo().parentFrame();
	}

	public void setTextArea(String text){
		switchToEditArea();
		driver.findElement(textArea).sendKeys(text);
		switchToMainArea();
	}

	public void decreaseIndention(){
		driver.findElement(decreaseIndentButton).click();
	}

	public String getTextFromEditor(){
		switchToEditArea();
		String text = driver.findElement(textArea).getText();
		switchToMainArea();
		return text;
	}


}
