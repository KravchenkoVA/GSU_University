package com.epam.tat.framework.ui;

import com.epam.tat.framework.runner.Parameters;
import java.util.ArrayList;
import java.util.List;

import static com.epam.tat.framework.ui.SuiteType.BOTH;
import static com.epam.tat.framework.ui.SuiteType.CLOUD;
import static com.epam.tat.framework.ui.SuiteType.MAIL;

public class SuiteFactory {

    public static List<String> getSuite() {
        List<String> suitesList = new ArrayList<>();
        switch (Parameters.instance().getSuiteType()) {
            case MAIL:
                suitesList.clear();
                suitesList.add(Parameters.instance().getMailxml());
                break;
            case CLOUD:
                suitesList.clear();
                suitesList.add(Parameters.instance().getCloudxml());
                break;
            case BOTH:
                suitesList.clear();
                suitesList.add(Parameters.instance().getMailxml());
                suitesList.add(Parameters.instance().getCloudxml());
        }
        return suitesList;
    }
}
