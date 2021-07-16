package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserUtility {
	
	//public static WebDriver driver;
	

	public static WebDriver OpenBrowser(WebDriver driver) {
	
		String browsername= PropertyFilereader.getProperties("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", PropertyFilereader.Projectpath +"\\Resources\\BrowserBinaries\\chromedriver.exe");
			
			System.out.println(browsername);
			//WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().version("2.33").setup();
			
			
			/*ChromeOptions options = new ChromeOptions();
			 options.addArguments("--disable-features=VizDisplayCompositor");
			 options.addArguments("disable-gpu");
			 options.addArguments("--incognito"); 
			 options.addArguments("enable-automation");
			 options.addArguments("--headless");
			 options.addArguments("--no-sandbox");
			 options.addArguments("--window-size=1920,1080");
			 options.addArguments("--disable-extensions");
			 options.addArguments("--dns-prefetch-disable");
			 options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			 
			driver=new ChromeDriver(options);*/
			
			
			driver=new ChromeDriver();
			System.out.println("chrome driver is set");
			
			 LaunchUrl(driver);
			
			return driver;
		}else if (browsername.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",PropertyFilereader.Projectpath +"\\Resources\\BrowserBinaries\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox driver is set");
			
			 LaunchUrl(driver);
			return driver;
		}else
			return null;	 
		
	}
	
	public static void LaunchUrl(WebDriver driver) {
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtil.Implicit_Wait, TimeUnit.SECONDS);
		
		 driver.get(PropertyFilereader.getProperties("url"));	 
		
	}
	
	

}
