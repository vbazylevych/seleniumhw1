import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HW14 extends BaseTest {
    @Test
    public void test() {
        loginToAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("a[class='button']")).click();
        int size = driver.findElements(By.cssSelector("a[target='_blank']")).size();
        for (int i = 0; i < size; i++) {
            List<WebElement> elements = driver.findElements(By.cssSelector("a[target='_blank']"));
            String oldWindow = driver.getWindowHandle();
            elements.get(i).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windowHandles = driver.getWindowHandles();
            windowHandles.remove(oldWindow);
            String newWindow = windowHandles.iterator().next();
            driver.switchTo().window(newWindow);
            assertFalse(oldWindow.equals(driver.getWindowHandle()));
            driver.close();
            driver.switchTo().window(oldWindow);
            assertTrue(oldWindow.equals(driver.getWindowHandle()));
        }
    }
}

