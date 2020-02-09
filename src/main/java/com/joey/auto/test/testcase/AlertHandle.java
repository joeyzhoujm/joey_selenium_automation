package com.joey.auto.test.testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//https://blog.csdn.net/weixin_30856965/article/details/95564036

/**
 * 测试Alert
 */
public class AlertHandle {
    private WebDriver driver;

    @Test(enabled = false)
//    明确知道系统哪个地方会弹alert
    public void ff1() {
//        System.setProperty(key, value);
        driver = new ChromeDriver();
        driver.get("file:///Users/user/Documents/qiaojiafei/seleniumtest.html");
        driver.findElement(By.xpath("//*[@id='alert']/input")).click();
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }

    //捕获时增加智能等待，该方法对弹出的alert弹框进行智能等待，避免了NoAlertPresentException异常的抛出
    public void ff2() {
//        System.setProperty(key, value);
        driver = new ChromeDriver();
        driver.get("file:///Users/user/Documents/qiaojiafei/seleniumtest.html");
        driver.findElement(By.xpath("//*[@id='alert']/input")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Alert alert = wait.until(new ExpectedCondition<Alert>() {
                @Override
                public Alert apply(WebDriver driver) {
                    try {
                        return driver.switchTo().alert();
                    } catch (NoAlertPresentException e) {
                        return null;
                    }
                }
            });
            alert.accept();
        } catch (NullPointerException e) {
            /* Ignore */
            System.out.println("ff2 nullpoint");
        }
    }

    //捕获和处理alert时都增加判断，使用selenium自带的ExpectedConditions
    public void ff3() {
//        System.setProperty(key, value);
        driver = new ChromeDriver();
        driver.get("file:///Users/user/Documents/qiaojiafei/seleniumtest.html");
        driver.findElement(By.xpath("//*[@id='alert']/input")).click();

        boolean flag = false;
        Alert alert = null;
        try {

            new WebDriverWait(driver, 10).until(ExpectedConditions
                    .alertIsPresent());
            alert = driver.switchTo().alert();
            flag = true;
            // alert.accept();
        } catch (NoAlertPresentException NofindAlert) {
            // TODO: handle exception

            NofindAlert.printStackTrace();
            // throw NofindAlert;
        }

        if (flag) {
            alert.accept();
        }
    }
}
