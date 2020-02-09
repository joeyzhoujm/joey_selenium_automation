package com.joey.auto.test.pageobject;

import com.joey.auto.test.utility.LocationUtil;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 10;
    public static boolean testResult;
    public String title;
    protected WebDriver driver;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        maxBrowser();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        testResult = true;
    }

    public BasePage(WebDriver driver, final String title) {
        this.driver = driver;
        this.title = title;
        try {
            new WebDriverWait(driver, TIMEOUT).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver arg0) {
                    // TODO Auto-generated method stub
                    String acttitle = arg0.getTitle();
                    return acttitle.equals(title);
                }
            });
        } catch (TimeoutException te) {
            throw new IllegalStateException("当前页面title(" + driver.getTitle() + ")与预期(" + title + ")不一致");
        }
        maxBrowser();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        testResult = true;
    }

    public WebElement findElement(String loc) {
        return driver.findElement(LocationUtil.getLocation(loc));
    }

    public void sendKeys(String loc, String var1) {
        findElement(loc).sendKeys(var1);
    }

    public void click(String loc) {
        findElement(loc).click();
    }

    public void submit(String loc) {
        findElement(loc).submit();
    }

    public void switchToFrame(String loc) {
        driver.switchTo().frame(findElement(loc));
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void closeAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void moveToElement(String loc) {
        new Actions(driver).moveToElement(findElement(loc)).perform();
    }

    public void doubleClick(String loc) {
        new Actions(driver).doubleClick(findElement(loc)).perform();
    }

    public void contextClick(String loc) {
        new Actions(driver).contextClick(findElement(loc)).perform();
    }

    public void dragAndDrop(String source, String target) {
        new Actions(driver).dragAndDrop(findElement(source), findElement(target)).perform();
    }

    public void closeBrowser() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void maxBrowser() {
        driver.manage().window().maximize();
    }
}
