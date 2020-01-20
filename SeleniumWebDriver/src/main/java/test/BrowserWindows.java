package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserWindows {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		
		driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Oracle Technology Network License Agreement for Oracle Java SE']")).click();
		
		for(String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		
//		driver.findElement(By.xpath("//h5[text()='Resources for']/parent::div[@class='u10w3']")).click();
//		driver.findElement(By.xpath("//a[text()='Developers']")).click();
		driver.findElement(By.xpath("//a[text()='Menu']/parent::div[@class='u28s1']")).click();
		driver.switchTo().window(mainWindow);
		
		
		
		
		
		
		
		
		
		
//		driver.get("http://signup.live.com");
//        String mainTab = driver.getWindowHandle();

//        driver.findElement(By.xpath("//a[text()='соглашения об использовании служб Майкрософт']")).click();

//        for (String tab : driver.getWindowHandles()){
//            driver.switchTo().window(tab);
//        }

//        driver.findElement(By.xpath("(//span[text()='Часто задаваемые вопросы']/parent::a)[2]")).click();

//        driver.switchTo().window(mainTab);

//        driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("test");






//        driver.quit();

	}

}
