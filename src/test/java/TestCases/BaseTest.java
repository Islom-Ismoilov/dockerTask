package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private static WebDriver driver;
    private static final String SELENIUM_GRID_URL = "http://selenium-hub:4444/wd/hub";

    public static WebDriver getDriver(){
        if(driver == null){
            initializeDriver();
        }
        return driver;
    }

    @BeforeClass
    public static void initializeDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-EN");
        chromeOptions.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

        try{
            driver = new RemoteWebDriver(new URL(SELENIUM_GRID_URL),chromeOptions);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }


    @AfterClass
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}

//    //To run tests locally
//    private static WebDriver driver;
//    public static WebDriver getDriver(){
//        if (driver == null){
//            initializeDriver();
//
//        }
//        return driver;
//    }
//
//    @BeforeClass
//    public static void initializeDriver(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @AfterClass
//    public static void quitDriver(){
//        if (driver != null){
//            driver.quit();
//        }
//    }
//}
