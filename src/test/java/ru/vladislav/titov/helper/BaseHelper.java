package ru.vladislav.titov.helper;

import org.openqa.selenium.*;
import ru.vladislav.titov.manager.TestManager;

public class BaseHelper {

    public boolean acceptNextAlert = true;
    protected WebDriver driver;
    protected TestManager manager;

    public BaseHelper(TestManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
