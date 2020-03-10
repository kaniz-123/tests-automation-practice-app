package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static ui.helpers.CommonHelper.captureScreenshot;

public abstract class PageHelper {
    public final WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilclickableOfElement(By byElement, int timeoutSec) {
        new WebDriverWait(driver, timeoutSec).until(ExpectedConditions.elementToBeClickable(byElement));
    }

    private void waitUntilvisibilityOfElementLocatedBy(int timeoutSec, By byElement) {
        new WebDriverWait(driver, timeoutSec).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byElement));
    }

    public void clickOnElement(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(byElement));
        findByWebElement(byElement).click();
    }

    public void setField(By byElement, String value) {
        findByWebElement(byElement).clear();
        findByWebElement(byElement).sendKeys(value);
    }

    public void setCheckBox(By byElement) {
        List<WebElement> checkBoxElements = driver.findElements(byElement);
        for (WebElement checkBoxElement : checkBoxElements) {
            if (!checkBoxElement.isSelected()) {
                checkBoxElement.click();
            }
        }
    }

    public void selectByVisibilityText(By byElement, String visibleText) {
        Select select = new Select(findByWebElement(byElement));
        select.selectByVisibleText(visibleText);
    }

    public String getText(By byElement) {
        return findByWebElement(byElement).getText();
    }

    public List<String> getStringList(By byElement) {
        List<String> stringList = new ArrayList<>();
        List<WebElement> webElementList = findWebElements(byElement);
        for (WebElement element : webElementList) {
            stringList.add(element.getText().trim());
        }
        return stringList;
    }

    public List<WebElement> findWebElements(By byElement) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(driver.findElement(byElement)));
        return driver.findElements(byElement);
    }

    public boolean isElementFound(By byElement) {
        boolean isFound;
        try {
            waitUntilvisibilityOfElementLocatedBy(5, byElement);
            isFound = true;
        } catch (Exception ignore) {
            isFound = false;
        }
        return isFound;
    }

    public boolean isElementSelected(By byElement) {
        return findByWebElement(byElement).isSelected();
    }

    public boolean isElementEnabled(By byElement, int timeoutSec) {
        return findByWebElement(byElement).isEnabled();
    }

    public void switchToWindow() {
        String window = driver.getWindowHandle();
        driver.switchTo().window(window);
    }

    public void closeAllWindows() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void mouseOver(By byElement) {
        waitUntilvisibilityOfElementLocatedBy(5, byElement);
        new Actions(driver).moveToElement(driver.findElement(byElement)).build().perform();
    }

    public void switchToFrame(By byElement) {
        driver.switchTo().frame(findByWebElement(byElement));
    }

    public String getString(By byElement) {
        return findByWebElement(byElement).getText().trim();
    }

    public void scrollDownToTheElement(By byElement) {
        new Actions(driver).moveToElement(findByWebElement(byElement)).build().perform();
    }

    public WebElement findByWebElement(By byElement) {
        WebElement webElement = null;
        try {
            waitUntilvisibilityOfElementLocatedBy(5, byElement);
            webElement = driver.findElement(byElement);
        } catch (Exception e) {
            captureScreenshot();
            fail("failed : to locate element using By :" + byElement + "\n check Screenshot\n" + e.getStackTrace());
        }
        return webElement;
    }
}
