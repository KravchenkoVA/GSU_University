package product.MailRu.bo.Folder;

public class FolderBuilder {
    private Folder folder = new Folder();

    public FolderBuilder defaultFolderName(String defaultFolderName) {
        folder.setFolderName(defaultFolderName);
        return this;
    }

    public Folder build() {
        return folder;
    }
}
