package pages.BPP;

import org.apache.regexp.RE;
import org.openqa.selenium.By;

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
    By addressType = By.id("00Nb0000004Lzeo");
    By addressStreet = By.id("00Nb0000004Lzef");
    By addressCity = By.id("00Nb0000004LzeZ");
    By addressPostal = By.id("00Nb0000004Lzep");
    By addressCountry = By.id("CF00Nb0000004Lzec");

    By getProfileID = By.name("get_profile_id_v2");
    By newOpportunity = By.name("newOpp");

    public By profileIDField = By.id("00Nb0000004Lzfw_ileinner");



    // Page Methods

    public void enterStudentInfo() throws IOException, InterruptedException {
        gender();
        firstname();
        lastname();

        findElement(firstname).sendKeys(studentfirstname);
        reporter.info("Entering firstname " + studentfirstname);
        findElement(lastname).sendKeys(studentlastname);
        reporter.info("Entering lastname " + studentlastname);

        reporter.info("Selecting user type, gender and birthday");
        selectFromDropdown(studentType, "Domestic");
        selectFromDropdown(gender, gender());
        findElement(birthday).sendKeys("02/02/1990");

        reporter.info("Entering mobile " + Tools.getCurTimeMillis(1000000000) + "158");
        selectFromDropdown(preferredPhone, "Home");
        findElement(homePhone).sendKeys(Tools.getCurTimeMillis(1000000000) + "158");

        reporter.info("Entering email " + studentfirstname + "_" + studentlastname + "@mailinator.com");
        selectFromDropdown(preferredEmail, "Personal");
        findElement(personalEmail).sendKeys(studentfirstname + "_" + studentlastname + "@mailinator.com");

        reporter.info("Setting Legal Entity");
        selectFromDropdown(legalEntity, "UC~COL");

        reporter.info("Clicking on 'Save'");
        findElement(saveButton).click();

        reporter.info("Adding Address");
        findElement(addNewAddress).click();

        selectFromDropdown(addressType, "Billing");
        findElement(addressStreet).sendKeys(street() + " " + Tools.getCurTimeMillis(1000) + "/" + Tools.getCurTimeMillis(200));
        findElement(addressCity).sendKeys("London");
        findElement(addressPostal).sendKeys("PC-" + Tools.getCurTimeMillis(6000));
        findElement(addressCountry).sendKeys("United Kingdom");

        findElement(saveButton).click();
        findElement(By.partialLinkText(studentfirstname)).click();
        Thread.sleep(1000);

        reporter.info("Getting profile ID");
        findElement(getProfileID).click();
        Thread.sleep(3000);
    }


    public NewOpportunityPage openNewOpportunityPage(){
        findElement(newOpportunity).click();
        return NewOpportunityPage.Instance;
    }

}
