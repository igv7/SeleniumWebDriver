package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckingItemAvailability {
	
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
		
		

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");

        WebElement rb1 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u241-oth-JPR'])[1]"));
        WebElement rb2 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u241-oth-JPR'])[2]"));

        System.out.println("Radio button 2 selected: " + rb2.isSelected());

        if (!rb1.isSelected()) rb1.click();
		
		

        driver.get("http://ebay.com");

        WebElement link1 = driver.findElement(By.xpath("//a[contains(text(), 'Samsung')]"));
        WebElement link2 = driver.findElement(By.xpath("//a[text()='Saved']"));

        System.out.println(link1.isDisplayed());
        System.out.println(link2.isDisplayed());

        if (link1.isDisplayed()) link1.click();
        else link2.click();
		
		
		
		
//		driver.get("http://www.w3schools.com/jsref/prop_pushbutton_disabled.asp");
//		WebElement btnTry1 = driver.findElement(By.xpath("//div[@class='w3-example']//a[text()='Try it Yourself »']"));
//		btnTry1.click();
//	      
//
//        WebElement button1 = driver.findElement(By.xpath("//button[text()='My Button']"));
//        WebElement button2 = driver.findElement(By.xpath("//a[@id='tryhome']")); //"//a[@title='Home']"
//
//        System.out.println(button1.isEnabled());
//        System.out.println(button2.isEnabled());
//
//        if (button1.isEnabled()) button1.click();
//        if (button2.isEnabled()) button2.click();






//        driver.quit();

	}

}
