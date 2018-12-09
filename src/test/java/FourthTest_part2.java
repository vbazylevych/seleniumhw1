import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FourthTest_part2 extends BaseTest {

    @Test
    public void zonesForCanadaIsSorted() {

        goToMainPage();
        WebElement firstDuck = driver.findElement(By.cssSelector("#box-campaigns .product.column.shadow.hover-light"));
        String textOfDuck = firstDuck.findElement(By.className("name")).getAttribute("textContent");
        String regular_price = firstDuck.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaign_price = firstDuck.findElement(By.className("campaign-price")).getAttribute("textContent");


    }


}

