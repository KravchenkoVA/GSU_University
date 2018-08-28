package product.MailRu.bo.Folder;

import product.MailRu.GlobalParameters;

public class FolderFactory {
    public static Folder createDefaultFolder() {
        Folder folder = new Folder();
        folder.setFolderName(GlobalParameters.DEFAULT_FOLDER_NAME);
        return folder;
    }

    public static Folder createSecondFolder() {
        Folder folder = new Folder();
        folder.setFolderName(GlobalParameters.SECOND_FOLDER_NAME);
        return folder;
    }

}
