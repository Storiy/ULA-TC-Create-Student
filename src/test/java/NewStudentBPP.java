import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.BPP.NewOpportunityPage;
import pages.BPP.NewStudentPage;
import utils.BaseTest;

import static pages.BasePage.findElement;

public class NewStudentBPP extends BaseTest{

    @Test
    @TestName(name = "Create new BPP student")
    public void newStudentBPP() throws Exception {

        LoginPage login = LoginPage.Instance;
        MainPage main = MainPage.Instance;
        NewStudentPage student = NewStudentPage.Instance;
        NewOpportunityPage opp = NewOpportunityPage.Instance;

        //Login to Salesforce
        login.open();
        login.doLogin("BPP");

        //Navigate to student creation page
        main.openNewStudentPage("BPP");
        student.enterStudentInfo();
        //student.


    }
}
