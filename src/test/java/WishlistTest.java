import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void WISHLISTsale() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("1ParolaPtTest1");
        driver.findElement(By.cssSelector("#send2")).click();

        driver.findElement(By.cssSelector(".level0.nav-5.parent > .has-children.level0")).click();
        driver.findElement(By.cssSelector("h2 [title]")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();


        WebElement addedtowishlist = driver.findElement(By.cssSelector(".success-msg span"));
        WebElement succesAdd = driver.findElement(By.cssSelector(".success-msg span"));
        String expectedText = succesAdd.getText();
        String actualText = addedtowishlist.getText();

        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void quit() {
        driver.close();
    }
}
