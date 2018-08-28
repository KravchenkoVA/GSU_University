package product.MailRu.service.Mail;

import com.epam.tat.framework.ui.Browser;
import product.MailRu.screen.mail.EMail;

public class DeleteServiceMail {

    public void deleteDraft() {
        EMail eMail = new EMail();
        eMail
                .clickProperCheckbox()
                .clickDeleteButtonDrafts();
    }

    public void deleteDraftFromTrash() {
        EMail eMail = new EMail();
        eMail
                .clickProperCheckbox()
                .clickDeleteButtonDrafts();
        Browser.getBrowser().getWrappedDriver().navigate().refresh();
    }

    public void deleteEmptyEmailFromSent() {
        EMail mailRuSentScreen = new EMail();
        mailRuSentScreen
                .clickEmptyMailCheckbox()
                .clickDeleteButtonSent();
    }

    public void deleteProperEmailFromSent() {
        EMail mailRuSentScreen = new EMail();
        mailRuSentScreen
                .clickProperCheckbox()
                .clickDeleteButtonSent();
    }

    public void deleteEmptyEmailFromInbox() {
        EMail eMail = new EMail();
        eMail
                .clickEmptyMailCheckbox()
                .clickRemove();
    }

    public void deleteProperEmailFromInbox() {
        EMail eMail = new EMail();
        eMail
                .clickProperCheckbox()
                .clickRemove();
    }

    public boolean checkDraftsEmailIsDeleted() {
        EMail eMail = new EMail();
        return eMail.elementIsPresent();
    }
}
