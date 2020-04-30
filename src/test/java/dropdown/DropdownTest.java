package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DropdownTest  extends BaseTests {

	@Test
	public void  testSelectOption(){
		String option = "Option 1";

		var dropDropdownPage = homePage.clickDropdown();
		dropDropdownPage.selectFromDropDown(option);
		var selectedOptions = dropDropdownPage.getSelectedOptions();

		assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
		assertTrue(selectedOptions.contains(option), "Option not selected");

	}
}
