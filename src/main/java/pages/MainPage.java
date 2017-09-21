package pages;

import org.openqa.selenium.By;
import pages.ULA.NewOpportunityPage;
import pages.ULA.NewStudentPage;

public class MainPage extends BasePage{

    private static MainPage instance;
    public static MainPage Instance = (instance != null) ? instance : new MainPage();

    // UI Mapping

    By accountsTab = By.xpath(".//*[@title='Accounts Tab']");
    By newAccountButton = By.xpath(".//*[@title='New']");

    // Page Methods

    public NewStudentPage openNewStudentPage(){
        reporter.info("Opening student creation page");

        findElement(accountsTab).click();
        findElement(newAccountButton).click();
        return NewStudentPage.Instance;
    }
}
