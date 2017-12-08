package ru.vladislav.titov.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.vladislav.titov.manager.TestManager;
import ru.vladislav.titov.model.AccountData;

import java.util.concurrent.TimeUnit;

public class LoginHelper extends BaseHelper {

    public LoginHelper(TestManager manager) {
        super(manager);
    }

    public boolean isLoggedIn() {
        return !isElementPresent(By.xpath("//*[@id=\"log_in\"]/form/table/tbody/tr[1]/td[2]/div[2]/input"));
    }

    public boolean isLoggedIn(AccountData user) {
        return getCurrentUserName().equals(user.getUserName());
    }

    private String getCurrentUserName() {
        String[] holderPaths = new String[] {
                "//*[@id=\"authorName\"]/span",
                "//*[@id=\"inf_menu\"]/li[1]/p/a/strong"
        };

        for (String holderPath : holderPaths) {
            if (isElementPresent(By.xpath(holderPath))) {
                WebElement userNameHolder = driver.findElement(By.xpath(holderPath));
                return userNameHolder.getText();
            }
        }
        return "";
    }

    public void signIn(AccountData data) {
        if (!isLoggedIn()) {
            login(data);
        }else if (!isLoggedIn(data)) {
            logout();
            login(data);
        }
    }

    private void login(AccountData data) {
        driver.findElement(By.id("usrlog2")).clear();
        driver.findElement(By.id("usrlog2")).sendKeys(data.getUserName());
        driver.findElement(By.id("usrpass2")).clear();
        driver.findElement(By.id("usrpass2")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector("input.submit")).click();
    }

    public void exitFromAccount() {
        if (isLoggedIn()) {
            logout();
        }
    }

    private void logout() {
        driver.findElement(By.cssSelector("#iAmQuit > a > span")).click();
    }

}
