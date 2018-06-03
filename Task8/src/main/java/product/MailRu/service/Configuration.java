package product.MailRu.service;

import com.epam.tat.framework.ui.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Configuration {
        @AfterClass(description = "Close chrome browser")
        public void closeBrowser(){
            Browser.getBrowser().close();
        }
}
