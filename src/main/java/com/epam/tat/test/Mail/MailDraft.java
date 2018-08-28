package com.epam.tat.test.Mail;

import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.bo.Account.AccountFactory;
import product.MailRu.bo.Message.MessageFactory;
import product.MailRu.screen.mail.EMail;
import product.MailRu.service.Mail.AuthorizationMail;
import product.MailRu.service.Mail.CreateServiceMail;
import product.MailRu.service.Mail.DeleteServiceMail;

public class MailDraft {
    private AuthorizationMail authorizationMail = new AuthorizationMail();
    private CreateServiceMail createServiceMail = new CreateServiceMail();
    private DeleteServiceMail deleteServiceMail = new DeleteServiceMail();
    EMail eMail = new EMail();
    @Test(description = "Experiments with draft")
    public void testDraft() throws InterruptedException {
        authorizationMail.login(AccountFactory.createDefaultAccount());
        createServiceMail.createDraft(MessageFactory.createDraftsMessage());
        eMail.clickDraft();
        deleteServiceMail.deleteDraft();
        eMail.clickTrashTab();
        deleteServiceMail.deleteDraftFromTrash();
        Assert.assertTrue(deleteServiceMail.checkDraftsEmailIsDeleted());
    }
}
