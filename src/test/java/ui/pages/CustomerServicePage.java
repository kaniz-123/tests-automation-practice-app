package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class CustomerServicePage extends PageHelper {

    public CustomerServicePage(WebDriver driver) {
        super(driver);
    }
    private By subjectHeading = By.id("id_contact");
    private By email = By.id("email");
    private By orderReference = By.id("id_order");
    private By fileUpload = By.id("fileUpload");
    private By messageBox = By.id("message");
    private By send = By.id("submitMessage");

    public void submitForm(){
    selectByVisibilityOfText(subjectHeading,"Customer service");
    setField(email,"test123@cognit.com");
    setField(orderReference,"#12");
    driver.findElement(fileUpload).sendKeys("C:\\Projects\\contact Information.pdf");
    setField(messageBox,"I would like to know some information.");
    clickOnElement(send);
    }
}
