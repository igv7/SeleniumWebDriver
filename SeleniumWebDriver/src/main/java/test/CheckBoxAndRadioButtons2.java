package test;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBoxAndRadioButtons2 {
	
	static WebDriver driver;
	static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";

	public static void main(String[] args) {
		
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//Go to ebay.com
		driver.get("https://ebay.com/");
		
		//Find a link 'Electronics'
//		WebElement electronics = driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[3]/a"));
		WebElement electronics = driver.findElement(By.xpath("//li/a[text()='Electronics']"));
		
		//Print a name of the link
		System.out.println(electronics.getText());
		
		//Click on the link
		electronics.click();
		
		//Find and click on a link 'Smart Glasses'
		driver.findElement(By.xpath("//a[text()='Smart Glasses']")).click();
		
		//CheckBoxes
		//Print 'Google' checkBox xPath
//		System.out.println(driver.findElement(By.xpath("//input[@aria-label='Google']")));
		
		//Find, check and print a checkBox 'Google' if selected
//		System.out.println(driver.findElement(By.xpath("//input[@aria-label='Google']")).isSelected());
		
		//Find and click on a checkBox 'Google'
//		driver.findElement(By.xpath("//input[@aria-label='Google']")).click();
		
		//Find, check and print a checkBox 'Google' if selected
//		System.out.println(driver.findElement(By.xpath("//input[@aria-label='Google']")).isSelected());
		
		//Find and click on a Brand's link 'see all'
		driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[1]/div/div/div/ul/div/div/li[1]/div/div/button")).click();
		
		//CheckBoxes
		//Find and click on checkBoxes 'Bose', 'Epson', 'Google'
//		driver.findElement(By.xpath("//*[@id='refineOverlay-subPanel-Brand_Bose_cbx']")).click();
//		driver.findElement(By.xpath("//label/span[text()='Bose']")).click();
//		driver.findElement(By.xpath("//*[@id='refineOverlay-subPanel-Brand_Epson_cbx']")).click();
//		driver.findElement(By.xpath("//label/span[text()='Epson']")).click();
//		driver.findElement(By.xpath("//*[@id='refineOverlay-subPanel-Brand_Google_cbx']")).click();
//		driver.findElement(By.xpath("//label/span[text()='Google']")).click();
		
		//Click on checkBox 'Bose' ones more
//		driver.findElement(By.xpath("//*[@id='refineOverlay-subPanel-Brand_Bose_cbx']")).click();
//		driver.findElement(By.xpath("//label/span[text()='Bose']")).click();
		
		//Find and click on checkBoxes 'Bose', 'Epson', 'Google'
		selectCheckBox("Bose");
		selectCheckBox("Epson");
		selectCheckBox("Google");
		//Click on checkBox 'Bose' ones more
		deselectCheckBox("Bose");
		
		//Click on button Apply
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
//		WebElement bose = driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/form/div[1]/div[2]/div[1]/div/fieldset/div[1]/div[1]/label"));
////		System.out.println("CheckBox: "+bose.getText());
//		WebElement epson = driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/form/div[1]/div[2]/div[1]/div/fieldset/div[1]/div[3]/label"));
//		WebElement google = driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/form/div[1]/div[2]/div[1]/div/fieldset/div[1]/div[4]/label"));
		
		//RadioButtons
		//Find and click on radioButtons 'Buy it Now', 'Auction' in area of Buying Format
//		driver.findElement(By.xpath("//div/li[3]/ul/li[4]/div/a/span[text()='Buy It Now']")).click();
		driver.findElement(By.xpath("//a/span[text()='Buy It Now']")).click();
		driver.findElement(By.xpath("//a/span[text()='Auction']")).click();
		//Find and click on radioButton 'US Only' in area of Item Location
		driver.findElement(By.xpath("//a/span[text()='US Only']")).click();
		
	}
	
	public static void selectCheckBox(String name){
        String chBxXpath = "//label/span[text()='%s']/preceding-sibling::input";
        if (!driver.findElement(By.xpath(String.format(chBxXpath, name))).isSelected())
            driver.findElement(By.xpath(String.format(chBxXpath, name))).click();
    }
    public static void deselectCheckBox(String name){
        String chBxXpath = "//label/span[text()='%s']/preceding-sibling::input";
        if (driver.findElement(By.xpath(String.format(chBxXpath, name))).isSelected())
            driver.findElement(By.xpath(String.format(chBxXpath, name))).click();
    }


}
