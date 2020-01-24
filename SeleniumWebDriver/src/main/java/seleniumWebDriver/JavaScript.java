package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScript {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
//		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.manage().window().maximize();
				
		driver.get("http://en.wikipedia.org/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("alert('Hello World!');");
        jse.executeScript("window.scrollBy(0, 1000)", "");
        jse.executeScript("window.scrollBy(0, -1000)", "");


//        driver.quit();
		
	}

}
