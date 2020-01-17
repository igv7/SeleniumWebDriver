package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindListElements2 {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//Go to kamaze.co.il
		driver.get("https://www.kamaze.co.il");
		//Find and click on a 'להשוואת מחירי חבילות סלולר'
		driver.findElement(By.xpath("//a[text()='להשוואת מחירי חבילות סלולר']")).click();
		//Find and click on a 'הוסף / הורד מסלולים'
		driver.findElement(By.xpath("//span[text()='הוסף / הורד מסלולים']")).click();
		//Find and click on a check box 'עד 25 ג'יגה'
//		driver.findElement(By.xpath("//i/parent::span[text()=\"עד 25 ג'יגה\"]/parent::div[@class='reg_options_container_items_holder']")).click();
		
		List<WebElement>optionXpath = driver.findElements(By.xpath("//div[@class='reg_options_container active']/div[@class='reg_options_container_items_holder']/span"));
		optionXpath.get(1).click();
//		optionXpath.get(3).click();
//		optionXpath.get(4).click();
//		System.out.println(optionXpath.get(3).getText());
//		System.out.println(optionXpath.get(5).getText());
		
		for(WebElement checkBox : optionXpath) {
			System.out.println(checkBox.getText());
			checkBox.click();
		}
		System.out.println(optionXpath.size());
		
		//Click on a 'הוסף / הורד מסלולים'
//		driver.findElement(By.xpath("//span[text()='הוסף / הורד מסלולים']")).click();
		
//		selectOption();
//		selectOption("הוסף / הורד מסלולים", "מבצעים מובילים");
//        selectOption("ללא הגבלה", "הוסף / הורד מסלולים");
		
	}

	
//	public static void selectOption(){
//		String listXpath = String.format("//span[text()='הוסף / הורד מסלולים']");
//		List<WebElement>optionXpath = driver.findElements(By.xpath("//div[@class='reg_options_container active']/div[@class='reg_options_container_items_holder']/span"));
//		driver.findElement(By.xpath(listXpath)).click();
//		optionXpath.get(1).click();
//    }
	
//	public static void selectOption(String list, String option){
//		String listXpath = String.format("//span[text()='%s']", list);
//        String optionXpath = String.format("//i/parent::span[text()=\"%s\"]/parent::div[@class='reg_options_container_items_holder']/parent::div[@class='reg_options_container active']", option);
//		driver.findElement(By.xpath(listXpath)).click();
//        driver.findElement(By.xpath(optionXpath)).click();
//    }

}
