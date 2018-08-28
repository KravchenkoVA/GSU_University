package com.epam.tat.framework.runner;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.epam.tat.framework.listener.SuiteListener;
import com.epam.tat.framework.listener.TestListener;
import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.ui.SuiteFactory;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestRunner {

    public static void addListener(TestNG testNG, Object listener) {
        Method addListener;
        try {
            addListener = testNG.getClass().getMethod("addListener", ITestNGListener.class);
        } catch (NoSuchMethodException e) {
            try {
                addListener = testNG.getClass().getMethod("addListener", Object.class);
            } catch (NoSuchMethodException e1) {
                throw new IllegalArgumentException("No addListener method found", e1);
            }
        }
        try {
            addListener.invoke(testNG, listener);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        PropertyConfigurator.configureAndWatch(Parameters.instance().getPathToPropertiesFileLog4j());
        Log.info("Parse cli");
        parseCli(args);
        Log.info("Start application");
        configureTestNG();
        Log.info("End application");
    }

    private static void parseCli(String[] args) {
        Log.info("Parse clis using JCommander");
        JCommander jCommander = new JCommander(Parameters.instance());
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            Log.error(e.getMessage(),e);
            System.exit(1);
        }
        if (Parameters.instance().isHelp()) {
            jCommander.usage();
            System.exit(0);
        }
    }

    private static void configureTestNG() {
        TestNG testNG = new TestNG();
        addListener(testNG,new TestListener());
        addListener(testNG,new SuiteListener());
        testNG.setTestSuites(SuiteFactory.getSuite());
        testNG.run();
    }
}
