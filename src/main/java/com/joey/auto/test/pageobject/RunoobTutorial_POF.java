package com.joey.auto.test.pageobject;

import com.joey.auto.test.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RunoobTutorial_POF extends BasePage {
    @FindBy(id = "s")
    WebElement searchBox;

    public RunoobTutorial_POF(WebDriver driver) {
        super(driver);
    }

    public WebElement txtbox_Search() throws Exception {
        try {
            searchBox.getText();
            Log.info("Search Box is found on the Runoob Tutorial Page");
        } catch (Exception e) {
            Log.error("Search Box on Runoob Tutorial page is not found");
            throw (e);
        }
        return searchBox;
    }
}
