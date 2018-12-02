import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        driver.get("http://software-testing.ru");
    }
}
