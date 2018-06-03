package com.epam.tat.framework.ui.element;

import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.ui.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class Element {
    private By by;

    public Element(By by) {
        this.by = by;
        Reporter.log("Create " + by);
    }

    public By getBy() {
        return by;
    }

    public WebElement getWrappedWebElement() {
        Log.debug("find " + by);
        return Browser.getBrowser().findElement(by);
    }

    public boolean isPresent() {
        Log.debug("element is present " + by);
        return Browser.getBrowser().isElementPresent(by);
    }

    public boolean isVisible() {
        Log.debug("element is visible " + by);
        return Browser.getBrowser().isElementVisible(by);
    }

    public void waitForAppear() {
        Log.debug("wait for Appear" + by);
         Browser.getBrowser().waitForElementIsVisible(by);
    }

    public String getText() {
        Log.debug("get text " + by);
        return getWrappedWebElement().getText();
    }

    public void click() {
        Log.debug("click " + by);
        getWrappedWebElement().click();
    }

    public void typeValue(String value) {
        Log.debug("value is type " + by);
        WebElement element = getWrappedWebElement();
        element.clear();
        element.sendKeys(value);
    }
    public void switchToIframe(){
        Log.debug("switch to " + by);
        WebElement element = getWrappedWebElement();
        Browser.getBrowser().getWrappedDriver().switchTo().frame(element);
    }

    public void contextClick(){
        Log.debug("click is context " + by);
        WebElement element = getWrappedWebElement();
        Actions actions = new Actions(Browser.getBrowser().getWrappedDriver());
        actions.contextClick(element).perform();
    }

    public void openLink(){
        Log.debug("link is open " + by);
        WebElement element = getWrappedWebElement();
        Browser.getBrowser().getWrappedDriver().get(element.getAttribute("value"));
    }

    public void dragAndDropFile(String Locator){
        Log.debug("drag and drop file " + by);
        WebElement elementWhichToDrag = getWrappedWebElement();
        WebElement elementWhereToDrop = Browser.getBrowser().findElement(By.xpath(Locator));
        Actions builder = new Actions(Browser.getBrowser().getWrappedDriver());
        builder.dragAndDrop(elementWhichToDrag, elementWhereToDrop).perform();
    }

    public void highlightElement() throws InterruptedException {
        Log.debug("highlight " + by);
        WebElement element = getWrappedWebElement();
        ((JavascriptExecutor)Browser.getBrowser().getWrappedDriver()).executeScript("arguments[0].style.border='5px solid yellow'", element);
        Thread.sleep(1000);
        ((JavascriptExecutor)Browser.getBrowser().getWrappedDriver()).executeScript("arguments[0].style.border='0'", element);
    }
}
