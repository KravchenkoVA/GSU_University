package product.MailRu.screen.cloud;

import com.epam.tat.framework.ui.element.Element;
import org.openqa.selenium.By;
import product.MailRu.GlobalParameters;

import java.io.File;

public class CloudInside {

    private static final String USER_BANNER = "i#PH_user-email";
    private Element userBanner = new Element(By.cssSelector(USER_BANNER));

    private static final String CREATE_BUTTON = "div[data-group='create']";
    private Element createButton = new Element(By.cssSelector(CREATE_BUTTON));

    private static final String FOLDER_NAME = "input.layer__input";
    private Element folderName = new Element(By.cssSelector(FOLDER_NAME));

    private static final String ADD_FOLDER = "button[data-name='add']";
    private Element buttonAddFolder = new Element(By.cssSelector(ADD_FOLDER));

    private static final String CHECK_FOLDER = "div[data-id='/" + GlobalParameters.DEFAULT_FOLDER_NAME + "']";
    private Element checkFolder = new Element(By.cssSelector(CHECK_FOLDER));

    private static final String CHECK_BOX = "//div[@data-id='/" + GlobalParameters.DEFAULT_FOLDER_NAME + "']//div[@class='b-checkbox__box']";
    private Element checkBox = new Element(By.xpath(CHECK_BOX));

    private static final String BUTTON_DELETE = "div[data-name='remove']";
    private Element buttonDelete = new Element(By.cssSelector(BUTTON_DELETE));

    private static final String BUTTON_DELETE_FORM = "button[data-name='remove']";
    private Element buttonDeleteForm = new Element(By.cssSelector(BUTTON_DELETE_FORM));

    private static final String BUTTON_INFO_FORM_CLOSE = "//div[@class='layer_trashbin-tutorial']//button[@data-name='close']";
    private Element buttonInfoFormClose = new Element(By.xpath(BUTTON_INFO_FORM_CLOSE));

    private Element buttonOpenFolder = checkFolder;

    private static final String UPLOAD_FILE = "//div[@class='layer_upload__controls']//input[@type='file']";
    private Element uploadFile = new Element(By.xpath(UPLOAD_FILE));

    private static final String CHECK_IMG = "div[data-id='/" + GlobalParameters.DEFAULT_FOLDER_NAME + "/" + GlobalParameters.FILE_NAME + "']";
    private Element checkImg = new Element(By.cssSelector(CHECK_IMG));

    private static final String DROP_FOLDER = "//div[@data-id='/" + GlobalParameters.DEFAULT_FOLDER_NAME + "/" + GlobalParameters.SECOND_FOLDER_NAME + "']/div[@data-bem='b-thumb']";
    private Element dropFolder = new Element(By.xpath(DROP_FOLDER));

    private static final String BUTTON_REMOVE = "button[data-name='move']";
    private Element buttonRemove = new Element(By.cssSelector(BUTTON_REMOVE));

    private static final String FOLDER_IN_FOLDER = "div[data-id='/" + GlobalParameters.DEFAULT_FOLDER_NAME + "/" + GlobalParameters.SECOND_FOLDER_NAME + "']";
    private Element folderInFolder = new Element(By.cssSelector(FOLDER_IN_FOLDER));


    private static final String CHECK_REMOVE = "div[data-id='/" + GlobalParameters.DEFAULT_FOLDER_NAME + "/" + GlobalParameters.SECOND_FOLDER_NAME + "/" + GlobalParameters.FILE_NAME + "']";
    private Element checkRemove = new Element(By.cssSelector(CHECK_REMOVE));

    private static final String CONTEXT_LINK = "a[data-name='publish']";
    private Element contextLink = new Element(By.cssSelector(CONTEXT_LINK));

    private static final String INPUT_LINK = "input[readonly]";
    private Element inputLink = new Element(By.cssSelector(INPUT_LINK));

    private static final String CHECK_LINK = "a.viewer__information__link";
    private Element checkLink = new Element(By.cssSelector(CHECK_LINK));

    private static final String FOLDER_DATA = "a[data-name='folder']";
    private Element folderData = new Element(By.cssSelector(FOLDER_DATA));

    private static final String UPl_TUB = "div.b-toolbar__item";
    private Element uploadTub = new Element(By.cssSelector(UPl_TUB));

    public String getuserBannerText() {
        userBanner.waitForAppear();
        return userBanner.getText();
    }

    public CloudInside clickButtonCreateFolder() {
        createButton.waitForAppear();
        createButton.click();
        folderData.click();
        return this;
    }

    public CloudInside typeFolderName(String folderNameText) {
        folderName.waitForAppear();
        folderName.typeValue(folderNameText);
        return this;
    }

    public CloudInside clickButtonAdd() {
        buttonAddFolder.click();
        checkFolder.waitForAppear();
        return this;
    }

    public boolean checkFolder() {
        return checkFolder.isPresent();
    }

    public CloudInside deleteFolder() {
        checkFolder.waitForAppear();
        checkBox.click();
        buttonDelete.click();
        buttonDeleteForm.waitForAppear();
        buttonDeleteForm.click();
        buttonInfoFormClose.waitForAppear();
        buttonInfoFormClose.click();
        return this;
    }

    public CloudInside openFolder() {
        buttonOpenFolder.click();
        return this;
    }

    public CloudInside uploadTub() {
        uploadTub.waitForAppear();
        uploadTub.click();
        return this;
    }

    public void uploadFile(File file) {
        uploadFile.typeValue(file.getAbsolutePath());
    }

    public boolean checkImage() {
        checkImg.waitForAppear();
        return checkImg.isPresent();
    }

    public CloudInside dragAndDrop() {
        dropFolder.waitForAppear();
        checkImg.dragAndDropFile(DROP_FOLDER);
        return this;
    }

    public CloudInside removeFile() {
        buttonRemove.click();
        return this;
    }

    public boolean checkRemove() {
        folderInFolder.waitForAppear();
        folderInFolder.click();
        checkRemove.waitForAppear();
        return checkRemove.isPresent();
    }

    public String shareLink() {
        checkRemove.contextClick();
        contextLink.waitForAppear();
        contextLink.click();
        inputLink.waitForAppear();
        inputLink.openLink();
        return checkLink.getText();
    }


}
