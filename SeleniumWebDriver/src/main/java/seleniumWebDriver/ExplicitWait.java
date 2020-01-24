package seleniumWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";
	
	static WebDriverWait wait;
    static WebDriverWait wait2;


	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Implicit Wait
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://accounts.google.com/SignUp?service=mail&hl=ru&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-ru");
        wait  = (new WebDriverWait(driver, 5));
        wait2  = (new WebDriverWait(driver, 10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Создайте аккаунт Google')]")));
        
        
        inputName("‪Igor", "Gamazov‬");
        selectOption("‪Ру�?�?кий‬", "‪English (United States)‬");

    }
	
	
	
	public static void inputName(String firstName, String lastName){
        WebElement firstNameXpath = driver.findElement(By.xpath("//input[@id='firstName']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        firstNameXpath.sendKeys(firstName);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        WebElement lastNameXpath = driver.findElement(By.xpath("//input[@id='lastName']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
        lastNameXpath.sendKeys(lastName);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
	}
	
	
	
	public static void selectOption(String listName, String option){
        String listXpath = String.format("//span[text()='%s']/parent::div[@class=\"MocG8c B9IrJb LMgvRb KKjvXb\"]/ancestor::div[@id='lang-chooser']", listName);
        String optionXpath = String.format("//span[text()='%s']/parent::div[@class=\"MocG8c B9IrJb LMgvRb\"]/parent::div[@class=\"OA0qNb ncFHed\"]/parent::div[@id='lang-chooser']", option);
        driver.findElement(By.xpath(listXpath)).click();
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
        driver.findElement(By.xpath(optionXpath)).click();
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(optionXpath)));
	}
	
	
	
	
	
	
	
//    public static void selectOption(String listName, String option){
//        String listXpath = String.format("(//strong[text()='%s']/following-sibling::div/div[@role='listbox'])[1]", listName);
//        String optionXpath = String.format("//div[text()='%s']/parent::div[@role='option']", option);
//        driver.findElement(By.xpath(listXpath)).click();
//        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
//        driver.findElement(By.xpath(optionXpath)).click();
//        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(optionXpath)));
//		
//
//	}

}
