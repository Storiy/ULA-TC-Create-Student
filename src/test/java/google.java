import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ULA.NewOpportunityPage;
import pages.ULA.NewStudentPage;
import utils.BaseTest;

import static pages.BasePage.findElement;

public class google extends BaseTest{

    @Test
    @TestName(name = "Create new student")
    public void newstudent() throws Exception {

        LoginPage login = LoginPage.Instance;
        MainPage main = MainPage.Instance;
        NewStudentPage student = NewStudentPage.Instance;
        NewOpportunityPage opp = NewOpportunityPage.Instance;

        //Login to Salesforce
        login.open();
        login.doLogin();

        //Navigate to student creation page
        main.openNewStudentPage();

        //Create new student account
        student.enterStudentInfo();

        //Navigate to opportunity creation page
        student.openNewOpportunityPage();

        //Add new opportunity
        opp.addOpportunity();
        opp.addCatalogOptions();
        opp.submitOpportunity();

        Assert.assertTrue( findElement(opp.statusVerification).getText().contains("Application Submitted"));
    }

}
