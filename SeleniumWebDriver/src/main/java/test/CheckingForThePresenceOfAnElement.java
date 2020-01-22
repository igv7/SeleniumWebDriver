package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckingForThePresenceOfAnElement {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
		driver.manage().window().maximize();
		
		driver.get("http://github.com");
		
//		System.out.println(driver.findElements(By.xpath("//a")).size());
//		if (driver.findElements(By.xpath("//a")).size() > 0) System.out.println("Such element is presented");
//        else System.out.println("Cannot find such element");
		
		System.out.println(driver.findElements(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']")).size());
		if (driver.findElements(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']")).size() > 0) System.out.println("Such element is presented");
        else System.out.println("Cannot find such element");

//        if (driver.findElements(By.xpath("//a[text()='Log in']")).size() > 0) System.out.println("Such element is presented");
//        else System.out.println("Cannot find such element");


//        driver.quit();

	}

}
