package com.example.visualdart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {

    public static WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    public static void main(String[] args) {
        WebDriver driver = setupDriver();

        try {
            // Your test code here
            driver.get("https://www.example.com");
            System.out.println("Page title is: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}
