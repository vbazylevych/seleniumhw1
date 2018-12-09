import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ThirdTestSecondPart extends BaseTest {
    @Test
    public void h1IsPresent() {
        driver.get("http://localhost/litecart/");
        List<WebElement> ducks = driver.findElements(By.className("image-wrapper"));
        ducks.forEach(duck -> checkSticer(duck));
    }

    private void checkSticer(WebElement duck) {
        assertTrue(duck.findElements(By.cssSelector("[class*='sticker']")) != null);

        //for me in order to ckeck
        // System.out.println(duck.findElements(By.cssSelector("[class*='sticker']")).get(0).getText());
    }
}
