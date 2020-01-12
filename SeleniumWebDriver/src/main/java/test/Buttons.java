package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Buttons {
	
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://en.wikipedia.org");
		driver.findElement(By.xpath("//input[@id='searchButton']")).click();

        driver.get("http://github.com");
        WebElement button = driver.findElement(By.xpath("//form[@class='home-hero-signup js-signup-form']//button"));
//        button.click();
        System.out.println("Button text: "+button.getText());
        if (button.getText().equals("Sign up for GitHub")) {
            System.out.println("Success!!");
        }
        else System.out.println("Fail!");
//        button.submit();

//        driver.findElement(By.xpath("//a[text()='Sign in']")).click();  //doesn't work
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")).click();

        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath("//label[@id='loginbutton']/input")).submit();

//        driver.quit();

	}

}
