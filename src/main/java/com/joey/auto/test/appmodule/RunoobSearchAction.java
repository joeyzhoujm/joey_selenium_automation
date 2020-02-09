package com.joey.auto.test.appmodule;

import com.joey.auto.test.pageobject.RunoobSearchResultPage;
import com.joey.auto.test.pageobject.RunoobTutorial_POF;
import com.joey.auto.test.utility.Constant;
import com.joey.auto.test.utility.Log;
import com.joey.auto.test.utility.Utils;
import com.joey.auto.test.utility.fileutil.excel.ExcelUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class RunoobSearchAction {
    static RunoobTutorial_POF runoobTutorialPage;
    static RunoobSearchResultPage runoobSearchResultPage;


    public static void Execute(WebDriver driver, int iTestCaseRow) throws Exception {
        runoobTutorialPage.txtbox_Search().click();
        Log.info("Click action is perfromed on Search text box");
        String sSearchWord = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_SearchWord);
        runoobTutorialPage.txtbox_Search().sendKeys(sSearchWord);
        Log.info(sSearchWord + " is entered in Search text box");
        runoobTutorialPage.txtbox_Search().sendKeys(Keys.ENTER);
        Log.info("Enter action is performed on Search text box");
        Utils.waitForElement(RunoobSearchResultPage.txtbox_SearchArchive());
        Reporter.log("Search Action is successfully perfomred");
    }
}
