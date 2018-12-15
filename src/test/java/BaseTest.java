import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.quit();
    }

    protected void loginToAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void loginAsNewUser() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector(".content a[href$='create_account']")).click();
        driver.findElement(By.name("firstname")).sendKeys(RandomString.make(5));
        driver.findElement(By.name("lastname")).sendKeys(RandomString.make(5));
        driver.findElement(By.name("address1")).sendKeys(RandomString.make(5));
        driver.findElement(By.name("postcode")).sendKeys("1111");
        driver.findElement(By.name("city")).sendKeys("City");
     //   driver.findElement(By.className("select2-selection__arrow")).click();
     //   driver.findElement(By.className("select2-search__field")).sendKeys("United States"+ Keys.ENTER);
        driver.findElement(By.className("select2-selection select2-selection--single")).click();
       // driver.findElement(By.cssSelector("[class^='product']")).click();
        String login = "kot" + RandomString.make(5) + "@gmail.com";
        String pass = "12345678";
        driver.findElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("login")).click();
        HashMap<String, String> userCredential = new HashMap<>();
        userCredential.put("login", login);
        userCredential.put("pass", pass);

    }

    protected void reLoginAsUser(HashMap<String, String > userCredential) {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.name("email")).sendKeys(userCredential.get("login"));
        driver.findElement(By.name("password")).sendKeys(userCredential.get("pass"));
        driver.findElement(By.name("login")).click();
    }

    protected void goToMainPage() {
        driver.get("http://localhost/litecart/");
    }
}
