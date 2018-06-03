package com.epam.tat.framework.runner;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.epam.tat.framework.ui.BrowserType;
import com.epam.tat.framework.ui.ParallelMode;
import com.epam.tat.framework.ui.SuiteType;

public class Parameters {

    private static Parameters instance;

    @Parameter(names = {"--chrome", "-c"}, description = "Path to my ChromeDriver")
    private String chromeDriver = "./src/main/resources/driver/chromedriver.exe";

    @Parameter(names = {"--mailXml", "-mx"}, description = "Path to my mailxml")
    private String mailXMl = "./src/main/resources/XML/Mail.xml";

    @Parameter(names = {"--cloudXml", "-cx"}, description = "Path to my cloudxml")
    private String cloudXML = "./src/main/resources/XML/Cloud.xml";

    @Parameter(names = {"--properties", "-pr"}, description = "Path to my properties file")
    private static String PATH_TO_PROPERTIES_FILE_LOG4J = "./src/main/resources/log4j.properties";

    @Parameter(names = "--help", help = true, description = "How to use")
    private boolean help;

    @Parameter(names = {"--browser", "-b"}, description = "Browser type", converter = BrowserTypeConverter.class)
    private BrowserType browserType = BrowserType.CHROME;

    @Parameter(names = {"--suite", "-su"}, description = "Suite type", converter = SuiteTypeConverter.class)
    private SuiteType suiteType = SuiteType.MAIL;

    @Parameter(names = {"--parallel", "-p"}, description = "Parallel methods"
            , converter = ParallelModeTypeConverter.class)
    private ParallelMode parallelMode = ParallelMode.METHODS;

    @Parameter(names = {"--threadcount", "-tc"}, description = "Number of threads to use when running tests " + "in parallel")
    private Integer threadCount = 1;

    public static synchronized Parameters instance() {
        if (instance == null) {
            instance = new Parameters();
        }
        return instance;
    }

    public String getChromeDriver() {
        return chromeDriver;
    }

    public boolean isHelp() {
        return help;
    }

    public String getMailxml() {
        return mailXMl;
    }

    public String getCloudxml() {
        return cloudXML;
    }

    public String getPathToPropertiesFileLog4j() {
        return PATH_TO_PROPERTIES_FILE_LOG4J;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public SuiteType getSuiteType() {
        return suiteType;
    }

    public ParallelMode getParallelMode() {
        return parallelMode;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public static class BrowserTypeConverter implements IStringConverter<BrowserType> {

        public BrowserType convert(String s) {
            return BrowserType.valueOf(s.toUpperCase());
        }
    }

    public static class SuiteTypeConverter implements IStringConverter<SuiteType> {

        public SuiteType convert(String s) {
            return SuiteType.valueOf(s.toUpperCase());
        }
    }

    public static class ParallelModeTypeConverter implements IStringConverter<ParallelMode> {
        public ParallelMode convert(String s) {
            return ParallelMode.valueOf(s.toUpperCase());
        }
    }
}
