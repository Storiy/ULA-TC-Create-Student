package pages;

import org.openqa.selenium.By;
import pages.ULA.NewStudentPage;
import utils.FileIO;

import java.io.IOException;
import java.util.Random;

public class MainPage extends BasePage{

    private static MainPage instance;
    public static MainPage Instance = (instance != null) ? instance : new MainPage();



    // UI Mapping

    By accountsTab = By.xpath(".//*[@title='Accounts Tab']");
    By newAccountButton = By.xpath(".//*[@title='New']");
    By continueButton = By.xpath(".//*[@title='Continue']");



    // Page Methods

    public NewStudentPage openNewStudentPage(String university){
        reporter.info("Opening student creation page");
        findElement(accountsTab).click();
        findElement(newAccountButton).click();

        if (university == "BPP"){
            findElement(continueButton).click();
        }

        return NewStudentPage.Instance;
    }

    public static String gender(){
        String [] gender = {"Male", "Female"};
        Random random = new Random();
        int index = random.nextInt(gender.length);
        return gender[index];
    }

    public static String firstname() throws IOException {
        String studentfirstname = null;
        if (gender() == "Male") {
            studentfirstname = FileIO.readfromfile("firstname_f");
        }
        else if (gender() == "Female") {
            studentfirstname =  FileIO.readfromfile("firstname_m");
        }
        return studentfirstname;
    }

    public static String lastname() throws IOException {
        String studentlastname = FileIO.readfromfile("lastname");
        return studentlastname;
    }

    public static String street() throws IOException {
        String street = FileIO.readfromfile("street");
        return street;
    }
}
