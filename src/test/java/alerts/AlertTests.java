package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
	@Test
	public void testAlerts(){
		var alertsPage = homePage.clickJavaScriptAlerts();
		alertsPage.triggerAlert();
		alertsPage.acceptAlert();
		assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
	}

}
