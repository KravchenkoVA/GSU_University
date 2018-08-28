package product.MailRu.service.Cloud;

import product.MailRu.GlobalParameters;
import product.MailRu.bo.Account.Account;
import product.MailRu.screen.cloud.CloudInside;
import product.MailRu.screen.cloud.CloudStartPage;

public class CloudLog {



    public void logged(Account account) {
        CloudStartPage cloudStartPage = new CloudStartPage();
        cloudStartPage
                .open()
                .clickEntry()
                .typeLogin(account.getUsername())
                .typePassword(account.getPassword())
                .clickSubmit();
    }

    public boolean loggedSuccessful() {
        return (new CloudInside().getuserBannerText()).equals(GlobalParameters.ACCOUNT_EMAIL);
    }

}



