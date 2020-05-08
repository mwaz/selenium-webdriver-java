package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

	private EventFiringWebDriver driver;
	protected HomePage homePage;

	@BeforeMethod
	public void goHome(){
		driver.get(Links.URL);
		homePage = new HomePage(driver);
	}

	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new EventReporter());
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		goHome();
	}
	@AfterClass
	public  void TearDown(){
		driver.quit();
	}

	public WindowManager getWindowManager(){
		return new WindowManager(driver);
	}

	@AfterMethod
	public void recordFailure(ITestResult result) {
		if (ITestResult.SUCCESS == result.getStatus()) {

			var camera = (TakesScreenshot) driver;
			File screenshot = camera.getScreenshotAs(OutputType.FILE);
			System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());

			try {

				Files.move(screenshot, new File("resources/screenshots/test.png"));
			}
			catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
