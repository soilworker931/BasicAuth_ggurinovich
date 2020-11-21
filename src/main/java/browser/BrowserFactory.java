package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName) {
        browserName = browserName.toLowerCase();
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = getChromeInstance();
                break;
            case "firefox":
                driver = getFirefoxInstance();
        }
        return driver;
    }

    private static ChromeDriver getChromeInstance() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

    private static FirefoxDriver getFirefoxInstance() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }
}
