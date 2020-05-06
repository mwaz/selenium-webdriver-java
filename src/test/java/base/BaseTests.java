package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {

	private WebDriver driver;
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
		driver = new ChromeDriver();
//		driver.get(Links.URL);
//		homePage = new HomePage(driver);
		goHome();
	}
	@AfterClass
	public  void TearDown(){
		driver.quit();
	}

}
