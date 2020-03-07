package ui.helpers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import static ui.helpers.CommonHelper.getEnvironmentProperty;
import static ui.helpers.CommonHelper.loadDriver;

public class TestHelper {
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();
    public WebDriver driver;

    @Before
    public void setDriver() {
        String username = getEnvironmentProperty("username");
        String password = getEnvironmentProperty("password");
        String emailAddress = getEnvironmentProperty("emailAddress");
        String url = getEnvironmentProperty("app.url");
        driver = loadDriver();
        driver.get(url);
    }
    @After
    public void teardownDriver() {
        driver.quit();
    }

    public void verifyEquals(String message, String expected, String actual) {
        try {
            assertEquals(message, expected, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
        }
    }
    public void verifyTrue(String message, boolean actual) {
        try {
            assertTrue(message, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
        }
    }
    public void verifyFalse(String message, boolean actual) {
        try {
            assertFalse(message, actual);
        } catch (AssertionError e) {
            errorCollector.addError(e);
        }
    }
}
