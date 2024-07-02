package com.guru99.pages;

import com.guru99.commonLibs.implementation.ElementsControl;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    ElementsControl elementsControl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementsControl = new ElementsControl(driver);
    }
}
