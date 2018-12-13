import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;


public class FourthTest_part2 extends BaseTest {

    @Test
    public void duckVsDuck() {

        goToMainPage();
        WebElement firstDuck = driver.findElement(By.cssSelector("#box-campaigns [class^='product']"));
        String textOfDuckMainPage = firstDuck.findElement(By.className("name")).getAttribute("textContent");
        String regularPriceMainPage = firstDuck.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceMainPage = firstDuck.findElement(By.className("campaign-price")).getAttribute("textContent");
        String textDecorationMainPageRegularPrice = firstDuck.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        String colorMainPageRegularPrice = firstDuck.findElement(By.cssSelector(".regular-price")).getCssValue("color").replaceAll(" ","");
        String colorMainPageCompainPrice = firstDuck.findElement(By.cssSelector(".campaign-price")).getCssValue("color").replaceAll(" ","");
        String sizeFountMainPageRegularPrice = firstDuck.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String sizeFountMainPageCompainPrice = firstDuck.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");

        firstDuck.click();
        String textOfDuckPage = driver.findElement(By.cssSelector("h1[class='title']")).getAttribute("textContent");
        String regularPriceDuckPage = driver.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceDuckPage = driver.findElement(By.className("campaign-price")).getAttribute("textContent");
        String textDecorationDuckPageRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        String colorDuckPageRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color").replaceAll(" ","");
        String colorDuckPageCompainPrice = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color").replaceAll(" ","");
        String sizeFountDuckPageRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String sizeFountDuckPageCampaignPrice = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        String boldFountMainPageCampaignPrice = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
        System.out.println();

        assertThat(textOfDuckMainPage.toLowerCase(), equalTo(textOfDuckPage.toLowerCase()));
        assertThat(regularPriceMainPage, equalTo(regularPriceDuckPage));
        assertThat(campaignPriceMainPage, equalTo(campaignPriceDuckPage));
        assertThat(textDecorationMainPageRegularPrice, containsString("line-through"));
        assertThat(textDecorationDuckPageRegularPrice, containsString("line-through"));
        String[] greyColorsDuckPage = colorDuckPageRegularPrice.substring(5, colorDuckPageRegularPrice.length() - 1)
                .split(",");
        assertThat(greyColorsDuckPage[0], equalTo(greyColorsDuckPage[1]));
        assertThat(greyColorsDuckPage[0], equalTo(greyColorsDuckPage[2]));

        String[] greyColorsDuckMainPage = colorMainPageRegularPrice.substring(5, colorDuckPageRegularPrice.length() - 1)
                .split(",");
        assertThat(greyColorsDuckMainPage[0], equalTo(greyColorsDuckMainPage[1]));
        assertThat(greyColorsDuckMainPage[0], equalTo(greyColorsDuckMainPage[2]));

       assertThat(boldFountMainPageCampaignPrice, containsString("700"));

        String[] redColorsMainPage = colorDuckPageCompainPrice.substring(5, colorDuckPageCompainPrice.length() - 1)
                .split(",");
        assertThat(redColorsMainPage[0], not( equalTo(redColorsMainPage[1])));
        assertThat(redColorsMainPage[1], equalTo("0"));
        assertThat(redColorsMainPage[2], equalTo("0"));

        double doubleSizeFountDuckPageCampaignPrice = Double.parseDouble(sizeFountDuckPageCampaignPrice.substring(0, sizeFountDuckPageCampaignPrice.length() - 2));
        double doubleSizeFountDuckPageRegularPrice = Double.parseDouble(sizeFountDuckPageRegularPrice.substring(0, sizeFountDuckPageRegularPrice.length() - 2));
        assertTrue(doubleSizeFountDuckPageCampaignPrice > doubleSizeFountDuckPageRegularPrice);

        double doubleSizeFountMainPageCampaignPrice = Double.parseDouble(sizeFountMainPageCompainPrice.substring(0, sizeFountMainPageCompainPrice.length() - 2));
        double doubleSizeFountMainPageRegularPrice = Double.parseDouble(sizeFountMainPageRegularPrice.substring(0, sizeFountMainPageCompainPrice.length() - 2));
        assertTrue(doubleSizeFountMainPageCampaignPrice > doubleSizeFountMainPageRegularPrice);

    }


}

