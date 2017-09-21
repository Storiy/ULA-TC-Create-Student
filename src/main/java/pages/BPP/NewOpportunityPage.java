package pages.BPP;

import org.openqa.selenium.By;

import java.io.IOException;

public class NewOpportunityPage extends NewStudentPage {

    private static NewOpportunityPage instance;
    public static NewOpportunityPage Instance = (instance != null) ? instance : new NewOpportunityPage();



    // UI Mapping

    By saveButton = By.name("save");
    By opportunityName = By.id("opp3");
    By status = By.id("opp11");
    By customerGroup = By.id("00Ng0000001MZHo");
    By closeDate = By.xpath("//*[@class='dateFormat']");
    By sponsorshipLevel = By.id("00Nb0000009XrE0");
    By newProductCatalogItem = By.name("new00Nb0000009YxlB");

    By offeringField = By.id("j_id0:searchForm:searchPageBlock:OfferingLookup");
    By searchButton = By.id("j_id0:searchForm:searchPageBlock:sBtn");
    By offeringCheckbox = By.xpath("(//input[@type='checkbox'])[1]");
    By addProductsButton = By.name("j_id0:searchForm:j_id77:j_id78:j_id79");

    public By applicationIDField = By.id("00Nb0000003v7lg_ileinner");



    // Page Methods

    public void addOpportinity() throws IOException{
        reporter.info("Selecting 'Application' Record Type");
        findElement(saveButton).click();

        reporter.info("Entering Opportunity Name");
        findElement(opportunityName).sendKeys(firstname() + lastname());
        selectFromDropdown(status, "Accepted - Conditional Firm");
        selectFromDropdown(customerGroup, "SELFFUND");
        findElement(closeDate).click();
        selectFromDropdown(sponsorshipLevel, "None");
        findElement(saveButton).click();
    }

    public void addProductCatalog(){
        reporter.info("Adding Offering");
        findElement(newProductCatalogItem).click();

        findElement(offeringField).sendKeys("2320292");
        findElement(searchButton).click();
        findElement(offeringCheckbox).click();
        findElement(addProductsButton).click();
    }

}
