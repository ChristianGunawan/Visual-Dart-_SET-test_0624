package com.example.visualdart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserCreation {

    private static WebDriver driver;
    private static final String BROWSER = "chrome"; // You can change this to "firefox" or "edge"

    @BeforeAll
    public static void setup() {
        driver = WebDriverSetup.setupDriver(BROWSER);
    }

    @Test
    public void testCreateUser1() {
        driver.get(config.BASE_URL);

        WebElement userIdInput = driver.findElement(By.name("userId"));
        WebElement nicknameInput = driver.findElement(By.name("nickname"));
        WebElement runButton = driver.findElement(By.id("run"));

        userIdInput.sendKeys("testuser1");
        nicknameInput.sendKeys("Test User 1");
        runButton.click();

        // Add an assertion to verify user creation
        // For example, checking for a specific element that appears after user creation
        assertTrue(driver.getPageSource().contains("Expected text or element after user creation"));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
