package com.epam.tat.framework.appenders;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class TestNGReportAppender extends AppenderSkeleton {
    public boolean requiresLayout() {
        return true;
    }

    protected void append(LoggingEvent event) {
        Reporter.log(layout.format(event));
    }

    public void close() {
    }
}

