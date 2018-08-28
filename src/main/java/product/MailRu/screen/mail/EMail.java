package product.MailRu.screen.mail;

import com.epam.tat.framework.ui.Browser;
import com.epam.tat.framework.ui.element.Element;
import org.openqa.selenium.By;
import product.MailRu.GlobalParameters;

public class EMail {

    private static final String WRITE_BUTTON = "div#b-toolbar__left a[data-name='compose']";
    private Element buttonWriteaLetter = new Element(By.cssSelector(WRITE_BUTTON));

    private static final String REMOVE_BUTTON = "div[data-name='remove']";
    private Element buttonRemove = new Element(By.cssSelector(REMOVE_BUTTON));

    private static final String DRAFT_BUTTON = "a[data-mnemo='drafts']";
    private Element buttonDraft = new Element(By.cssSelector(DRAFT_BUTTON));

    private static final String SENT_BUTTON = "div[data-id='500000']";
    private Element buttonSentMail = new Element(By.cssSelector(SENT_BUTTON));

    private static final String INBOX_TAB = "div[data-id='0']>a";
    private Element inboxTab = new Element(By.cssSelector(INBOX_TAB));

    private static final String TRASH_TAB = "a[href='/messages/trash/']";
    private Element trashLink = new Element(By.cssSelector(TRASH_TAB));

    private static final String EMPTY_MAIL_SUBJECT = "div.b-datalist__item__subj";
    private Element mailEmptySubjectLocator = new Element(By.cssSelector(EMPTY_MAIL_SUBJECT));

    private static final String PROPER_MAIL_SUBJECT = "//div[@class='b-datalist__item__subj' and contains(.,'" + GlobalParameters.EMAIL_SUBJECT + "')]";
    private Element mailProperSubjectLocator = new Element(By.xpath(PROPER_MAIL_SUBJECT));

    private static final String DRAFT_CHECKBOX = "//div[@class='b-datalist__item__subj' and contains(.,'" + GlobalParameters.DRAFTS_SUBJECT + "')]";
    private Element draftCheckbox = new Element(By.xpath(DRAFT_CHECKBOX));

    private static final String EMPTY_MAIL_CHECKBOX = "//div[@data-cache-key and contains(.,'<Без темы>')]// div[contains(@class,'item-checkbox')]";
    private Element emptyMailCheckbox = new Element(By.xpath(EMPTY_MAIL_CHECKBOX));

    private static final String PROPER_MAIL_CHECKBOX = "//div[@data-cache-key and contains(.,'" + GlobalParameters.EMAIL_SUBJECT + "')]// div[contains(@class,'item-checkbox')]";
    private Element properMailCheckbox = new Element(By.xpath(PROPER_MAIL_CHECKBOX));

    private static final String DELETE_BUTTON_IN_SENT = "//div[@data-cache-key='500000_undefined_false']// div[@data-name='remove']";
    private Element deleteButtonInSent = new Element(By.xpath(DELETE_BUTTON_IN_SENT));

    private static final String DELETE_BUTTON_IN_DRAFTS = "//div[@data-cache-key='500001_undefined_false']// div[@data-name='remove']";
    private Element deleteButtonInDrafts = new Element(By.xpath(DELETE_BUTTON_IN_DRAFTS));

    private static final String DELETE_BUTTON_IN_TRASH = "//div[@data-cache-key='500002_undefined_false']// div[@data-name='remove']";
    private Element deleteButtonInTrash = new Element(By.xpath(DELETE_BUTTON_IN_TRASH));

    private static final String DRAFT_SUBJECT = "//*[text()='" + GlobalParameters.DRAFTS_SUBJECT + "']";
    private Element draftSubject = new Element(By.xpath(DRAFT_SUBJECT));


    public EMail clickWriteALetter() {
        buttonWriteaLetter.waitForAppear();
        buttonWriteaLetter.click();
        return this;
    }

    public EMail clickRemove() {
        buttonRemove.click();
        return this;
    }

    public EMail clickInboxTab() {
        inboxTab.waitForAppear();
        inboxTab.click();
        return this;
    }

    public EMail clickSentTab() {
        buttonSentMail.waitForAppear();
        buttonSentMail.click();
        return this;
    }

    public EMail clickDraft() {
        buttonDraft.waitForAppear();
        buttonDraft.click();
        return this;
    }

    public EMail clickTrashTab() {
        trashLink.waitForAppear();
        trashLink.click();
        return this;
    }

    public String getMailProperSubject() {
        mailProperSubjectLocator.waitForAppear();
        return mailProperSubjectLocator.getText();
    }

    public String getMailEmptySubject() {
        mailEmptySubjectLocator.waitForAppear();
        return mailEmptySubjectLocator.getText();
    }

    public EMail clickEmptyMailCheckbox() {
        emptyMailCheckbox.waitForAppear();
        emptyMailCheckbox.click();
        return this;
    }

    public EMail clickProperCheckbox() {
        properMailCheckbox.click();
        return this;
    }

    public EMail clickDraftCheckbox() {
        draftCheckbox.click();
        return this;
    }

    public EMail clickDeleteButtonSent() {
        deleteButtonInSent.click();
        return this;
    }

    public EMail clickDeleteButtonTrash() {
        deleteButtonInTrash.click();
        return this;
    }

    public EMail clickDeleteButtonDrafts() {
        deleteButtonInDrafts.click();
        return this;
    }

    public boolean elementIsPresent() {
        draftSubject.waitForAppear();
        return draftSubject.isPresent();
    }

    public String getAlertText() {
        return (Browser.getBrowser().getWrappedDriver().switchTo().alert().getText());
    }

}
