package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helpers.PageHelper;

public class AuthenticationPage extends PageHelper {
    private By emailAddressField = By.id("email");
    private By passwordField = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage loginForm() {

        setField(emailAddressField, "farah.khan2014ref@gmail.com");
        setField(passwordField, "Gpti4869");
        clickOnElement(signInButton);
        return new MyAccountPage(driver);
    }
}
