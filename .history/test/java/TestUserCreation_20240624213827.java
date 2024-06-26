import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUserCreation {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void createUser1() {
        driver.get("PASTE_YOUR_URL_HERE");
        WebElement userIdInput = driver.findElement(By.name("userId"));
        WebElement nicknameInput = driver.findElement(By.name("nickname"));
        WebElement runButton = driver.findElement(By.id("run"));

        userIdInput.sendKeys("testuser1");
        nicknameInput.sendKeys("Test User 1");
        runButton.click();

        // Add assertions to verify user creation
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
