package ru.vladislav.titov.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.vladislav.titov.helper.LoginHelper;
import ru.vladislav.titov.helper.NavigationHelper;
import ru.vladislav.titov.helper.PostHelper;
import ru.vladislav.titov.utils.XmlParser;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestManager {

    private static TestManager ourInstance;

    private WebDriver driver;
    private String baseUrl;
    public StringBuffer verificationErrors = new StringBuffer();

    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private PostHelper postHelper;

    public static TestManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new TestManager();
        }
        return ourInstance;
    }

    private TestManager() {
        System.setProperty("webdriver.gecko.driver", "E:\\Programming\\testing\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = XmlParser.getInstance().getBaseUrl();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        postHelper = new PostHelper(this);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }
}
