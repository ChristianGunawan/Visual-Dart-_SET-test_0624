package com.example.visualdart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestUserCreation {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverSetup.setupDriver();
    }

    @Test
    public void testCreateUser1() {
        driver.get(config.BASE_URL);

        WebElement appIdInput = driver.findElement(By.name("appId"));
        WebElement userIdInput = driver.findElement(By.name("userId"));
        WebElement nicknameInput = driver.findElement(By.name("nickname"));

        WebElement copyButton = driver.findElement(By.className("sticky-bottom-button"));

        appIdInput.sendKeys("testuser1");
        userIdInput.sendKeys("testuser1");
        nicknameInput.sendKeys("Test User 1");
        copyButton.click();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
