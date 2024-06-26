package com.example.visualdart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverSetupTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverSetup.setupDriver();
    }

    @Test
    public void testTitle() {
        driver.get("https://sendbird-uikit-react.netlify.app/url-builder");
        String title = driver.getTitle();
        assertEquals("Example Domain", title);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
