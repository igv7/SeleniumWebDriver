package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComplexActions {
	
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
		
//		driver.get("http://en.wikipedia.org/");
		driver.get("http://ebay.com");

        WebElement link = driver.findElement(By.xpath("//ul[@class='hl-cat-nav__container']/li[3]/a[text()='Electronics']"));
        WebElement input = driver.findElement(By.xpath("//input[@type='text']/parent::div[@id='gh-ac-box2']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(link).build().perform();

        actions.dragAndDrop(link, input).build().perform();

        actions.clickAndHold(link).moveToElement(input).release().build().perform();

        actions.doubleClick(link);
        actions.contextClick(link);

        Action action = actions.clickAndHold(link).moveToElement(input).release().build();

        action.perform();

//        driver.quit();

	}

}
