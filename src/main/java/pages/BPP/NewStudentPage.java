package pages.BPP;

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
    By addressType = By.id("00Nb0000004Lzeo");
    By addressStreet = By.id("00Nb0000004Lzef");
    By addressCity = By.id("00Nb0000004LzeZ");
    By addressPostal = By.id("00Nb0000004Lzep");
    By addressCountry = By.id("CF00Nb0000004Lzec");
    By accountLink = By.id("CF00Nb0000004Lzej_ileinner");

    By getProfileID = By.name("get_profile_id_v2");
    By newOpportunity = By.name("newOpp");

    public By profileIDField = By.id("00Nb0000004Lzfw_ileinner");



    // Page Methods

    public void enterStudentInfo() throws IOException {
        String stfirst = firstname();
        String stlast = lastname();

        findElement(firstname).sendKeys(stfirst);
        reporter.info("Entering firstname " + stfirst);
        findElement(lastname).sendKeys(stlast);
        reporter.info("Entering lastname " + stlast);

        reporter.info("Selecting user type, gender and birthday");
        selectFromDropdown(studentType, "Domestic");
        selectFromDropdown(gender, gender());
        findElement(birthday).sendKeys("02/02/1990");

        reporter.info("Entering mobile " + Tools.getCurTimeMillis(1000000000) + "158");
        selectFromDropdown(preferredPhone, "Home");
        findElement(homePhone).sendKeys(Tools.getCurTimeMillis(1000000000) + "158");

        reporter.info("Entering email " + stfirst + "_" + stlast + "@mailinator.com");
        selectFromDropdown(preferredEmail, "Personal");
        findElement(personalEmail).sendKeys(stfirst + "_" + stlast + "@mailinator.com");

        reporter.info("Setting Legal Entity");
        selectFromDropdown(legalEntity, "UC~COL");

        reporter.info("Clicking on 'Save'");
        findElement(saveButton).click();
    }

    public void addNewAddress() throws IOException{
        reporter.info("Adding Address");
        findElement(addNewAddress).click();

        selectFromDropdown(addressType, "Billing");
        findElement(addressStreet).sendKeys(street() + " " + Tools.getCurTimeMillis(1000) + "/" + Tools.getCurTimeMillis(200));
        findElement(addressCity).sendKeys("London");
        findElement(addressPostal).sendKeys("PC-" + Tools.getCurTimeMillis(6000));
        findElement(addressCountry).sendKeys("United Kingdom");

        findElement(saveButton).click();
        findElement(accountLink).click();
        findElement(getProfileID).click();
    }

    public NewOpportunityPage openNewOpportunityPage(){
        findElement(newOpportunity).click();
        return NewOpportunityPage.Instance;
    }

}
