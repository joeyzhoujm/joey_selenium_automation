package com.joey.auto.test.testcase;

import com.joey.auto.test.module.SideBarMenu_Action;
import com.joey.auto.test.pageobject.BasePage;
import com.joey.auto.test.pageobject.NavigationBar_POF;
import com.joey.auto.test.pageobject.SideBar_POF;
import com.joey.auto.test.utility.Log;
import com.joey.auto.test.utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickAllElementsTest {
    protected static final Logger log = LoggerFactory.getLogger(ClickAllElementsTest.class.getSimpleName());
    NavigationBar_POF navigationBar;
    SideBar_POF sideBar;
    private WebDriver driver;
    private String sTestCaseName = this.getClass().getSimpleName();
    private int iTestCaseRow;

    @BeforeTest
    public void setUp() throws Exception {
        Log.startTestCase(sTestCaseName);
        Log.info("启动浏览器");
        driver = Utils.OpenBrowser(iTestCaseRow);
        new BasePage(driver);
        navigationBar = PageFactory.initElements(driver, NavigationBar_POF.class);
        sideBar = PageFactory.initElements(driver, SideBar_POF.class);
    }

    @Test(priority = 0)
    public void test() {
        try {
            SideBarMenu_Action.clickAllSideBarMenu(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*    public void ClickAllElements() throws Exception {
        try{
            List<WebElement> navigationBarMenus=navigationBar.getNavigationBarMenus();
            for (int i = 0; i < navigationBarMenus.size(); i++) {
                WebElement webElement =  navigationBarMenus.get(i);
                webElement.click();
                sideBar.getSideBarMenus();
            }
        }catch (Exception e){
            Log.error(e.getMessage());
            throw (e);
        }
    }*/

    @AfterTest
    public void afterMethod() {
        driver.quit();
        Log.endTestCase(sTestCaseName);
    }

}
