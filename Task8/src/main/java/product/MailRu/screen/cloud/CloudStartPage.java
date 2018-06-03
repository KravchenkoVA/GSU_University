package product.MailRu.screen.cloud;

import com.epam.tat.framework.ui.Browser;
import com.epam.tat.framework.ui.element.Element;
import org.openqa.selenium.By;
import product.MailRu.GlobalParameters;

public class CloudStartPage {
    private static final String BUTTON_ENTRY = "a#PH_authLink";
    private Element buttonEnty = new Element(By.cssSelector(BUTTON_ENTRY));

    private static final String LOGIN = "Login";
    private Element loginInput = new Element(By.name(LOGIN));

    private static final String PASS = "Password";
    private Element passwordInput = new Element(By.name(PASS));

    private static final String SUBMIT_BUTTON = "div.x-ph__popup__footer__controls__col.x-ph__popup__footer__controls__col_left";
    private Element submitButton = new Element(By.cssSelector(SUBMIT_BUTTON));

    private static final String URL = GlobalParameters.CLOUD_URL;

    public CloudStartPage open() {
        Browser.getBrowser().open(URL);
        return this;
    }

    public CloudStartPage clickEntry() {
        buttonEnty.click();
        return this;
    }

    public CloudStartPage typeLogin(String login) {
        loginInput.waitForAppear();
        loginInput.typeValue(login);
        return this;
    }

    public CloudStartPage typePassword(String password) {
        passwordInput.waitForAppear();
        passwordInput.typeValue(password);
        return this;
    }

    public CloudStartPage clickSubmit() {
        submitButton.waitForAppear();
        submitButton.click();
        return this;
    }


}

