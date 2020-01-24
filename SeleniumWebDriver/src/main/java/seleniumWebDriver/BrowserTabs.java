package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTabs {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
		
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		driver.get("http://signup.live.com");
		//Implicit Wait
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
      String mainTab = driver.getWindowHandle();

		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[text()='Terms of Use']")).click();

      for (String tab : driver.getWindowHandles()){
          driver.switchTo().window(tab);
      }

    //Implicit Wait
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      driver.findElement(By.xpath("//nav/ul/li[2]/a[text()='FAQ']")).click();

      driver.switchTo().window(mainTab);

      driver.findElement(By.xpath(".//*[@class='ltr_override form-control email-input-max-width']")).sendKeys("test");






//      driver.quit();

	}

}
