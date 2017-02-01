import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maksim_Likharad on 2/1/2017.
 */
public class YandexTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Maksim_Likharad\\SeleniumTests\\workspace\\TestProject\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yandex.by/");
    }

    @Test
    public void doTest() {
        driver.findElement(By.name("login")).sendKeys("test.yauhen");
        driver.findElement(By.name("passwd")).sendKeys("qwerty123456");
        driver.findElement(By.cssSelector(".auth__button.domik2__auth-button")).click();
        String UserName = driver.findElement(By.cssSelector(".mail-User-Name")).getText();
        Assert.assertEquals(UserName, "test.yauhen@yandex.ru");

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
