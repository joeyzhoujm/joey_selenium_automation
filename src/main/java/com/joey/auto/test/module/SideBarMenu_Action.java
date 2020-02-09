package com.joey.auto.test.module;

import com.joey.auto.test.pageobject.NavigationBar_POF;
import com.joey.auto.test.pageobject.SideBar_POF;
import com.joey.auto.test.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarMenu_Action {
    public static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void clickAllSideBarMenu(WebDriver driver) throws Exception {
        try {
            NavigationBar_POF navigationBar = PageFactory.initElements(driver, NavigationBar_POF.class);
            SideBar_POF sideBar = PageFactory.initElements(driver, SideBar_POF.class);
            List<WebElement> navigationBarMenus = navigationBar.getNavigationBarMenus();
            for (int i = 0; i < navigationBarMenus.size(); i++) {
                WebElement webElement = navigationBarMenus.get(i);
                webElement.click();
                sideBar.getSideBarMenus();
            }
        } catch (Exception e) {
            Log.error(e.getMessage());
            throw (e);
        }
    }
}
