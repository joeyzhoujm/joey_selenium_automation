package com.joey.auto.test.testcase;

import com.joey.auto.test.pageobject.BasePage;
import com.joey.auto.test.pageobject.RunoobTutorial_POF;
import com.joey.auto.test.utility.Constant;
import com.joey.auto.test.utility.Log;
import com.joey.auto.test.utility.Utils;
import com.joey.auto.test.utility.fileutil.excel.ExcelUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunoobTest {
    protected static final Logger log = LoggerFactory.getLogger(RunoobTest.class.getSimpleName());
    RunoobTutorial_POF RunoobTutorialPage;
    private WebDriver driver;
    private String sTestCaseName = this.getClass().getSimpleName();
    private int iTestCaseRow;

    @Description("测试allure report")
    @Step("打开页面")
    @BeforeTest
    public void beforeTest() throws Exception {
        Log.info("Start test");
        Log.startTestCase(sTestCaseName);
        System.out.println(Constant.Path_TestData + Constant.File_TestData);
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
        System.out.println("iTestCaseRow is:" + iTestCaseRow);
        Log.info("启动浏览器");
        driver = Utils.OpenBrowser(iTestCaseRow);
        new BasePage(driver);
        RunoobTutorialPage = PageFactory.initElements(driver, RunoobTutorial_POF.class);
    }

    @Step("遍历检查所有元素")
    @Test(priority = 0)
    public void Search() throws Exception {
        try {
            RunoobTutorialPage.txtbox_Search();
            ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
        } catch (Exception e) {
            ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
            Utils.takeScreenshot(driver, sTestCaseName);
            Log.error(e.getMessage());
            throw (e);
        }

/*        WebElement homepage=driver.findElement(By.xpath("//a[contains(text(),'首页')]")); //名字中包含首页
        System.out.println(homepage.getText());
        List<WebElement> navButtons=driver.findElements(By.xpath("//div[@class='container navigation']//a"));
        for (int i = 0; i < navButtons.size(); i++) {
            WebElement webElement =  navButtons.get(i);
            System.out.println(webElement.getText());
        }*/
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        Log.endTestCase(sTestCaseName);
    }
}
