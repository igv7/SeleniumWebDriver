package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Links {
	
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://en.wikipedia.org");

        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
        System.out.println(link.getText());
        link.click();

        driver.get("http://github.com");
//        driver.findElement(By.xpath("//nav[@class='site-header-nav site-header-nav-main']/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details/summary")).click();

        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath("//a[text()='Forgotten account?']")).click();


//        driver.quit();

	}

}
