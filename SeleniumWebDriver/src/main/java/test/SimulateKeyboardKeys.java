package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimulateKeyboardKeys {
	
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
		
		driver.get("http://en.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));

        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v");
        String shift = Keys.chord(Keys.SHIFT);
        String delete = Keys.chord(Keys.DELETE);
        

        searchInput.sendKeys(shift, "test");
			        try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					}
        searchInput.sendKeys(select, delete);
			        try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					}
        searchInput.sendKeys("test text");
			        try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					}
        searchInput.sendKeys(select);
			        try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					}
        searchInput.sendKeys(cut);
			        try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					}
        searchInput.sendKeys(paste);
			        try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					}
        searchInput.sendKeys(Keys.ENTER);


//        driver.quit();

	}

}
