package com.guru99.pages;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    @Test
    public void verifyUserLoginWithTheCorrectCredential() {
        loginPage = new LoginPage(driver);
        reportUtils.createATestCase("verifyUserLoginWithTheCorrectCredential");
        reportUtils.addTestLog(Status.INFO,"Performing log...");

        String userName = configProperty.getProperty("userNameAccount");
        String password = configProperty.getProperty("passwordAccount");
        loginPage.userLoginWithTheCorrectCredential(userName, password);

        String actualTitle = commonDriver.getPageTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";

        reportUtils.addTestLog(Status.INFO,"Comparing expected and actual title.");
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
