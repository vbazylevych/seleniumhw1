import org.junit.Test;
import org.openqa.selenium.By;

public class FixComments extends BaseTest {
    @Test
    public void test() {
        loginToAdmin();
        driver.findElements(By.cssSelector("#box-apps-menu li"))
                .forEach(e -> e.click());

    }
}
