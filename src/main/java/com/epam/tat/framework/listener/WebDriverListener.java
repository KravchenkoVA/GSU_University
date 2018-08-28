package com.epam.tat.framework.listener;

import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.ui.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

public class WebDriverListener extends AbstractWebDriverEventListener {
    public static WebDriverEventListener create() {
        return new WebDriverListener();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        Log.debug("Find " + element);
        try {
            Browser.getBrowser().screenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        Log.debug("Click" + element);
    }
}
