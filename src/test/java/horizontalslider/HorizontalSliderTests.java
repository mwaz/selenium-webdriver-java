package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HorizontalSliderTests extends BaseTests {
	@Test
	public void testHorizontalSlider(){
		var keyPage = homePage.clickHorizontalSlider();
		keyPage.moveSlider(8);
		assertEquals(keyPage.getSliderValue(), "4");
	}

}
