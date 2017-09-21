package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static LoginPage instance;
    public static LoginPage Instance = (instance != null) ? instance : new LoginPage();

    public LoginPage() { pageURL = "" ;}

    // UI mapping

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("Login");
    By crmHome = By.id("tsid");

    // User credentials
    String username = "apolloit.offshoretrad@gmail.com.qa";
    String password = "Apollo2017";

    // Page methods

    public MainPage doLogin(){
        reporter.info("Logging into salesforce");

        findElement(usernameField).clear();
        findElement(usernameField).sendKeys(username);

        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);

        findElement(loginButton).click();
        return MainPage.Instance;
    };


}
