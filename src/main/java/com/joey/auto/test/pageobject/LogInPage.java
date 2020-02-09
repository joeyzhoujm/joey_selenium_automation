package com.joey.auto.test.pageobject;

import com.joey.auto.test.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {
    protected static WebDriver driver;

    private static WebElement element = null;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement txtbx_UserName() throws Exception {
        try {
            element = driver.findElement(By.id("username"));
            Log.info("Username text box is found on the Login Page");
        } catch (Exception e) {
            Log.error("UserName text box is not found on the Login Page");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_Password() throws Exception {
        try {
            element = driver.findElement(By.id("password"));
            Log.info("Password text box is found on the Login page");
        } catch (Exception e) {
            Log.error("Password text box is not found on the Login Page");
            throw (e);
        }
        return element;
    }

    public static WebElement btn_LogIn() throws Exception {
        try {
            element = driver.findElement(By.id("submi"));
            Log.info("Submit button is found on the Login page");
        } catch (Exception e) {
            Log.error("Submit button is not found on the Login Page");
            throw (e);
        }
        return element;
    }
}
