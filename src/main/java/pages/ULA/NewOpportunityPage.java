package pages.ULA;

import org.openqa.selenium.By;
import pages.BasePage;

public class NewOpportunityPage extends BasePage{

    private static NewOpportunityPage instance;
    public static NewOpportunityPage Instance = (instance != null) ? instance : new NewOpportunityPage();

    // UI Mapping
    By closeDate = By.xpath("//*[@class='dateFormat']"); //todo could be an issue
    By status = By.id("opp11");
    By admtCode = By.id("00NE0000004GbfL");
    By resdCode = By.id("00NE0000004GbfM");
    By stypeCode = By.id("00NE0000004GbfN");
    By termCode = By.id("00NE0000004GbfT");
    By feeDiscount = By.id("00NL0000003PW7S");
    By tuitionFee = By.id("00NL0000003PW7T");
    By registrantType = By.id("00NE0000000dOOS");
    By saveButton = By.name("save");

    By searchCatalogButton = By.name("search_catalog");
    By campus = By.name("j_id0:j_id27:j_id30:j_id31:j_id33");
    By program = By.name("j_id0:j_id27:j_id30:j_id31:j_id64");
    By numberOfPayments = By.name("j_id0:j_id27:j_id30:j_id31:j_id95");
    By saveCatalog = By.xpath("//input[@value='Save']");

    By editButton = By.name("edit");
    By submitButton = By.name("submit_application");
    By provisionButton = By.name("student_provision");

    public By statusVerification = By.id("opp11_ileinner");



    //Page Methods
    public void addOpportunity(){
        reporter.info("Picking closing date");
        findElement(closeDate).click();

        reporter.info("Setting Status to 'Appointment'");
        selectFromDropdown(status, "Appointment");

        reporter.info("Setting Admission options");
        selectFromDropdown(admtCode, "EM~ Empleado");
        selectFromDropdown(resdCode, "E~ EXTRANJERO");
        selectFromDropdown(stypeCode, "C~ REINGRESO");
        selectFromDropdown(termCode, "201805~ TC Ciclo 17-18 Annual Aug17 - Jul18");

        reporter.info("Setting Fees");
        selectFromDropdown(feeDiscount, "5% de descuento FEE");
        selectFromDropdown(tuitionFee, "10% de descuento TUI");

        reporter.info("Setting Registrant Type");
        selectFromDropdown(registrantType, "Baccalaureate - International");

        reporter.info("Clicking on 'Save'");
        findElement(saveButton).click();
    }

    public void addCatalogOptions() throws InterruptedException {
        reporter.info("Clicking on 'Search Catalog'");
        findElement(searchCatalogButton).click();

        switchToNewTab();

        reporter.info("Setting 'Search Catalog' options");
        selectFromDropdown(campus, "Norte");
        Thread.sleep(1000);
        selectFromDropdown(program, "Licenciatura En Administración");
        Thread.sleep(1000);
        selectFromDropdown(numberOfPayments, "5 Licenciatura");
        Thread.sleep(1000);

        reporter.info("Clicking on 'Save'");
        findElement(saveCatalog).click();
        Thread.sleep(1000);

        switchToMainTab();
    }

    public void submitOpportunity(){
        waitForPageToLoad();
        reporter.info("Changing Opportunity Status");
        findElement(editButton).click();

        selectFromDropdown(status, "Application Submitted");
        findElement(saveButton).click();

        reporter.info("Submitting Application");
        findElement(submitButton).click();

        reporter.info("Provisioning Student");
        findElement(provisionButton).click();
    }

}
