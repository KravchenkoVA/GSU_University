package product.MailRu.service.Mail;

import product.MailRu.bo.Message.Message;
import product.MailRu.screen.mail.EMail;
import product.MailRu.screen.mail.LetterForm;


public class CreateServiceMail {

    public void createFullMessage(Message message) {
        EMail eMail = new EMail();
        eMail.clickWriteALetter();
        LetterForm letterForm = new LetterForm();
        letterForm
                .typeTo(message.getAddress())
                .typeSubject(message.getSubject())
                .typeLetterText(message.getText())
                .clickSendButton();
    }

    public void createEmptyMessage(Message message) {
        EMail eMail = new EMail();
        eMail.clickWriteALetter();
        LetterForm letterForm = new LetterForm();
        letterForm
                .typeTo(message.getAddress())
                .typeSubject(message.getSubject())
                .typeLetterText(message.getText())
                .clickSendButton()
                .clickContinueButton();
    }

    public void createDraft(Message message) {
        EMail eMail = new EMail();
        eMail.clickWriteALetter();
        LetterForm letterForm = new LetterForm();
        letterForm
                .typeSubject(message.getSubject())
                .clickSaveDraft();
    }

    public String getTextProperSubject() {
        EMail eMail = new EMail();
        return eMail.getMailProperSubject();
    }

    public String getTextEmptySubject() {
        EMail eMail = new EMail();
        return eMail.getMailEmptySubject();
    }

    public String getTextAlert() {
        EMail eMail = new EMail();
        return eMail.getAlertText();
    }
}
