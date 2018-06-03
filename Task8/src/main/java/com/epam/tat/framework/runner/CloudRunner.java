package com.epam.tat.framework.runner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import java.util.Arrays;
import java.util.List;


import com.epam.tat.framework.listener.SuiteListener;
import com.epam.tat.framework.listener.TestListener;
import com.epam.tat.framework.logging.Log;
import com.epam.tat.framework.ui.SuiteFactory;
import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class CloudRunner {

        public static void main(String[] args)
        {
            TestNG testNG = new TestNG();
            List<String> files = Arrays.asList("./src/main/resources/XML/Cloud.xml");
            testNG.setTestSuites(files);
            testNG.run();
        }
    }

