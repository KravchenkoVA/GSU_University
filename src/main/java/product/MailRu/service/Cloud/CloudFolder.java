package product.MailRu.service.Cloud;

import product.MailRu.bo.Folder.Folder;
import product.MailRu.screen.cloud.CloudInside;

public class CloudFolder {
        public void createFolder(Folder folder){
            CloudInside cloudInside = new CloudInside();
            cloudInside
                    .clickButtonCreateFolder()
                    .typeFolderName(folder.getFolderName())
                    .clickButtonAdd();
        }

        public boolean checkFolder() {
            CloudInside cloudInside = new CloudInside();
            return  cloudInside.checkFolder();
        }

        public void deleteFolder() {
            CloudInside cloudInside = new CloudInside();
            cloudInside
                    .deleteFolder();
        }

        public boolean checkTestFolderIsDeleted () {
            CloudInside cloudInside = new CloudInside();
            return (checkFolder()==false);
        }
    }

