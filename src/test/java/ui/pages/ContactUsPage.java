package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ContactUsPage extends PageHelper {

    private By pageTitle = By.cssSelector("[class='page-heading bottom-indent']");
    private By subjectHeadingList = By.name("id_contact");
    private By emailAddressField = By.cssSelector("#email");
    private By orderReferenceField = By.cssSelector("[class='form-control grey']");
    private By uploadFile = By.name("fileUpload");
    private By messageBox = By.xpath("//*[@id=\"message\"]");
    private By sendButton = By.id("submitMessage");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void submitContactUsForm() {
        getText(pageTitle);
        selectByVisibilityOfText(subjectHeadingList, "Customer service");
        clickOnElement(emailAddressField);
        setField(emailAddressField, "farah.khan2014ref@gmail.com");
        setField(orderReferenceField, "#12");
        driver.findElement(uploadFile).sendKeys("C:\\Projects\\contact Information.pdf");
        setField(messageBox, "I would like to contact with you to get some information.");
        clickOnElement(sendButton);
    }
}
