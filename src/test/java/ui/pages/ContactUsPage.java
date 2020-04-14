package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class ContactUsPage extends PageHelper {

    private By pageTitle = By.cssSelector("[class='page-heading bottom-indent']");
    private By subjectHeadingList = By.name("id_contact");///("#id_contact");
    private By subjectHeadingItem = By.xpath("//*[@id=\"id_contact\"]/option[2]");//("#id_contact>[value=\"2\"]");
    private By emailAddressField = By.cssSelector("#email");
    private By orderReferenceField = By.cssSelector("[class='form-control grey']");
    private By uploadFile = By.name("fileUpload");
    private By messageBox = By.xpath("//*[@id=\"message\"]");
    private By sendButton = By.id("submitMessage");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage submitContactUsForm() {
        getText(pageTitle);
       // clickOnElement(subjectHeadingField);
        selectByVisibilityOfText(subjectHeadingList, "Customer service");
        clickOnElement(emailAddressField);
        setField(emailAddressField, "farah.khan222@gmail.com");
        setField(orderReferenceField, "#01");
        driver.findElement(uploadFile).sendKeys("C:\\Users\\qakan\\OneDrive\\Desktop\\ContactInformation1.pdf");
        setField(messageBox, "This is a message.");
        clickOnElement(sendButton);
        return this;
    }


}
