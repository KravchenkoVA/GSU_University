package product.MailRu;

import java.io.File;

public class GlobalParameters {

    public static final String MAIL_URL = "https://mail.ru";
    public static final String CLOUD_URL = "https://cloud.mail.ru";
    public static final String ACCOUNT_USERNAME = "vova.test.98";
    public static final String ACCOUNT_EMAIL = "vova.test.98@mail.ru";
    public static final String ACCOUNT_PASSWORD = "Kravchenko123";
    public static final String EMAIL_ADDRESS = "vova.test.98@mail.ru";
    public static final String EMAIL_SUBJECT = "Test1";
    public static final String EMAIL_CONTENT = "abrakadabra";
    public static final String DRAFTS_SUBJECT = "Drafts mail";
    public static final String DEFAULT_FOLDER_NAME = "Root";
    public static final String SECOND_FOLDER_NAME = "Milan";
    public static final String FILE_NAME = "Gullit.jpg";
    public static final File file = new File("./src/main/resources/image/Gullit.jpg");
    public static final String PATH_TO_FILE = file.getAbsolutePath();

}

