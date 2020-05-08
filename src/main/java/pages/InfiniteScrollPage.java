package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
	private WebDriver driver;
	private By textBlocks = By.className("jscroll-added");

	public InfiniteScrollPage(WebDriver driver){
		this.driver = driver;
	}

	public void scrollToParagraph(int index){
		var jsExecutor = (JavascriptExecutor)driver;
		String script = "window.scrollTo(0, document.body.scrolleight)";
		while(getNumberOfParagraphsPresent() < index){
			jsExecutor.executeScript(script);

		}
	}

	private int getNumberOfParagraphsPresent(){
		return driver.findElements(textBlocks).size();
	}


}
