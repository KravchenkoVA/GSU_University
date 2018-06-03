package product.MailRu.bo.Message;

public class MessageBuilder {

    private Message message = new Message();

    public MessageBuilder properAddress(String properAddress) {
        message.setAddress(properAddress);
        return this;
    }

    public MessageBuilder properSubject(String properSubject) {
        message.setSubject(properSubject);
        return this;
    }

    public MessageBuilder properText(String properText) {
        message.setText(properText);
        return this;
    }

    public Message build() {
        return message;
    }

}

