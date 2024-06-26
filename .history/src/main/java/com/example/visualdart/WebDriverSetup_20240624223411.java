package com.example.visualdart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {

    public static WebDriver setupDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        // firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--no-sandbox");

        return new FirefoxDriver(firefoxOptions);
    }
}
