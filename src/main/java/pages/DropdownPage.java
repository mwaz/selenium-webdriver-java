package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage {
	private WebDriver driver;
	private By  dropdown = By.id("dropdown");

	public DropdownPage(WebDriver driver){
		this.driver = driver;
	}

	public  void selectFromDropDown(String option){
		Select dropdownElement = new Select(driver.findElement(dropdown));
		dropdownElement.selectByVisibleText(option);

	}

	private Select findDropDownElement(){
		return new Select(driver.findElement(dropdown));
	}

	public List<String> getSelectedOption(){
		findDropDownElement().getAllSelectedOptions();
	}

}
