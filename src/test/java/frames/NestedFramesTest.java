package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NestedFramesTest extends BaseTests {
	@Test
	public void getNestedFramesTest(){
		var nestedFrames = homePage.clickFrames();
		nestedFrames.switchToLeftFrame();
		assertEquals(nestedFrames.getFrameText(), "LEFT", "Text is incorrect");
		nestedFrames.switchToMainFrame();
		nestedFrames.switchToBottomFrame();
		assertEquals(nestedFrames.getFrameText(), "BOTTOM", "Text is incorrect");
	}

}
