package com.example.visualdart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUserCreation {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverSetup.setupDriver();
    }

    @Test
    public void login_and_setup() {
        driver.get(config.BASE_URL + "/url-builder");

        WebElement appIdInput = driver.findElement(By.name("appId"));
        WebElement userIdInput = driver.findElement(By.name("userId"));
        WebElement nicknameInput = driver.findElement(By.name("nickname"));

        WebElement copyButton = driver.findElement(By.className("sticky-bottom-button"));

        appIdInput.sendKeys("37C8DB25-8B44-435F-A528-5BA9B9965FD0");
        userIdInput.sendKeys("User1");
        nicknameInput.sendKeys("User1");

        copyButton.click();

        // Open a new tab
        ((FirefoxDriver) driver).executeScript("window.open()");
    }

    @Test
    public void send_plain_text() {
        System.out.println("PASS");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
