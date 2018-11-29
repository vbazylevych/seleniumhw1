import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

    WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void close() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        driver.get("http://software-testing.ru");
    }
}