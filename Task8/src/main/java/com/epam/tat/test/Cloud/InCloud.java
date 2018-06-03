package com.epam.tat.test.Cloud;

import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.bo.Account.AccountFactory;
import product.MailRu.bo.Folder.FolderFactory;
import product.MailRu.service.Cloud.CloudFolder;
import product.MailRu.service.Cloud.CloudLog;

public class InCloud {
    private CloudLog cloudLog = new CloudLog();
    private CloudFolder cloudFolder = new CloudFolder();

    @Test(description = "Create folder")
    public void createFolder() throws InterruptedException {
        cloudLog.logged(AccountFactory.createDefaultAccount());
        cloudFolder.createFolder(FolderFactory.createDefaultFolder());
        Assert.assertTrue(cloudFolder.checkFolder(), "Folder not found");
    }

    @Test(description = "Delete Folder", dependsOnMethods = "createFolder")
    public void deleteFolder() throws InterruptedException{
        cloudFolder.deleteFolder();
        Assert.assertEquals(cloudFolder.checkFolder(), false, "Folder  found");
    }
}
