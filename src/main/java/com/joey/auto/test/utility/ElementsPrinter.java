package com.joey.auto.test.utility;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPrinter {

    public static void printElementSize(List<WebElement> elements) {
        int elementsSize = elements.size();
        Log.info("Size of elements is : " + elementsSize);
    }

    public static void printElements(List<WebElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            WebElement webElement = elements.get(i);
            Log.info("Element " + i + " is : " + webElement.getText() + " " + webElement.getTagName());
        }
    }
}
