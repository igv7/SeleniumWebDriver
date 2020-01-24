package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";
	static String google = "https://google.com";
	static String selenium = "https://selenium.dev/";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(900, 600));
		
		driver.get(google);
		driver.navigate().to(selenium);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
//		driver.close();
	}

}
