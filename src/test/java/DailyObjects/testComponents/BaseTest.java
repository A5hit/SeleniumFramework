package DailyObjects.testComponents;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;

    public WebDriver getDriver() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//DailyObjects//GlobalData.properties");
        props.load(fis);
        String browser = props.getProperty("browser");
        if ("chrome".contains(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); 
            driver.manage().window().maximize();
            ChromeOptions cOptions = new ChromeOptions();
            if (browser.contains("headless")) {
                cOptions.addArguments("--headless");
            }
            cOptions.addArguments("--ignore-certificate-errors");
            cOptions.addArguments("disable-infobars");
            cOptions.addArguments("test-type");
            cOptions.addArguments("--disable-extensions");
            cOptions.addArguments("--disable-notifications");
            cOptions.addArguments("--disable-component-update");

        } else if ("firefox".contains(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            FirefoxOptions fOptions = new FirefoxOptions();
            driver.manage().window().maximize();
            if (browser.contains("headless")) {
                fOptions.addArguments("--headless");
            }
            fOptions.addArguments("--ignore-certificate-errors");
            fOptions.addArguments("disable-infobars");
            fOptions.addArguments("test-type");
            fOptions.addArguments("--disable-extensions");
            fOptions.addArguments("--disable-notifications");
            fOptions.addArguments("--disable-component-update");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}
