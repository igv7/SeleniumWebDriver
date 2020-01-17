package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindListElements {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://market.yandex.ru/");

        driver.findElement(By.xpath("//a/span[text()='Бытовая техника']")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();

        //Select all checkBoxes on a page
//        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class=\"_3_phr-spJh\"]//fieldset[@class=\"_3M70uokkTS\"]/ul[@class=\"_2y67xS5HuR\"]//li[@class=\"_1-l0XiE_ze\"]//label/div"));
//        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class=\"_3_phr-spJh\"]//label/div"));
        
        //Select all checkBoxes by category 'Производитель'
//        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@style=\"z-index:26\"]//fieldset[@class=\"_3M70uokkTS\"]/ul[@class=\"_2y67xS5HuR\"]/li[@class=\"_1-l0XiE_ze\"]//label/div"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@style=\"z-index:26\"]//label/div"));

//        checkboxes.get(3).click();

        if (checkboxes.size() == 12) System.out.println("It's okay!");
        else System.out.println("FAIL!");

        for (WebElement checkbox : checkboxes){
            checkbox.click();
        }

	}

}
