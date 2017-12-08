package ru.vladislav.titov.helper;

import org.openqa.selenium.By;
import ru.vladislav.titov.manager.TestManager;

public class NavigationHelper extends BaseHelper {

    private String baseUrl;

    public NavigationHelper(TestManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }

    public void goToDiary() {
        driver.findElement(By.xpath("//*[@id=\"m_menu\"]/li[1]/a")).click();
    }
}
