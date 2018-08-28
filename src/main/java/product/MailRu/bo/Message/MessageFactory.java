package product.MailRu.bo.Message;

import product.MailRu.GlobalParameters;

public class MessageFactory {

    public static Message createDefaultMessage() {
        Message message = new Message();
        message.setAddress(GlobalParameters.EMAIL_ADDRESS);
        message.setSubject(GlobalParameters.EMAIL_SUBJECT);
        message.setText(GlobalParameters.EMAIL_CONTENT);
        return message;
    }

    public static Message createDraftsMessage() {
        Message message = new Message();
        message.setSubject(GlobalParameters.DRAFTS_SUBJECT);
        return message;
    }

    public static Message createEmptyMessage() {
        Message message = new Message();
        message.setAddress(GlobalParameters.EMAIL_ADDRESS);
        message.setSubject("");
        message.setText("");
        return message;
    }
}

