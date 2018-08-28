package com.epam.tat.test.Mail;

import com.epam.tat.framework.ui.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.bo.Account.Account;
import product.MailRu.bo.Account.AccountBuilder;
import product.MailRu.service.Configuration;
import product.MailRu.service.Mail.AuthorizationMail;

import static product.MailRu.GlobalParameters.ACCOUNT_PASSWORD;
import static product.MailRu.GlobalParameters.ACCOUNT_USERNAME;

public class MailLogin extends Configuration {

    private AuthorizationMail authorizationMail = new AuthorizationMail();

    @Test(description = "This test for success logged")
    public void testSuccessfulLogin () throws InterruptedException {
        Account goodLogged = new AccountBuilder()
                .username(ACCOUNT_USERNAME)
                .password(ACCOUNT_PASSWORD)
                .build();
        authorizationMail.logged(goodLogged);
        Assert.assertTrue(authorizationMail.loggedSuccessful(), "Login failed for: ");
        Browser.getBrowser().getWrappedDriver().manage().deleteAllCookies();
    }

}

