package com.example.visualdart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserCreation {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverSetup.setupDriver();
    }

    @Test
    public void testCreateUser1() {
        driver.get(config.BASE_URL);
        driver.wait(3000);

        WebElement appIdInput = driver.findElement(By.name("appId"));
        WebElement userIdInput = driver.findElement(By.name("userId"));
        WebElement nicknameInput = driver.findElement(By.name("nickname"));
        WebElement copyButton = driver.findElement(By.className("sticky-bottom-button"));

        appIdInput.sendKeys("37C8DB25-8B44-435F-A528-5BA9B9965FD0");
        userIdInput
        copyButton.click();

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
