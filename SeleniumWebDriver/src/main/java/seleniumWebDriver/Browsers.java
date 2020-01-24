package seleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
//		WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.driver", projectPath+"src\\main\\resources\\drivers\\MicrosoftWebDriver.exe");
//		System.setProperty("webdriver.edge.driver", projectPath+"src\\main\\resources\\drivers\\msedgedriver.exe");
		
//		WebDriverManager.operadriver().setup();
		System.setProperty("webdriver.opera.driver", projectPath+"src\\main\\resources\\drivers\\operadriver.exe");
		
//		WebDriverManager.phantomjs().setup();
		System.setProperty("phantomjs.binary.path", projectPath+"src\\main\\resources\\drivers\\phantomjs.exe");
		
//		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
//		driver = new EdgeDriver();
//		driver = new OperaDriver();
		driver = new PhantomJSDriver();
		
		System.out.println("Start");
		driver.get("https://google.com");
		System.out.println("End");

	}

}
