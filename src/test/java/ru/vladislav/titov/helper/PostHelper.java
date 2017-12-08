package ru.vladislav.titov.helper;

import org.openqa.selenium.By;
import ru.vladislav.titov.manager.TestManager;
import ru.vladislav.titov.model.PostFields;

public class PostHelper extends BaseHelper{

    public PostHelper(TestManager manager) {
        super(manager);
    }

    public void initPostCreation() {
        driver.findElement(By.cssSelector("#m_menu > li:nth-child(2) > a")).click();
        driver.findElement(By.id("postTitle")).click();
    }

    public void initPostModification() {
        driver.findElement(By.cssSelector("img[alt=\"Редактировать\"]")).click();
    }

    public void fillPostFields(PostFields fields) {
        driver.findElement(By.id("postTitle")).clear();
        driver.findElement(By.id("postTitle")).sendKeys(fields.getTitle());
        driver.findElement(By.id("message")).clear();
        driver.findElement(By.id("message")).sendKeys(fields.getMessage());
    }

    public void saveChanges() {
        driver.findElement(By.id("rewrite")).click();
    }

    public PostFields getPost() {
        PostFields post = new PostFields();
        post.setTitle(driver.findElement(By.cssSelector("div.singlePost > div.postTitle.header > h2")).getText());
        post.setMessage(driver.findElement(By.cssSelector("div.singlePost > div.postContent > div.postInner > div > div")).getText());
        return post;
    }
}
