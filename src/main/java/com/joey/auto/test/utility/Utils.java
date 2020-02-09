package com.joey.auto.test.utility;

import com.joey.auto.test.module.Brower;
import com.joey.auto.test.utility.fileutil.excel.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Utils {
    protected static final Logger Log = LoggerFactory.getLogger(Utils.class.getSimpleName());
    public static WebDriver driver = null;

    public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception {
        String sBrowserName;
        try {
            sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
            Log.info("获取浏览器类型");
            if (sBrowserName.equals("Mozilla") || sBrowserName.isEmpty()) {
                Log.info("启动Chrome");
                driver = new Brower().Chrome();
                Log.info("New driver instantiated");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                Log.info("Implicit wait applied on the driver for 20 seconds");
                driver.get(Constant.URL);
                Log.info("Web application launched successfully");
                Log.info("Opened URL:" + Constant.URL);
            }
        } catch (Exception e) {
            Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
        }
        return driver;
    }

    public static String getTestCaseName(String sTestCase) throws Exception {
        String value = sTestCase;
        try {
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;
        } catch (Exception e) {
            Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
            throw (e);
        }
    }

    public static void mouseHoverAction(WebElement mainElement, String subElement) {

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        if (subElement.equals("Accessories")) {
            action.moveToElement(driver.findElement(By.linkText("Accessories")));
            Log.info("Accessories link is found under Product Category");
        }
        if (subElement.equals("iMacs")) {
            action.moveToElement(driver.findElement(By.linkText("iMacs")));
            Log.info("iMacs link is found under Product Category");
        }
        if (subElement.equals("iPads")) {
            action.moveToElement(driver.findElement(By.linkText("iPads")));
            Log.info("iPads link is found under Product Category");
        }
        if (subElement.equals("iPhones")) {
            action.moveToElement(driver.findElement(By.linkText("iPhones")));
            Log.info("iPhones link is found under Product Category");
        }
        action.click();
        action.perform();
        Log.info("Click action is performed on the selected Product Type");
    }

    public static void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName + ".jpg"));
        } catch (Exception e) {
            Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : " + e.getMessage());
            throw new Exception();
        }
    }


}
