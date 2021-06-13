package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver = null;
    public static Configuration config = new Configuration();
    public static String browserName;
    public static String os;

    public BasePage() {
        browserName = Configuration.getProperty("browser");
        os = System.getProperty("os.name");

        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.toLowerCase().contains("win")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Configuration.getProperty("driver.location") + ".exe");
            } else if (os.toLowerCase().contains("mac")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Configuration.getProperty("driver.location"));
            }
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("disable-infobars");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Configuration.getProperty("implicitWait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.close();
    }

    public void getHost() {
        driver.get(Configuration.getProperty("host"));
    }

}
