package com.epam.tat.test.Mail;

import com.epam.tat.framework.ui.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.bo.Account.AccountFactory;
import product.MailRu.bo.Message.MessageFactory;
import product.MailRu.screen.mail.EMail;
import product.MailRu.service.Mail.AuthorizationMail;
import product.MailRu.service.Mail.CreateServiceMail;
import product.MailRu.service.Mail.DeleteServiceMail;

public class MailEmpty {
    private AuthorizationMail authorizationMail = new AuthorizationMail();
    private CreateServiceMail createServiceMail = new CreateServiceMail();
    private DeleteServiceMail deleteServiceMail = new DeleteServiceMail();
    EMail eMail = new EMail();

    @Test(description = "Sending an empty email")
    public void testEmptyEmail() throws InterruptedException {
        authorizationMail.login(AccountFactory.createDefaultAccount());
        createServiceMail.createEmptyMessage(MessageFactory.createEmptyMessage());
        eMail.clickInboxTab();
        Assert.assertEquals(createServiceMail.getTextEmptySubject(), "<Без темы>");
        deleteServiceMail.deleteEmptyEmailFromInbox();
        eMail.clickSentTab();
        Assert.assertEquals(createServiceMail.getTextEmptySubject(), "<Без темы>");
        deleteServiceMail.deleteEmptyEmailFromSent();
        Browser.getBrowser().getWrappedDriver().manage().deleteAllCookies();
    }

}
