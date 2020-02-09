/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: AllureReporterListener
 * Author:   Joey
 * Date:     2/7/2020 3:39 PM
 * Description: allure报告的监听器实现，，用于在test方法上增加监听器，如果失败则截图，并在报告中显示。
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       2/7/2020 3:39 PM        1.0          allure报告的监听器实现，，用于在test方法上增加监听器，如果失败则截图，并在报告中显示。
 */
package com.joey.auto.test.listener;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * 〈功能简述〉<br>
 * 〈allure报告的监听器实现，，用于在test方法上增加监听器，如果失败则截图，并在报告中显示。〉
 *
 * @author Joey
 * @create 2/7/2020
 * @since 1.0.0
 */
public class AllureReporterListener implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                takeScreenShot(testResult.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) throws IOException {

        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}