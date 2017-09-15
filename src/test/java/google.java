import annotations.TestName;
import org.testng.annotations.Test;
import pages.Gmail;
import pages.LoginPage;
import utils.BaseTest;

public class google extends BaseTest{

    @Test
    @TestName(name = "Open gmail")
    public void opengmail() throws Exception {

        Gmail gmail = Gmail.Instance;
        LoginPage login = LoginPage.Instance;

        login.open();
        login.doLogin();
        login.gmailPasswordfetch();

    }

}
