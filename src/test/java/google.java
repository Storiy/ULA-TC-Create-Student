import annotations.TestName;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.BaseTest;

public class google extends BaseTest{

    @Test
    @TestName(name = "Create new student")
    public void newstudent() throws Exception {

        LoginPage login = LoginPage.Instance;
        MainPage main = MainPage.Instance;

        login.open();
        login.doLogin();

    }

}
