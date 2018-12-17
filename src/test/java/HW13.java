import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW13 extends BaseTest {
    @Test
    public void test() throws InterruptedException {
        goToMainPage();
        for (int i = 0; i < 3; i++) {
            int productsInCart = getQuantityInCart();
            driver.findElement(By.cssSelector("#box-most-popular li")).findElement(By.cssSelector("a[class='link']")).click();
            try {
                Select size = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
                size.selectByIndex(1);
            } catch (NoSuchElementException e) {
            }
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("cart"))
                    .findElement(By.cssSelector("span[class='quantity']")), String.valueOf(productsInCart + 1)));
            driver.navigate().back();
        }

        driver.findElement(By.id("cart-wrapper")).findElement(By.cssSelector("a[class='link']")).click();
        List<WebElement> differentPosition = driver.findElement(By.id("order_confirmation-wrapper")).findElements(By.cssSelector("td[class='item']"));

        for (int i = differentPosition.size(); i > 0; i--) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[name='remove_cart_item']"))));
            driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
            driver.findElement(By.id("order_confirmation-wrapper"));
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("td[class='item']"), i-1));
        }
    }

    private int getQuantityInCart() {
        return Integer.parseInt(driver.findElement(By.id("cart"))
                .findElement(By.cssSelector("span[class='quantity']")).getAttribute("textContent"));
    }
}
