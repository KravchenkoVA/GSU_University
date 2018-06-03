package product.MailRu.bo.Account;

import product.MailRu.GlobalParameters;

public class AccountFactory {

    public static Account createDefaultAccount() {
        Account account = new Account();
        account.setUsername(GlobalParameters.ACCOUNT_USERNAME);
        account.setEmail(GlobalParameters.ACCOUNT_EMAIL);
        account.setPassword(GlobalParameters.ACCOUNT_PASSWORD);
        return account;
    }

    public static Account createAccount() {
        Account account = new Account();
        return account;
    }
}
