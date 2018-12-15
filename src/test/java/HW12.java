import net.bytebuddy.utility.RandomString;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;


public class HW12 extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        loginToAdmin();
        driver.findElement(By.cssSelector("#app- > a[href*='catalog']")).click();

        driver.findElement(By.cssSelector("a[href*='edit_product']")).click();
        driver.findElement(By.cssSelector("input[value='1']")).click();
        String unicNameOfProduct = "Kotenka" + RandomString.make(4);
        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys(unicNameOfProduct);
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("100500");
        driver.findElement(By.cssSelector("input[name='categories[]'][value='1']")).click();
        driver.findElement(By.cssSelector("input[name='categories[]'][value='2']")).click();
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='default_category_id']")));
        dropdown.selectByVisibleText("Rubber Ducks");
        driver.findElement(By.cssSelector("input[value='1-1']")).click();
        driver.findElement(By.cssSelector("input[name='quantity']")).clear();
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys(Keys.HOME + "100500");
        File fileKot = new File("kot.jpg");
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(fileKot.getAbsolutePath());
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).clear();
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("06.08.2018");
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("06.08.2108");

        driver.findElement(By.cssSelector("a[href*='tab-information']")).click();

        driver.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("Kotenka Serenkii");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Prosto kot");

        driver.findElement(By.cssSelector("a[href*='tab-prices']")).click();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("100");
        Select currency = new Select(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
        currency.selectByVisibleText("Euros");
        driver.findElement(By.cssSelector("button[name='save']")).click();
        String textContent = driver.findElement(By.cssSelector(".dataTable tr:nth-last-child(2)")).getAttribute("textContent");
        assertThat(textContent, Matchers.containsString(unicNameOfProduct));
    }
}
