package com.qa.Utils;

import com.qa.Base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class InputActions extends TestBase {
    static WebElement scroll;
    private static Robot robot;

    // This method will navigate to the previous page
    public static void navigateBack() {
        try {
            getDriver().navigate().back();
            log("pass", "Navigated to previous screen");
        } catch (Exception e) {
            log("fail", "Unable to navigate to previous screen");
        }
    }

    // This method will navigate to the next page
    public static void navigateForword() {
        try {
            getDriver().navigate().forward();
            log("pass", "Navigated to next screen");
        } catch (Exception e) {
            log("fail", "Unable to navigate to next screen");
        }
    }

    // This method will refresh the current page
    public static void refreshPage() {
        getDriver().navigate().refresh();
        TestWaits.threadSleep(500);
    }

    // This Method is used for Mouse hover on webelement
    public static void mouseHover(WebElement element, String elementName) {
        try {
            new Actions(getDriver()).moveToElement(element).build().perform();
            log("pass", "Mouse hovered over the element " + elementName);
        } catch (Exception e) {
            log("fail", "Unable to mouse hover over the element " + elementName);
        }
    }

    // This Method is used for Mouse hover on webelement with pause
    public static void mouseHoverandPause(WebElement element, String elementName) {
        try {
            new Actions(getDriver()).moveToElement(element).pause(1000).build().perform();
            log("pass", "Mouse hovered over the element " + elementName);
        } catch (Exception e) {
            log("fail", "Unable to mouse hover over the element " + elementName);
        }
    }

    // This Method is used for Mouse hover and click on webelement
    public static void mouseHoverandClick(WebElement element, String elementName) {
        try {
            new Actions(getDriver()).moveToElement(element).click().perform();
            log("pass", "Mouse hovered and clicked the element " + elementName);
        } catch (Exception e) {
            log("fail", "Unable to mouse hover and click the element " + elementName);
        }
    }

    // This method is used to select value in dropdown by index
    public static void dropdownSelectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    // This method is used to select value in dropdown by value
    public static void dropdownSelectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value.toLowerCase());
    }

    // This method is used to select value in dropdown by text
    public static void dropdownSelectByText(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    // This method is used to delete existing data in the field
    public static void clearWebField(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    // This method is used to delete existing data in the field
    public static void clearBackSpace(WebElement element) {
        while (!element.getAttribute("value").equals("")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    // This Method is used for Mouse Click
    public static void click(WebElement element, String elementName) {
        if (element.isEnabled()) {
            element.click();
            log("pass", "Performed click action on " + elementName + " field");
        } else {
            log("fail", "Unable to perform click action on " + elementName + " field");
        }
    }

    // This Method is used for entering String text
    public static void sendKeys(WebElement element, String elementName, String keyToSend) {
        clearWebField(element);
        if (element.isEnabled()) {
            element.sendKeys(keyToSend);
            log("pass", "Entered text " + "<b>" + "\"" + keyToSend + "\"" + "</b>" + " in the " + elementName + " field");
        } else {
            log("fail", "Unable to enter text " + "\"" + keyToSend + "\"" + " in the " + elementName + " field");
        }
    }

    // This Method is used for entering integer text
    public static void sendKeysInt(WebElement element, String elementName, int keyToSend) {
        clearWebField(element);
        if (element.isEnabled()) {
            JavascriptExecutor jse = (JavascriptExecutor)getDriver();
            jse.executeScript("arguments[0].value = arguments[1];", element, keyToSend);
            log("pass", "Entered " + "<b>" + "\"" + keyToSend + "\"" + "</b>" + " in the " + elementName + " field");
        } else {
            log("fail", "Unable to enter " + "\"" + keyToSend + "\"" + " in the " + elementName + " field");
        }
    }

    // This Method is used for Mouse Click and Send
    public static void clickAndSend(WebElement element, String elementName, String keyToSend) {
        click(element, elementName);
        sendKeys(element, elementName, keyToSend);
    }

    // This Method is used to enter space
    public static void enterSpace(WebElement element, String elementName) {
        clearWebField(element);
        try {
            element.sendKeys("" + Keys.SPACE + Keys.SPACE);
            log("pass", "Entered space in the " + elementName + " text field");
        } catch (Exception e) {
            log("fail", "Unable to enter space in the text field");
        }
    }

    // This method clicks backspace key
    public static void clickEscape() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    // This method will scroll the page until given webelement is visible
    public static void scrollintoView(WebElement element) {
        new Actions(getDriver()).scrollToElement(element).perform();
    }

    // This method will scroll the page by the given values
    public static void scrollByValue(int right, int down) {
        new Actions(getDriver()).scrollByAmount(right, down).perform();
    }

    // This method will scroll to the top of the page
    public static void scrolltoStart() {
        new Actions(getDriver()).scrollToElement(getDriver().findElement(By.tagName("body"))).perform();
    }

    // This method will scroll to the bottom of the page
    public static void scrolltoEnd() {
        getDriver().findElement(By.tagName("body")).sendKeys(Keys.END);
    }

    // This Method is used for selecting particular element from the list
    public static void listSelectandClick(String xpathExpression) {
        List<WebElement> list = getDriver().findElements(By.xpath(xpathExpression));
        for (int i = 0; i <= list.size(); i++) {
            String str = list.get(i).getText();
            if (str.equalsIgnoreCase("string")) {
                list.get(i).click();
                break;
            }
        }
    }

}
