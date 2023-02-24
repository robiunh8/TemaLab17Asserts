package extratests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomepageWelcomeTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");


    }

    @Test
    public void HomepageWelcomeTxt() {
        WebElement hpagewelcometxt = driver.findElement(By.cssSelector("p.welcome-msg"));
        String expectedText = "WELCOME";
        String actualText = hpagewelcometxt.getText();
        Assert.assertEquals(expectedText, actualText);

    }


    @After
    public void quit() {
        driver.close();
    }
}
