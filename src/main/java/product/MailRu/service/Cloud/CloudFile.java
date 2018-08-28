package product.MailRu.service.Cloud;

import product.MailRu.GlobalParameters;
import product.MailRu.screen.cloud.CloudInside;

public class CloudFile {

    public void uploadFile() {
        CloudInside cloudInside = new CloudInside();
        cloudInside
                .uploadTub()
                .uploadFile(GlobalParameters.file);
    }

    public boolean fileIsPresent ()  {
        CloudInside cloudInside = new CloudInside();
        return cloudInside.checkImage();
    }


    public void dragAndDrop() {
        CloudInside cloudInside = new CloudInside();
        cloudInside.checkFolder();
        cloudInside
                .dragAndDrop()
                .removeFile();
    }

    public boolean dragIsTrue ()  {
        CloudInside cloudInside = new CloudInside();
        return cloudInside.checkRemove();
    }

    public boolean shareLink()  {
        CloudInside cloudInside = new CloudInside();
        return ((cloudInside.shareLink()).equals(GlobalParameters.FILE_NAME));
    }

}
