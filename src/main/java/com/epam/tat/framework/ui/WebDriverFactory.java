package com.epam.tat.framework.ui;

import com.epam.tat.framework.listener.WebDriverListener;
import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.runner.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver getWebDriver()  {
        WebDriver webDriver;
        DesiredCapabilities desireCapabilities;
        switch (Parameters.instance().getBrowserType()) {
            case CHROME:
                desireCapabilities=DesiredCapabilities.chrome();
                break;
            default:
                throw new RuntimeException("No support for: "
                        + Parameters.instance().getBrowserType());
        }
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desireCapabilities);
        }catch (MalformedURLException e){
            throw new RuntimeException("Failed run Web Driver");
        }
        Log.debug("Our driver " + webDriver);

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(WebDriverListener.create());
        return eventFiringWebDriver;
    }
}
