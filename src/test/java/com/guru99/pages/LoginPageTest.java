package com.guru99.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    @Test
    public void verifyUserLoginWithTheCorrectCredential() {
        loginPage = new LoginPage(driver);

        String userName = configProperty.getProperty("userNameAccout");
        String password = configProperty.getProperty("passwordAccout");
        loginPage.userLoginWithTheCorrectCredential(userName, password);

        String actualTitle = commonDriver.getPageTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
