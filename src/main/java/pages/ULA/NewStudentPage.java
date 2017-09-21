package pages.ULA;

import org.openqa.selenium.By;
import pages.MainPage;
import utils.FileIO;
import utils.Tools;
import java.io.IOException;
import java.util.Random;

public class NewStudentPage extends MainPage {

    private static NewStudentPage instance;
    public static NewStudentPage Instance = (instance != null) ? instance : new NewStudentPage();


    // UI Mapping
    By firstname = By.id("name_firstacc2");
    By lastname = By.id("name_lastacc2");

    By studentType = By.id("00NE0000000cqG8");
    By birthday = By.id("00NE0000000dOMX");
    By gender = By.id("00NE0000000mStE");
    By email = By.id("00NE0000000mStM");
    By preferredPhone = By.id("00NE0000000mStP");
    By mobilePhone = By.id("PersonMobilePhone");

    By addressCountry = By.id("CF00NE0000004Gbgg");
    By addressPostal = By.id("00NE0000000dOMq");
    By addressState = By.id("CF00NE0000004Gbgi");
    By addressCity = By.id("00NE0000000dOMo");
    By addressStreet = By.id("00NE0000000dOMs");

    By saveButton = By.name("save");

    By newOpportunity = By.name("new_ula_traditional_opportunity");


    // Page methods



    public void enterStudentInfo() throws IOException {
        String stfirst = firstname();
        String stlast = lastname();

        findElement(firstname).sendKeys(stfirst);
        reporter.info("Entering firstname " + stfirst);
        findElement(lastname).sendKeys(stlast);
        reporter.info("Entering lastname " + stlast);

        reporter.info("Selecting user type, gender and birthday");
        selectFromDropdown(studentType, "Prospect");
        selectFromDropdown(gender, gender());
        findElement(birthday).sendKeys("02/02/1990");

        reporter.info("Entering email " + stfirst + "_" + stlast + "@mailinator.com");
        findElement(email).sendKeys(stfirst + "_" + stlast + "@mailinator.com");

        reporter.info("Entering mobile " + Tools.getCurTimeMillis(1000000000) + "158");
        selectFromDropdown(preferredPhone, "Mobile Phone");
        findElement(mobilePhone).sendKeys(Tools.getCurTimeMillis(1000000000) + "158");

        reporter.info("Entering address");
        findElement(addressStreet).sendKeys(street() + " " + Tools.getCurTimeMillis(1000) + "/" + Tools.getCurTimeMillis(200));
        findElement(addressCity).sendKeys("Mexico");
        findElement(addressState).sendKeys("México");
        findElement(addressPostal).sendKeys("ME" + Tools.getCurTimeMillis(6000));
        findElement(addressCountry).sendKeys("Mexico");

        reporter.info("Clicking on 'Save'");
        findElement(saveButton).click();
    }

    public NewOpportunityPage openNewOpportunityPage(){
        reporter.info("Navigate to opportunity creation page");
        findElement(newOpportunity).click();
        return NewOpportunityPage.Instance;
    }
}
