package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class LoginPage extends BasePage{

    private static LoginPage instance;
    public static LoginPage Instance = (instance != null) ? instance : new LoginPage();

    public LoginPage() { pageURL = "" ;}

    // UI mapping

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("Login");
    By gmailAuth = By.xpath("kajsiuasdhahdskajhsdkjahsdkj"); // todo
    By crmHome = By.id("tsid");

    // User credentials
    String username = "apolloit.offshoretrad@gmail.com.qa";
    String password = "Apollo2017";

    // Page methods

    public LoginPage doLogin() throws Exception {
        findElement(usernameField).clear();
        findElement(usernameField).sendKeys(username);

        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);

        findElement(loginButton).click();
        if ( isElementPresent(crmHome) ) {
        } else { gmailPasswordfetch(); }
        return this;
    };

    public boolean gmailAuthantication(){
        return isElementPresent(gmailAuth);
    }

    public void gmailPasswordfetch() throws Exception {
        reporter.info("Getting gmail password");
//        Actions newTab = new Actions(driver());
//        newTab.sendKeys(Keys.LEFT_CONTROL + "t").perform();
        driver().get("https://www.facebook.com");
        // If Mac OS X, the key combination is CMD+t, otherwise is CONTROL+t
        int vkControl = IS_OS_MAC ? KeyEvent.VK_META : KeyEvent.VK_CONTROL;
        Robot robot = new Robot();
        robot.keyPress(vkControl);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(vkControl);
        robot.keyRelease(KeyEvent.VK_T);

        // Wait up to 5 seconds to the second tab to be opened
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to new tab
        List<String> windowHandles = new ArrayList <> (driver().getWindowHandles());
        System.err.println(windowHandles);
        driver().switchTo().window(windowHandles.get(1));

        // Open other URL in second tab
        driver().get("https://google.com/");
    }
}
