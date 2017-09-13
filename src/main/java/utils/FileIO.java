package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileIO {

    static String TARGET_FOLDER = "target";
    static String DATA_RESOURCES = "src/main/resources/data/";
    static String CONFIG_FILE = System.getProperty("config");
    static String PROPERTIES = "src/main/resources/" + (( CONFIG_FILE == null ) ? "default" : CONFIG_FILE) + ".properties";

    public static String getConfigProperty(String fieldName){
        String fileLocation = PROPERTIES;
        String result   = null;

        try {
            //open file
            File file = new File(fileLocation);
            //open input stream to read file
            FileInputStream fileInput = new FileInputStream(file);
            //create Properties object
            Properties properties = new Properties();
            //load properties from file
            properties.load(fileInput);
            //close file
            fileInput.close();
            //get property by name
            result = properties.getProperty(fieldName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Config was not found");
        } catch (IOException e) {
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Config was not opened");
        } catch (Exception e){
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Field was not found: " + fieldName);
        }
        return result;
    }

    public static String takeScreenshot(WebDriver driver){
        return takeScreenshot(driver, String.valueOf(System.currentTimeMillis()));
    }

    public static String takeScreenshot(WebDriver driver, String name){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = name + "screen.png";
        try {
            FileUtils.copyFile(file, new File(TARGET_FOLDER + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public static String getDataFile(String filename){
            return DATA_RESOURCES + filename;
    }

}
