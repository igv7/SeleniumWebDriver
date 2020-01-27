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
import org.openqa.selenium.support.PageFactory;

class MainPageTest {

	private WebDriver driver;
    static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";
    private MainPage mainPage;
    

    @BeforeEach
    void init(){
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
//        mainPage = new MainPage(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

//    @Disabled
    @Test
    void signInTest(){
//    	mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

//    @Disabled
    @Test
    void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass6");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

//    @Disabled
    @Test
    void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "mail", "testpass6");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Username can't be blank", error);
    }

//    @Disabled
    @Test
    void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "testpass6");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @AfterEach
    void destroy(){
        driver.quit();
    }

}
