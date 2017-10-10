import annotations.TestName;
import org.testng.annotations.Test;
import pages.BPP.NewOpportunityPage;
import pages.BPP.NewStudentPage;
import pages.LoginPage;
import pages.MainPage;
import utils.BaseTest;

public class NewStudentBPP_noID extends BaseTest{

    @Test (invocationCount = 1)
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

        //Enter Student info and address
        student.enterStudentInfo();

        //Navigate to opportunity creation page
        student.openNewOpportunityPage();

        //Add new opportunity
        opp.addOpportinity();
        opp.addProductCatalog();

    }
}
