package com.epam.tat.test.Cloud;

import org.testng.Assert;
import org.testng.annotations.Test;
import product.MailRu.bo.Account.AccountFactory;
import product.MailRu.bo.Folder.FolderFactory;
import product.MailRu.screen.cloud.CloudInside;
import product.MailRu.service.Cloud.CloudFile;
import product.MailRu.service.Cloud.CloudFolder;
import product.MailRu.service.Cloud.CloudLog;

public class WorkWithFiles {

    private CloudLog cloudLog = new CloudLog();
    private CloudFolder cloudFolder = new CloudFolder();
    private CloudFile cloudFile = new CloudFile();
    private CloudInside cloudInside = new CloudInside();

    @Test(description = "Upload file")
    public void updFile() throws InterruptedException{
        cloudLog.logged(AccountFactory.createDefaultAccount());
        cloudFolder.createFolder(FolderFactory.createDefaultFolder());
        cloudInside.openFolder();
        cloudFile.uploadFile();
        Assert.assertTrue(cloudFile.fileIsPresent(), "File is not upload");
    }

    @Test(description = "drag and Drop", dependsOnMethods = "updFile")
    public void dragandDrop()throws InterruptedException {
        cloudFolder.createFolder(FolderFactory.createSecondFolder());
        cloudFile.dragAndDrop();
        Assert.assertTrue(cloudFile.dragIsTrue(), "Remove is fail");
    }

    @Test(description = "share link for image", dependsOnMethods = "dragandDrop")
    public void shareLink()throws InterruptedException {
        Assert.assertTrue(cloudFile.shareLink(), "It's not your link");
    }

}
