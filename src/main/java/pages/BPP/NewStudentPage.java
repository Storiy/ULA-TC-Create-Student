package pages.BPP;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.MainPage;
import utils.Tools;

import java.io.IOException;

public class NewStudentPage extends MainPage {

    private static NewStudentPage instance;
    public static NewStudentPage Instance = (instance != null) ? instance : new NewStudentPage();

    // UI Mapping
    By firstname = By.id("name_firstacc2");
    By lastname = By.id("name_lastacc2");
    By studentType = By.id("00Nb0000003v7lc");
    By birthday = By.id("PersonBirthdate");
    By gender = By.id("00Nb0000003v7kV");

    By preferredPhone = By.id("00Nb0000003v7kg");
    By homePhone = By.id("PersonHomePhone");
    By preferredEmail = By.id("00Nb0000003v7ke");
    By personalEmail = By.id("00Nb0000003v7kd");

    By legalEntity = By.id("00Nb0000004LziE");
    By saveButton = By.name("save");

    By addNewAddress = By.name("new00Nb0000004Lzej");


    // Page Methods
    public void enterStudentInfo() throws IOException {
        findElement(firstname).sendKeys(firstname());
        reporter.info("Entering firstname " + firstname());
        findElement(lastname).sendKeys(lastname());
        reporter.info("Entering lastname " + lastname());

        reporter.info("Selecting user type, gender and birthday");
        selectFromDropdown(studentType, "Domestic");
        selectFromDropdown(gender, gender());
        findElement(birthday).sendKeys("02/02/1990");

        reporter.info("Entering mobile " + Tools.getCurTimeMillis(1000000000) + "158");
        selectFromDropdown(preferredPhone, "Home");
        findElement(homePhone).sendKeys(Tools.getCurTimeMillis(1000000000) + "158");

        reporter.info("Entering email " + firstname() + "_" + lastname() + "@mailinator.com");
        selectFromDropdown(preferredEmail, "Personal");
        findElement(personalEmail).sendKeys(firstname() + "_" + lastname() + "@mailinator.com");

        reporter.info("Setting Legal Entity");
        selectFromDropdown(legalEntity, "UC~COL");

        reporter.info("Clicking on 'Save'");
        findElement(saveButton).click();
    }

    public void addNewAddress() throws IOException{

    }
}
