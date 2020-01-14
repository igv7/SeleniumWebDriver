package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBoxAndRadioButtons {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {

//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://market.yandex.ru/");

        driver.findElement(By.xpath("//a/span[text()='Бытовая техника']")).click();
//      driver.findElement(By.xpath("/html/body/div[2]/div[2]/span/div[2]/noindex/div[2]/div/div/div[1]/div[4]/a/span")).click();
     
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();
        
        
//        //CheckBox ATLANT
//        System.out.println(driver.findElement(By.xpath("//span[text()='ATLANT']/ancestor::label/div/preceding-sibling::input"))
//        		.isSelected());
//        driver.findElement(By.xpath("//span[text()='ATLANT']/ancestor::label/div")).click();//ATLANT
//        System.out.println(driver.findElement(By.xpath("//span[text()='ATLANT']/ancestor::label/div/preceding-sibling::input"))
//        		.isSelected());
//        
//        //CheckBox Bosch
//        driver.findElement(By.xpath("//span[text()='Bosch']/ancestor::label/div")).click();//Bosch
//        //CheckBox Candy
//        driver.findElement(By.xpath("//span[text()='Candy']/ancestor::label/div")).click();//Candy
//        //CheckBox Bosch
//        driver.findElement(By.xpath("//span[text()='Bosch']/ancestor::label/div")).click();//Bosch
        
        selectCheckBox("ATLANT");
        selectCheckBox("Bosch");
        selectCheckBox("Candy");

        deselectCheckBox("Bosch");

        System.out.println();

        System.out.println(driver.findElement(By.xpath("//span[text()='Самовывоз']/ancestor::label/div/preceding-sibling::input"))
        		.isSelected());
        driver.findElement(By.xpath("//span[text()='Самовывоз']/ancestor::label/div")).click();
        System.out.println(driver.findElement(By.xpath("//span[text()='Самовывоз']/ancestor::label/div/preceding-sibling::input"))
        		.isSelected());
        
        driver.findElement(By.xpath("//span[text()='С доставкой']/ancestor::label/div")).click();
    
//        driver.quit();
    }

    public static void selectCheckBox(String name){
        String chbXpath = "//span[text()='%s']/ancestor::label/div";
        if (!driver.findElement(By.xpath(String.format(chbXpath, name) + "/preceding-sibling::input")).isSelected())
            driver.findElement(By.xpath(String.format(chbXpath, name))).click();
    }
    public static void deselectCheckBox(String name){
        String chbXpath = "//span[text()='%s']/ancestor::label/div";
        if (driver.findElement(By.xpath(String.format(chbXpath, name) + "/preceding-sibling::input")).isSelected())
            driver.findElement(By.xpath(String.format(chbXpath, name))).click();
		
	}

} 
