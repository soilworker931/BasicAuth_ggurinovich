package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertiesRead;

public abstract class Browser {
    private static WebDriver driver;
    private static final String browserName = PropertiesRead.readFromFrameworkConfig("browser");
    private static final String userName = PropertiesRead.readFromFrameworkConfig("userName");
    private static final String password = PropertiesRead.readFromFrameworkConfig("password");
    private static final String url = PropertiesRead.readFromFrameworkConfig("page");
    private static final String requiredText = "{\n" + "  \"authenticated\": true, \n" + "  \"user\": \"user\"\n" + "}";

    public static WebDriver getBrowser() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(browserName);
        }
        return driver;
    }

    public static void goToUrlAndLogin() {
        getBrowser().get("http://" + userName + ":" + password + "@" + url);
    }

    public static void maximize() {
        getBrowser().manage().window().maximize();
    }

    public static boolean isPageOpened() {
        return getBrowser().findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")).getText().equals(requiredText);
    }

    public static void close() {
        getBrowser().close();
    }
}