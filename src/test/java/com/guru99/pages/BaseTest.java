package com.guru99.pages;

import com.guru99.commonLibs.implementation.CommonDriver;
import com.guru99.commonLibs.implementation.ElementsControl;
import com.guru99.commonLibs.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
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

    LoginPage loginPage;

    @BeforeSuite
    public void preSetup() throws Exception{
        currentDirectory = System.getProperty("user.dir");
        configFileName = currentDirectory + "/src/test/java/com/guru99/config/config.properties";
        configProperty = ConfigUtils.readProperty(configFileName);
    }

    @BeforeTest
    public void setup() throws Exception {
        commonDriver = new CommonDriver(configProperty.getProperty("browserType"));
        driver = commonDriver.getDriver();
        commonDriver.navigateToUrl(configProperty.getProperty("baseUrl"));
    }

    @AfterTest
    public void teardown() {
        commonDriver.closeAllBrowser();
    }
}
