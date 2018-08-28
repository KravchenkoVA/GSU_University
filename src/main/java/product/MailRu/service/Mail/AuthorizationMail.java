package product.MailRu.service.Mail;

import product.MailRu.bo.Account.Account;
import product.MailRu.screen.mail.MailRuStartPage;

public class AuthorizationMail {

    public void login(Account account) {
        logged(account);
    }

    public void logged(Account account) {
        MailRuStartPage mailRuStartPage = new MailRuStartPage();
        mailRuStartPage
                .open()
                .typeLogin(account.getUsername())
                .typePassword(account.getPassword())
                .clickSubmit();
    }

    public boolean loggedSuccessful() {
        return new MailRuStartPage().isUserLoggedIn();
    }

}



