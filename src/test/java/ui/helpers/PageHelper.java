package ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static ui.helpers.CommonHelper.captureScreenshot;

public abstract class PageHelper {
    private final WebDriver driver;

    protected PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilclickableOfElement(By byElement, int timeoutSec) {
        new WebDriverWait(driver, timeoutSec).until(ExpectedConditions.elementToBeClickable(byElement));
    }
    private void waitUntilvisibilityOfElementLocatedBy(int timeoutSec, By byElement) {
        new WebDriverWait(driver, timeoutSec).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byElement));
    }
    public void clickOnElement(By byElement) {
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(byElement));
      findByWebElement(byElement).click();
    }
    public void setField(By byElement, String value) {
        findByWebElement(byElement).clear();
        findByWebElement(byElement).sendKeys(value);
    }
    public void setCheckBox(By byElement){

        List<WebElement>checkBoxElements = driver.findElements(byElement);
        for (WebElement checkBoxElement:checkBoxElements){
            if(!checkBoxElement.isSelected()){
               checkBoxElement.click();
            }
        }
    }
    public void selectByVisibilityText(By byElement) {
        Select webElement = new Select(findByWebElement(byElement));
    }
    public String getText(By byElement) {
        return findByWebElement(byElement).getText();
    }
    public List<String> getStringList(By byElement) {
        List<WebElement> webElementList = driver.findElements(byElement);
        List<String> stringList = new ArrayList<>();
        for (WebElement element : webElementList) {
            stringList.add(element.getText().trim());
        }
        return stringList;
    }

    public List<WebElement> findWebElements(By byElement) {
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
    public boolean isElementSelected(By byElement, int timeoutSecond) {
        boolean isSelected;
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeSelected(byElement));
            isSelected = true;
        } catch (Exception ignore) {
            isSelected = false;
        }
        return isSelected;
    }
    public boolean isElementEnabled(By byElement, int timeoutSec) {
        boolean isEnabled;
        try {
            new WebDriverWait(driver, timeoutSec).until(ExpectedConditions.elementToBeClickable(byElement));
            isEnabled = true;
        } catch (Exception e) {
            isEnabled = false;
        }
        return isEnabled;
    }
    public void switchToWindow(By byElement) {
        String window = driver.getWindowHandle();
        driver.switchTo().window(window);
    }
    public void closeAllWindows() {
        driver.quit();
    }
    public void mouseOver(By byElement) {
        new Actions(driver).moveToElement(driver.findElement(byElement)).build().perform();
        driver.findElement(byElement);
    }
    public void switchToFrame(By byElement) {
        driver.switchTo().frame(driver.findElement(byElement));
        driver.findElement(byElement);
    }

    public String getString(By byElement) {
        return findByWebElement(byElement).getText();
    }

     public void scrollDownToTheElement(By byElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("0",byElement);
        waitUntilvisibilityOfElementLocatedBy(5,byElement);
    }
    public WebElement findByWebElement(By byElement){
        WebElement webElement = null;
        try {
            waitUntilvisibilityOfElementLocatedBy(5, byElement);
            webElement= driver.findElement(byElement);
        }catch (Exception e){
            captureScreenshot();
        fail("failed : to locate element using By :" + byElement +"\n check Screenshot\n" + e.getStackTrace());
        }
        return webElement;
    }
}
