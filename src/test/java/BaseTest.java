import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new  WebDriverWait(driver, 5);
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

    public HashMap<String, String> loginAsNewUser() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector(".content a[href$='create_account']")).click();
        driver.findElement(By.name("firstname")).sendKeys(RandomString.make(5));
        driver.findElement(By.name("lastname")).sendKeys(RandomString.make(5));
        driver.findElement(By.name("address1")).sendKeys(RandomString.make(5));
        driver.findElement(By.name("postcode")).sendKeys("11111");
        driver.findElement(By.name("city")).sendKeys("City");
        Select selectCountryCode = new Select(driver.findElement(By.cssSelector("select[name='country_code']")));
        selectCountryCode.selectByVisibleText("United States");
        String login = "kot" + RandomString.make(5) + "@gmail.com";
        String pass = "12345678";
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(login);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("+380638494949");
        driver.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[name='create_account']")).click();

        HashMap<String, String> userCredential = new HashMap<>();
        userCredential.put("login", login);
        userCredential.put("pass", pass);
        return userCredential;
    }

    protected void reLoginAsUser(HashMap<String, String > userCredential) {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.name("email")).sendKeys(userCredential.get("login"));
        driver.findElement(By.name("password")).sendKeys(userCredential.get("pass"));
        driver.findElement(By.name("login")).click();
    }
   protected void logOut(){
        driver.findElement(By.cssSelector(".list-vertical a[href$='logout']")).click();
   }

    protected void goToMainPage() {
        driver.get("http://localhost/litecart/");
    }
}
