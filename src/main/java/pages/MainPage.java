package pages;

import utils.FileIO;

import java.util.ArrayList;

public class MainPage extends BasePage{

    private static MainPage instance;
    public static MainPage Instance = (instance != null) ? instance : new MainPage();
}
