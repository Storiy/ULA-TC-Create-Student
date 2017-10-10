package pages.BPP;

import org.openqa.selenium.By;
import utils.FileIO;

import java.io.IOException;

public class NewOpportunityPage extends NewStudentPage {

    private static NewOpportunityPage instance;
    public static NewOpportunityPage Instance = (instance != null) ? instance : new NewOpportunityPage();

    public String bannerID = "";
    public String opportunityLink = "";
    public String applicationID = "";
    public String arCustomerNumber = "";
    public String studentinfo = "";



    // UI Mapping

    By saveButton = By.name("save");
    By opportunityName = By.id("opp3");
    By accountName = By.id("opp4");
    By status = By.id("opp11");
    By customerGroup = By.id("00Ng0000001MZHo");
    By closeDate = By.xpath("//*[@class='dateFormat']");
    By sponsorshipLevel = By.id("00Nb0000009XrE0");
    By newProductCatalogItem = By.name("new00Nb0000009YxlB");

    By continueButton = By.xpath("//INPUT[@value='Continue']");
    By offeringField = By.id("j_id0:searchForm:searchPageBlock:OfferingLookup");
    By searchButton = By.id("j_id0:searchForm:searchPageBlock:sBtn");
    By offeringCheckbox = By.xpath("(//input[@type='checkbox'])[2]");
    By addProductsButton = By.name("j_id0:searchForm:j_id77:j_id78:j_id79");
    By submitApplicationButton = By.name("submit_application");

    By bannerIDField = By.id("00Nb0000004Lzia_ileinner");
    By arCustomerNumberField = By.id("00Nb0000004Lzhx_ileinner");
    By applicationIDField = By.id("00Nb0000003v7lg_ileinner");



    // Page Methods

    public void addOpportinity() throws IOException, InterruptedException {
        reporter.info("Selecting 'Application' Record Type");
        findElement(continueButton).click();

        reporter.info("Entering Opportunity Name");
        findElement(opportunityName).sendKeys(findElement(accountName).getAttribute("value").toString().replaceAll("\\s", ""));
        selectFromDropdown(status, "Accepted - Conditional Firm");
        selectFromDropdown(customerGroup, "SELFFUND");
        scrollToElement(driver().findElement(closeDate));
        findElement(closeDate).click();
        selectFromDropdown(sponsorshipLevel, "None");

        reporter.info("Clicking 'Save'");
        findElement(saveButton).click();
        Thread.sleep(2000);
    }

    public void addProductCatalog() throws InterruptedException {
        reporter.info("Adding Offering");
        findElement(newProductCatalogItem).click();

        findElement(offeringField).sendKeys("2320292");
        findElement(searchButton).click();
        Thread.sleep(2000);
        findElement(offeringCheckbox).click();
        Thread.sleep(2000);
        findElement(addProductsButton).click();
        Thread.sleep(2000);

        getOpportunityLink();
        getApplicationID();

        driver().get(NewStudentPage.studentLink);
        report();
    }

    public void addProductCataloggetBannerID() throws InterruptedException {
        reporter.info("Adding Offering");
        findElement(newProductCatalogItem).click();

        findElement(offeringField).sendKeys("2320292");
        findElement(searchButton).click();
        findElement(offeringCheckbox).click();
        Thread.sleep(1000);
        findElement(addProductsButton).click();
        Thread.sleep(1000);
        findElement(submitApplicationButton).click();

        getOpportunityLink();
        getApplicationID();

        driver().get(NewStudentPage.studentLink);
        getBannerID();
        getArCustomerNumber();
        report();
    }

    public String getBannerID(){ return bannerID = findElement(bannerIDField).getText(); }

    public String getOpportunityLink() {
        return opportunityLink = driver().getCurrentUrl();
    }

    public String getApplicationID() { return  applicationID = findElement(applicationIDField).getText(); }

    public String getArCustomerNumber() { return arCustomerNumber = findElement(arCustomerNumberField).getText(); }

    private void report(){
        String studentname = NewStudentPage.studentname;
        String studentLink = NewStudentPage.studentLink;
        studentinfo = studentname + " " + studentLink + " " + opportunityLink + " " + applicationID + " " + bannerID + " " + arCustomerNumber;
        reporter.info(studentname + " " + studentLink + " " + bannerID + " " + opportunityLink + " " + applicationID + " " + arCustomerNumber);
        FileIO.addStudentToArray(studentinfo);
    }

}
