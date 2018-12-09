import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ThirdTest extends BaseTest {
    @Test
    public void h1IsPresent(){
        login();
        checkH1(By.cssSelector("#app- > a[href*='appearance']"));
        checkH1(By.id("doc-template"));
        checkH1(By.id("doc-logotype"));
        checkH1(By.cssSelector("#app- > a[href*='catalog']"));
        checkH1(By.id("doc-catalog"));
        checkH1(By.id("doc-product_groups"));
        checkH1(By.id("doc-option_groups"));
        checkH1(By.id("doc-manufacturers"));
        checkH1(By.id("doc-suppliers"));
        checkH1(By.id("doc-delivery_statuses"));
        checkH1(By.id("doc-sold_out_statuses"));
        checkH1(By.id("doc-quantity_units"));
        checkH1(By.id("doc-csv"));
        checkH1(By.cssSelector("#app- > a[href*='countries']"));
        checkH1(By.cssSelector("#app- > a[href*='currencies']"));
        checkH1(By.cssSelector("#app- > a[href*='customers']"));
        checkH1(By.id("doc-customers"));
        checkH1(By.id("doc-csv"));
        checkH1(By.id("doc-newsletter"));
        checkH1(By.cssSelector("#app- > a[href*='geo_zones']"));
        checkH1(By.cssSelector("#app- > a[href*='languages']"));
        checkH1(By.id("doc-languages"));
        checkH1(By.id("doc-storage_encoding"));
        checkH1(By.cssSelector("#app- > a[href*='modules']"));
        checkH1(By.id("doc-jobs"));
        checkH1(By.id("doc-customer"));
        checkH1(By.id("doc-shipping"));
        checkH1(By.id("doc-payment"));
        checkH1(By.id("doc-order_total"));
        checkH1(By.id("doc-order_success"));
        checkH1(By.id("doc-order_action"));
        checkH1(By.cssSelector("#app- > a[href*='orders']"));
        checkH1(By.id("doc-orders"));
        checkH1(By.id("doc-order_statuses"));
        checkH1(By.cssSelector("#app- > a[href*='pages']"));
        checkH1(By.cssSelector("#app- > a[href*='reports']"));
        checkH1(By.id("doc-monthly_sales"));
        checkH1(By.id("doc-most_sold_products"));
        checkH1(By.id("doc-most_shopping_customers"));
        checkH1(By.cssSelector("#app- > a[href*='settings']"));
        checkH1(By.cssSelector("#app- > a[href*='slides']"));
        checkH1(By.cssSelector("#app- > a[href*='tax']"));
        checkH1(By.id("doc-tax_classes"));
        checkH1(By.id("doc-tax_rates"));
        checkH1(By.cssSelector("#app- > a[href*='translations']"));
        checkH1(By.id("doc-search"));
        checkH1(By.id("doc-scan"));
        checkH1(By.id("doc-csv"));
        checkH1(By.cssSelector("#app- > a[href*='users']"));
        checkH1(By.cssSelector("#app- > a[href*='vqmods']"));
        checkH1(By.id("doc-vqmods"));










    }

    private void checkH1(By locator) {
        driver.findElement(locator).click();
        assertTrue(driver.findElements(By.cssSelector("h1")) !=null);
        System.out.println(driver.findElements(By.cssSelector("h1")).get(0).getText());
    }
}
