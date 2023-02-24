import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void RegisterAccount() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("LIONEL");
        driver.findElement(By.id("lastname")).sendKeys("MESSI");
        driver.findElement(By.id("email_address")).sendKeys("fanaso2408@aosod.com");
        driver.findElement(By.id("password")).sendKeys("parolaTestNrNush$a$$444");
        driver.findElement(By.id("confirmation")).sendKeys("parolaTestNrNush$a$$444");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

        WebElement registerMsg = driver.findElement(By.cssSelector(".error-msg span"));
        WebElement registererrorMsg = driver.findElement(By.cssSelector(".error-msg span"));

        String actualText = registerMsg.getText();
        String expectedText = registererrorMsg.getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void quit() {
        driver.close();
    }


}

