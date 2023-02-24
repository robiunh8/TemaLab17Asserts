import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {


    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void LogIntoAccount() {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("dani.ban112@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("1ParolaPtTest1");
        driver.findElement(By.cssSelector("#send2")).click();


        WebElement welcomeText = driver.findElement(By.cssSelector(".welcome-msg strong"));
        String expectedText = "Hello, LIONEL MESSI!";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void quit() {
        driver.close();
    }
}

