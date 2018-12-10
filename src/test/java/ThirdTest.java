import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ThirdTest extends BaseTest {
    @Test
    public void test() {
        loginToAdmin();
        int menuSize = driver.findElements(By.cssSelector("#box-apps-menu > li")).size();

        for (int i = 0; i < menuSize; i++) {
            List<WebElement> elements2 = driver.findElements(By.cssSelector("#box-apps-menu > li"));
            elements2.get(i).click();

            assertTrue(driver.findElements(By.cssSelector("h1")) != null);
            System.out.println(driver.findElements(By.cssSelector("h1")).get(0).getText());

            int subMebuSize = driver.findElements(By.cssSelector("#box-apps-menu li[class='selected'] ul > li")).size();
            if (subMebuSize > 0) {
                for (int j = 0; j < subMebuSize; j++) {
                    List<WebElement> subElements12 = driver.findElements(By.cssSelector("#box-apps-menu li[class='selected'] ul > li"));
                    subElements12.get(j).click();

                    assertTrue(driver.findElements(By.cssSelector("h1")) != null);
                    System.out.println(driver.findElements(By.cssSelector("h1")).get(0).getText());
                }
            }
        }
    }
}
