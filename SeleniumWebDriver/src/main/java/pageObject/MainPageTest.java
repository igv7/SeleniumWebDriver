package pageObject;

import java.util.concurrent.TimeUnit;

//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPageTest {

    private WebDriver driver;
    static String projectPath = "C:\\Users\\Igor\\eclipse-workspace\\SeleniumWebDriver\\";
    private MainPage mainPage;

    @BeforeEach
    public void init(){
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", projectPath+"src\\main\\resources\\drivers\\chromedriver.exe");
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath+"src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "pass");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @AfterEach
    public void destroy(){
        driver.quit();
    }
}