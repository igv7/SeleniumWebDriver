package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlert {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
//		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        driver.findElement(By.xpath("//a[text()='jdk-8u241-windows-x64.exe']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        driver.get("http://google.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();



//        driver.quit();

	}

}
