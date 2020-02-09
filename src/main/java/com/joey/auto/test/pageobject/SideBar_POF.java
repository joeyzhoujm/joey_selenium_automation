package com.joey.auto.test.pageobject;

import com.joey.auto.test.utility.ElementsPrinter;
import com.joey.auto.test.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideBar_POF extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='container main']//div[@class='sidebar-box gallery-list']//a")
    List<WebElement> sideBar;

    public SideBar_POF(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSideBarMenus() throws Exception {
        try {
            ElementsPrinter.printElements(sideBar);
            Log.info("sideBar menus are found on the Runoob Tutorial Page");
        } catch (Exception e) {
            Log.error("sideBar menus on Runoob Tutorial page are not found");
            throw (e);
        }
        return sideBar;
    }

}
