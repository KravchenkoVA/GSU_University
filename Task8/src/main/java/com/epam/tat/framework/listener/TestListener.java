package com.epam.tat.framework.listener;

import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.ui.Browser;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class TestListener extends TestListenerAdapter implements ITestNGListener {

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        Log.info("[TEST STARTED] " + testContext.getName());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        Log.info("[TEST FINISHED] " + testContext.getName());
        Log.debug("Quits this driver, closing every associated window.");
        Browser.getBrowser().close();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        try {
            Browser.getBrowser().screenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onTestFailure(tr);
    }
}
