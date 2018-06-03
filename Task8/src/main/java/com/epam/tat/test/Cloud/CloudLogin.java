package com.epam.tat.test.Cloud;

import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.bo.Account.Account;
import product.MailRu.bo.Account.AccountBuilder;
import product.MailRu.service.Cloud.CloudLog;

import static product.MailRu.GlobalParameters.ACCOUNT_PASSWORD;
import static product.MailRu.GlobalParameters.ACCOUNT_USERNAME;

public class CloudLogin {

    private CloudLog cloudLog = new CloudLog();

    @Test(description = "Successful authorization")
    public void sucessLogin() throws InterruptedException {
        Account account = new AccountBuilder()
                .username(ACCOUNT_USERNAME)
                .password(ACCOUNT_PASSWORD)
                .build();
        cloudLog.logged(account);
        Assert.assertTrue(cloudLog.loggedSuccessful(), "It is not your account");
    }
}


