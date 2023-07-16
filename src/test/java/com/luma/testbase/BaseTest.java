package com.luma.testbase;

import com.luma.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Utility {
    String browser = com.luma.propertyreader.PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        //closeBrowser();
    }

}

