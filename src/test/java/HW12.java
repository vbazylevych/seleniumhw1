import org.junit.Test;
import org.openqa.selenium.By;

public class HW12 extends BaseTest {

    @Test
    public void test() {
        loginToAdmin();
        driver.findElement(By.cssSelector("#app- > a[href*='catalog']")).click();
        driver.findElement(By.cssSelector("a[href*='edit_product']")).click();
   //   driver.findElements(By.id("tab-general input"));
             //   .findElement(By.xpath("/td/label[1]")).click();
     //   driver.findElement(By.cssSelector("input {type[]"));
     //  driver.findElement(By.cssSelector(".input-wrapper']")).sendKeys("kotenka serenkii");

        driver.findElement(By.cssSelector("a[href*='tab-information']")).click();

    }
}
