package product.MailRu.screen.mail;

import com.epam.tat.framework.ui.Browser;
import com.epam.tat.framework.ui.element.Element;
import org.openqa.selenium.By;
import product.MailRu.GlobalParameters;

public class MailRuStartPage {

    private static final String USER_BANNER = "i[id='PH_user-email']";
    private Element userName = new Element(By.cssSelector(USER_BANNER));

    private static final String URL = GlobalParameters.MAIL_URL;

    private static final String LOGIN_INPUT = "login";
    private Element loginInput = new Element(By.name(LOGIN_INPUT));

    private static final String PASSWORD_INPUT = "password";
    private Element passwordInput = new Element(By.name(PASSWORD_INPUT));

    private static final String SUBMIT_BUTTON = "input[class=\'o-control\']";
    private Element submitButton = new Element(By.cssSelector(SUBMIT_BUTTON));

    public boolean isUserLoggedIn() {
        userName.waitForAppear();
        return userName.isVisible();
    }

    public MailRuStartPage open() {
        Browser.getBrowser().open(URL);
        return this;
    }

    public MailRuStartPage typeLogin(String login) {
        loginInput.typeValue(login);
        return this;
    }

    public MailRuStartPage typePassword(String password) {
        passwordInput.typeValue(password);
        return this;
    }

    public MailRuStartPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public void login(String login, String password) {
        loginInput.typeValue(login);
        passwordInput.typeValue(password);
        submitButton.click();
    }
}
