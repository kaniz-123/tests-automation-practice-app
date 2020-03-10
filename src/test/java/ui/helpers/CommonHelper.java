package ui.helpers;

import com.google.common.base.Strings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.fail;

public class CommonHelper {
    private static WebDriver driver;
    public static final String DEFAULT_DRIVER = "chrome";

    public static WebDriver loadDriver() {
        String driverType = System.getenv("DRIVER_TYPE");
        if (Strings.isNullOrEmpty(driverType)) {
            driverType = DEFAULT_DRIVER;
        }
        if ("chrome".equalsIgnoreCase(driverType)) {
            Map<String, String> prefMap = new HashMap<>();
            prefMap.put("download.default_directory", getSeleniumDownloadDirectoryPath());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("prefs", prefMap);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equalsIgnoreCase(driverType)) {
            WebDriverManager.firefoxdriver().setup();
            //Firefox browser settings
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.dri", getSeleniumDownloadDirectoryPath());
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("disable-infobars");
            firefoxOptions.setProfile(firefoxProfile);
            //TODO add more chrome setting options

            driver = new FirefoxDriver(firefoxOptions);
        } else if ("ie".equalsIgnoreCase(driverType) && SystemUtils.IS_OS_WINDOWS) {
            WebDriverManager.iedriver().setup();
            //TODO add IE setting options
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
    public static String getSeleniumDownloadDirectoryPath() {
        String defaultDownloadPath = SystemUtils.IS_OS_WINDOWS ? "C:\\selenium-tests-downloads\\" : System.getProperty("user.home") + "/selenium-tests-downloads/";
        File directory = new File(defaultDownloadPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        System.out.println("++++++++++ All Selenium Test downloads located: " + defaultDownloadPath + " ++++++++++");
        return defaultDownloadPath;
    }
    public static String getEnvironmentProperty(String propertyName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(getEnvironment());
        return resourceBundle.getString(propertyName);
    }
    private static String getEnvironment() {
        String env = null;
        try {
            env = System.getenv("ENVIRONMENT");
            if (StringUtils.isEmpty(env)) {
                env = "test";
            }
            env.toLowerCase();
        } catch (Exception e) {
            fail("Please enter a valid environment, please use one of the valid environment name: test, preprod, prod");
        }
        return env;
    }
    public static void captureScreenshot(){
        String filePath = getSeleniumDownloadDirectoryPath()+"ShopingCartTest.png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File(filePath));
            System.out.println("++++++++++ Screenshot captured and saved:"+ filePath + "+++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void closeDriver() {
        if (driver != null){
            driver.quit();
        }
    }
}
