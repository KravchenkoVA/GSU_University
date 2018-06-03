package com.epam.tat.framework.ui;

import com.epam.tat.framework.listener.WebDriverListener;
import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.runner.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver() {
        WebDriver webDriver;
        switch (Parameters.instance().getBrowserType()) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",
                        Parameters.instance().getChromeDriver());
                webDriver = new ChromeDriver();
                Log.debug("Our driver " + webDriver);
                break;
            default:
                throw new RuntimeException("No support for: "
                        + Parameters.instance().getBrowserType());
        }

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(WebDriverListener.create());
        return eventFiringWebDriver;
    }
}
