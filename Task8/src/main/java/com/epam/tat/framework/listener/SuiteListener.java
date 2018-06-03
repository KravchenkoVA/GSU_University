package com.epam.tat.framework.listener;

import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.runner.Parameters;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    public void onStart(ISuite suite) {

        String mode = Parameters.instance().getParallelMode().toString();
        suite.getXmlSuite().setParallel(mode);

        Integer threadCount = Parameters.instance().getThreadCount();
        if (threadCount != null)
            suite.getXmlSuite().setThreadCount(threadCount);

        Log.info("[SUITE STARTED] " + suite.getName());
        Log.debug("Parallel: " + suite.getXmlSuite().getParallel());
        Log.debug("Thread count: " + suite.getXmlSuite().getThreadCount());
    }

    public void onFinish(ISuite suite) {
        Log.info("[SUITE FINISHED] " + suite.getName());
    }
}
