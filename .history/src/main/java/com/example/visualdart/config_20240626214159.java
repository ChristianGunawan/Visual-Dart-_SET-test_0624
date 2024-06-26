package com.example.visualdart;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class config {
    public static final String BASE_URL = "https://sendbird-uikit-react.netlify.app";
    private WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

}