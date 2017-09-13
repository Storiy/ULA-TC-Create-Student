package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

import java.util.logging.Level;

public class DriverProvider {

    static String OS_EXTENSION = (System.getProperty("os.name").toLowerCase().contains("win")) ? ".exe" : "_mac";
    static String DRIVER_PATH = "drivers/chromedriver" + OS_EXTENSION;

    public static ThreadLocal<WebDriver> instance = new ThreadLocal<>();

    static public ChromeDriver getChrome(){

        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.OFF);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        ChromeOptions chromeOptions = new ChromeOptions();
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver(caps);
    }

    public static WebDriver getDriver(){
        if (instance.get() == null){
            instance.set(getChrome());
        }
        return instance.get();
    }

    public static void closeDriver(){
        instance.get().quit();
        instance.set(null);
    }

}
