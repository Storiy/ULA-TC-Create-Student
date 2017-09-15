package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.DriverProvider;

import java.util.ArrayList;
import java.util.Set;

public class Gmail extends BasePage{

    private static Gmail instance;
    public static Gmail Instance = (instance != null) ? instance : new Gmail();

    public Gmail() { pageURL = "https://www.google.com/gmail/";}






}
