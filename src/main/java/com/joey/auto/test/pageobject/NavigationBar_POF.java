package com.joey.auto.test.pageobject;

import com.joey.auto.test.utility.ElementsPrinter;
import com.joey.auto.test.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationBar_POF extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='container navigation']//ul[@class='pc-nav']//a[not(contains(text(),'首页')) and not(contains(text(),'云服务器'))]")
    List<WebElement> navigationBar;

    public NavigationBar_POF(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNavigationBarMenus() throws Exception {
        try {
            ElementsPrinter.printElements(navigationBar);
            Log.info("navigationBar menus are found on the Runoob Tutorial Page");
        } catch (Exception e) {
            Log.error("navigationBar menus on Runoob Tutorial page are not found");
            throw (e);
        }
        return navigationBar;
    }

}
