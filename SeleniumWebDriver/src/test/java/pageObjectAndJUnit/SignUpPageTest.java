package pageObjectAndJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class SignUpPageTest {
	
	private WebDriver driver;
    static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";
    private SignUpPage signUpPage;

	
    @BeforeEach
    void init() {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    	driver.get("https://github.com/join");
    	signUpPage = new SignUpPage(driver);
    }
    
//    @Disabled
    @Test
    public void signUpWithShortPass(){
        SignUpPage sp = signUpPage.typePassword("qwe");
        String error = sp.getPasswrodErrorText();
        Assert.assertEquals("Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter. Learn more.", error);
    }

//    @Disabled
    @Test
    public void signUpReservedUsernameTest(){
        SignUpPage sp = signUpPage.typeUserName("username");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username 'username' is unavailable.", error);
    }

//    @Disabled
    @Test
    public void signUpTakenUsername(){
        SignUpPage sp = signUpPage.typeUserName("user");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username user is not available.", error);
    }

//    @Disabled
    @Test
    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }
    
    @AfterEach
    void destroy() {
    	driver.quit();
    }

}
