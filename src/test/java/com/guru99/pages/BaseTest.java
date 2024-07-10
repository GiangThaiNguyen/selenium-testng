package com.guru99.pages;

import com.guru99.commonLibs.implementation.CommonDriver;
import com.guru99.commonLibs.implementation.ElementsControl;
import com.guru99.commonLibs.utils.ConfigUtils;
import com.guru99.commonLibs.utils.ReportUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    String currentDirectory;
    String configFileName;
    Properties configProperty;

    WebDriver driver;
    CommonDriver commonDriver;

    // Pages object.
    LoginPage loginPage;

    //Report variables.
    ReportUtils reportUtils;
    String reportFileName;

    @BeforeSuite
    public void preSetup() throws Exception{
        currentDirectory = System.getProperty("user.dir");
        configFileName = currentDirectory + "/src/test/java/com/guru99/config/config.properties";
        configProperty = ConfigUtils.readProperty(configFileName);

        //Setup reports
        reportFileName = currentDirectory + "/src/test/java/com/guru99/reports/selenium-report.html";
        reportUtils = new ReportUtils(reportFileName);
    }

    @BeforeTest
    public void setup() throws Exception {
        commonDriver = new CommonDriver(configProperty.getProperty("browserType"));
        driver = commonDriver.getDriver();
        commonDriver.navigateToUrl(configProperty.getProperty("baseUrl"));
    }

    @AfterTest
    public void tearDown() {
        commonDriver.closeAllBrowser();
    }

    @AfterSuite
    public void postTearDown() {
        reportUtils.flushReport();
    }
}
