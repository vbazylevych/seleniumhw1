import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class FourthTest_part2 extends BaseTest {

    @Test
    public void zonesForCanadaIsSorted() {

        goToMainPage();
        WebElement firstDuck = driver.findElement(By.cssSelector("#box-campaigns .product.column.shadow.hover-light"));
        String textOfDuckMainPage = firstDuck.findElement(By.className("name")).getAttribute("textContent");
        String regularPriceMainPage = firstDuck.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceMainPage = firstDuck.findElement(By.className("campaign-price")).getAttribute("textContent");
        String textDecorationMainPageCompainPrice = firstDuck.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        String colorMainPageRegularPrice = firstDuck.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String colorMainPageCompainPrice = firstDuck.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String sizeFountMainPageRegularPrice = firstDuck.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String sizeFountMainPageCompainPrice = firstDuck.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");

        firstDuck.click();
        String textOfDuckPage = driver.findElement(By.cssSelector("h1[class='title']")).getAttribute("textContent");
        String regularPriceDuckPage = driver.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceDuckPage = driver.findElement(By.className("campaign-price")).getAttribute("textContent");
        String textDecorationDuckPageCompainPrice = driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        String colorDuckPageRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String colorDuckPageCompainPrice = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String sizeFountDuckPageRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String sizeFountDuckPageCompainPrice = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        System.out.println();

       assertThat(textOfDuckMainPage.toLowerCase(), equalTo(textOfDuckPage.toLowerCase()));

    }


}

