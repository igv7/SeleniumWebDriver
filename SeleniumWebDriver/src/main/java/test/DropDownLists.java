package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DropDownLists {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//Go to accounts.google.com
		driver.get("https://www.w3schools.com/xml/xpath_examples.asp");
		//Click on 'MORE' view list on a top panel
		driver.findElement(By.xpath("//*[@id=\"topnavbtn_tutorials\"]")).click();

		//Click on 'Learn XPath' in XML area
		selectOption("Learn XPath");
		//Go back
		driver.navigate().back();
		//Click on 'MORE' view list on a top panel
		driver.findElement(By.xpath("//*[@id=\"topnavbtn_tutorials\"]")).click();
		//Click on 'Learn XML' in XML area
		selectOption("Learn XML");
		
		
	}
	//Find an option by text name and click on it
	public static void selectOption(String option) {
		String optionXPath = String.format("//*[@class=\"w3-col l3 m6 w3-hide-medium\"]/a[text()='%s']", option);
		driver.findElement(By.xpath(optionXPath)).click();
	}

}
