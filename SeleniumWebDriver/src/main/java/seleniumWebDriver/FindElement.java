package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElement {
	
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://en.wikipedia.org");

        WebElement link = driver.findElement(By.linkText("Log in"));
        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));
        WebElement searchField = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        WebElement li = driver.findElement(By.id("ca-viewsource"));
        WebElement input = driver.findElement(By.tagName("input"));
        WebElement element = driver.findElement(By.cssSelector("div#simpleSearch input#searchButton"));
        WebElement logo = driver.findElement(By.xpath("//div[@id='mw-panel']/div[@id='p-logo']//a"));


        driver.quit();
	}

}
