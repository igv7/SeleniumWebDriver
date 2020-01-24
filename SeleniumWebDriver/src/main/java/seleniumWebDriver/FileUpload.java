package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
		driver.manage().window().maximize();
		
		driver.get("http://images.google.com");
        driver.findElement(By.xpath("//span[@class=\"BwoPOe\"]/parent::div[@jscontroller=\"TJw5qb\"]")).click();
//        driver.findElement(By.xpath("//span[text()='Upload an image']/parent::div[@class='qbtbha sl']")).click();
        driver.findElement(By.xpath("//div[@class='qbtbha sl']/span[@class='bd qbtbtxt qbclr']")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Screenshots\\Testing_01_13_29.png");




//        driver.quit();

	}

}
