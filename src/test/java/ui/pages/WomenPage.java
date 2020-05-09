package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class WomenPage extends PageHelper {

    private By allSpecialLink = By.cssSelector("[title='All specials']");
    public WomenPage(WebDriver driver) {
        super(driver);
    }
    public SpecialOfferPage navigateToSpecialOfferPage() {
        scrollDownToTheElement(allSpecialLink);
        clickOnElement(allSpecialLink);
        return new SpecialOfferPage(driver);
    }
}
