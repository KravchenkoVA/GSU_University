package product.MailRu.screen.mail;

import com.epam.tat.framework.ui.Browser;
import com.epam.tat.framework.ui.element.Element;
import org.openqa.selenium.By;

public class LetterForm {
    private static final String TO_INPUT = "textarea[data-original-name='To']";
    private Element toInput = new Element(By.cssSelector(TO_INPUT));

    private static final String SUBJECT_INPUT_LOCATOR = "Subject";
    private Element subjectInput = new Element(By.name(SUBJECT_INPUT_LOCATOR));

    private static final String LETTER_TEXT = "body[id='tinymce']";
    private Element letterText = new Element(By.cssSelector(LETTER_TEXT));

    private static final String SEND_BUTTON = "div[data-name='send']";
    private Element sendButton = new Element(By.cssSelector(SEND_BUTTON));

    private static final String SAVE_DRAFT = "div[data-name='saveDraft']";
    private Element saveDraft = new Element(By.cssSelector(SAVE_DRAFT));

    private static final String CONTENT_IFRAME = "//iframe[contains(@id,'toolkit')]";
    private Element contentIframe = new Element(By.xpath(CONTENT_IFRAME));

    private static final String CONTINUE_BUTTON = "//div[@class='is-compose-empty_in']//button[@type='submit']";
    private Element continueButton = new Element(By.xpath(CONTINUE_BUTTON));


    public LetterForm typeTo(String addressee) {
        toInput.typeValue(addressee);
        return this;
    }

    public LetterForm typeSubject(String subject) {
        subjectInput.typeValue(subject);
        return this;
    }

    public LetterForm typeLetterText(String text) {
        contentIframe.switchToIframe();
        letterText.typeValue(text);
        Browser.getBrowser().getWrappedDriver().switchTo().defaultContent();
        return this;
    }

    public LetterForm clickSaveDraft() {
        saveDraft.click();
        return this;
    }


    public LetterForm clickSendButton() {
        sendButton.click();
        return this;
    }

    public LetterForm clickContinueButton() {
        continueButton.waitForAppear();
        continueButton.click();
        return this;
    }

}
