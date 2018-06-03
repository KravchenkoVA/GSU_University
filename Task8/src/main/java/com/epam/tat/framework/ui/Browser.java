package com.epam.tat.framework.ui;


import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.runner.CommonTestRuntimeException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Browser implements WrapsDriver {

    public static final int ELEMENT_WAIT_TIMEOUT_SECOND = 30;

    private static ThreadLocal<Browser> instance = new ThreadLocal<>();

    private WebDriver driver;

    public Browser() {
        this.driver = WebDriverFactory.getWebDriver();
    }

    public static synchronized Browser getBrowser() {
        if (instance.get() == null) {
            instance.set(new Browser());
        }
        return instance.get();
    }

    public WebDriver getWrappedDriver() {
        return driver;
    }

    public void open(String url) {
        Log.debug("Open " + url);
        driver.get(url);
    }

    public void close() {
        Log.debug("Close");
        try {
            if (getWrappedDriver() != null) {
                getWrappedDriver().quit();
            }
        } finally {
            instance.set(null);
        }
    }

    public WebElement findElement(By by) {
        Log.debug("find Element " + by);
        return driver.findElement(by);
    }

    public boolean isElementPresent(By by) {
        Log.debug("is Element Present " + by);
        return driver.findElements(by).size() > 0;
    }


    public boolean isElementVisible(By by) {
        Log.debug("is Element Visible " + by);
        if (!isElementPresent(by)) {
            return false;
        }
        return findElement(by).isDisplayed();
    }

    public void waitForElementIsPresent(By by) {
        Log.debug("wait For Element IsPresent " + by);
        WebDriverWait wait = new WebDriverWait(driver, ELEMENT_WAIT_TIMEOUT_SECOND);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementIsVisible(By by) {
        Log.debug("wait For Element IsVisible " + by);
        WebDriverWait wait = new WebDriverWait(driver, ELEMENT_WAIT_TIMEOUT_SECOND);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

        public byte[] screenshot() throws IOException{
            String nanoTime = System.nanoTime() + ".png";
            File screenshotFile = new File("log/screenshot/" + System.nanoTime() + ".png");
            try {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
                Log.info("Screenshot taken: file://" + screenshotFile.getAbsolutePath());
                return screenshotBytes;
            } catch (IOException e) {
                throw new CommonTestRuntimeException("Failed to write screenshot: ", e);
            }
        }
}

