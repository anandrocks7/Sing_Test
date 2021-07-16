package stepDefinitions;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.BrowserUtility;

public class Hooks {

	private static  WebDriver driver;

	@Before
	public  void setup()  {

		System.out.println("setup is happenning");
		driver = BrowserUtility.OpenBrowser(driver);

	}

	@After
	public void teardown() {
		System.out.println("driver quitting now");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
