package com.joey.auto.test.pageobject;

import com.joey.auto.test.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RunoobSearchResultPage extends BasePage {
    protected static WebDriver driver;
    private static WebElement element;


    public RunoobSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement txtbox_SearchArchive() {
        element = null;
        try {
            element = driver.findElement(By.xpath(".//*[@id='searchform s']"));
            Log.info("Search Archive is found on the Runoob Search Result Page");
        } catch (Exception e) {
            Log.error("Search Archive on Runoob Search Result page is not found");
            throw (e);
        }
        return element;
    }
}
