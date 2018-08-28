package com.epam.tat.framework.runner;

import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class MailRunner {

        public static void main(String[] args)
        {
            TestNG testNG = new TestNG();
            List<String> files = Arrays.asList("./src/main/resources/XML/Mail.xml");
            testNG.setTestSuites(files);
            testNG.run();
        }
    }

