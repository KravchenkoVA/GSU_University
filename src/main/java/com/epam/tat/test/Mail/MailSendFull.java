package com.epam.tat.test.Mail;

import com.epam.tat.framework.ui.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.GlobalParameters;
import product.MailRu.bo.Account.AccountFactory;
import product.MailRu.bo.Message.MessageFactory;
import product.MailRu.screen.mail.EMail;
import product.MailRu.service.Mail.AuthorizationMail;
import product.MailRu.service.Mail.CreateServiceMail;
import product.MailRu.service.Mail.DeleteServiceMail;

public class MailSendFull {

    private AuthorizationMail authorizationMail = new AuthorizationMail();
    private CreateServiceMail createServiceMail = new CreateServiceMail();
    private DeleteServiceMail deleteServiceMail = new DeleteServiceMail();
    EMail eMail = new EMail();

    @Test(description = "Send full letter")
    public void FullMessage() throws InterruptedException {
        authorizationMail.login(AccountFactory.createDefaultAccount());
        createServiceMail.createFullMessage(MessageFactory.createDefaultMessage());
        eMail.clickInboxTab();
        Assert.assertEquals(createServiceMail.getTextProperSubject(), GlobalParameters.EMAIL_SUBJECT + GlobalParameters.EMAIL_CONTENT);
        deleteServiceMail.deleteProperEmailFromInbox();
        eMail.clickSentTab();
        Assert.assertEquals(createServiceMail.getTextProperSubject(), GlobalParameters.EMAIL_SUBJECT + GlobalParameters.EMAIL_CONTENT);
        deleteServiceMail.deleteProperEmailFromSent();
        Browser.getBrowser().getWrappedDriver().manage().deleteAllCookies();
    }



}
