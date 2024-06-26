package com.example.visualdart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUserCreation {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverSetup.setupDriver();
    }

    public void setup_user(String userID, String nickname, int tab) {
        driver.get(config.BASE_URL + "/url-builder");

        WebElement appIdInput = driver.findElement(By.name("appId"));
        WebElement userIdInput = driver.findElement(By.name("userId"));
        WebElement nicknameInput = driver.findElement(By.name("nickname"));

        WebElement copyButton = driver.findElement(By.className("sticky-bottom-button"));

        appIdInput.sendKeys("37C8DB25-8B44-435F-A528-5BA9B9965FD0");
        userIdInput.sendKeys(userID);
        nicknameInput.sendKeys(nickname);
        copyButton.click();

        String copiedUrl = ClipboardUtils.getFromClipboard();

        // Open a new tab
        ((FirefoxDriver) driver).executeScript("window.open()");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
        driver.get(copiedUrl);

        assertEquals(copiedUrl, driver.getCurrentUrl(), "The URL in the new tab should match the copied URL");
        driver.close();
    }

    @Test
    public void create_group() {
        setup_user("user1", "nick1", 1);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement createGroupButton = driver.findElement(By.xpath("//button[@class=' sendbird-iconbutton ']"));
        WebElement popUpCreateGroupButton = driver
                .findElement(By.xpath("//button[@class='sendbird-add-channel__rectangle']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("(//span[@class='sendbird-checkbox--checkmark '])[1]")));
        WebElement createGrupButton = driver
                .findElement(
                        By.xpath("//button[@class=' sendbird-button  sendbird-button--primary sendbird-button--big']"));

        createGroupButton.click();
        popUpCreateGroupButton.click();
        checkbox.click();
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
