package waits;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class WaitTests extends BaseTests {
	@Test
	public void testWaitUntilHidden(){
		var loadingPage = homePage.clickDynamicLoading().clickExample1();
		loadingPage.startButtonClick();
		assertTrue(loadingPage.getLoadedText().contains("Hello World"), "text not loaded yet");

	}

	@Test
	public void testWaitUntilAvailable(){
		var loadingPage = homePage.clickDynamicLoading().clickExample2();
		loadingPage.startButtonClick();
		assertTrue(loadingPage.getLoadedText().contains("Hello World"), "text not loaded yet");

	}

}
