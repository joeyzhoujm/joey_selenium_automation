package com.joey.auto.test.utility;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class LocationUtil {
    /**
     * 定位信息，比如id=kw
     *
     * @param var 格式xpath=//*[@id="kw"]
     * @return org.openqa.selenium.By
     */
    public static By getLocation(String var) {
        List list = Arrays.asList(var.split("=", 2));
        if (list.size() < 2 || "".equals(list.get(1))) {
            return null;
        }
        String loc = String.valueOf(list.get(1));
        switch (list.get(0).toString().toUpperCase()) {
            case "ID":
                return By.id(loc);
            case "NAME":
                return By.name(loc);
            case "XPATH":
                return By.xpath(loc);
            case "CSS":
                return By.cssSelector(loc);
            case "TAG":
                return By.tagName(loc);
            case "CLASS":
                return By.className(loc);
            case "LINKTEXT":
                return By.linkText(loc);
            case "PARTIALLINKTEXT":
                return By.partialLinkText(loc);
            default:
                return null;
        }
    }
}
