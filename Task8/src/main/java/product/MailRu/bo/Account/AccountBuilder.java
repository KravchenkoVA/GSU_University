package product.MailRu.bo.Account;

public class AccountBuilder {

    private Account account = new Account();

    public AccountBuilder username(String username) {
        account.setUsername(username);
        return this;
    }

    public AccountBuilder email(String email) {
        account.setEmail(email);
        return this;
    }

    public AccountBuilder password(String password) {
        account.setPassword(password);
        return this;
    }

    public Account build() {
        return account;
    }
}
