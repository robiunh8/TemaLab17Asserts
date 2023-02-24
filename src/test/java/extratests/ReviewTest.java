package extratests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReviewTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");


    }

    @Test
    public void ReviewTest() {
        driver.findElement(By.cssSelector(".level0.nav-5.parent > .has-children.level0")).click();
        driver.findElement(By.cssSelector(".product-name [title]")).click();
        driver.findElement(By.cssSelector(".toggle-tabs .last span")).click();
        driver.findElement(By.cssSelector("div#customer-reviews  a")).click();
        driver.findElement(By.cssSelector("[for='Value_5'] .radio")).click();
        driver.findElement(By.cssSelector("[for='Quality_5'] .radio")).click();
        driver.findElement(By.cssSelector("[for='Price_5'] .radio")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Good shirt with good quality");
        driver.findElement(By.cssSelector("#summary_field")).sendKeys("Good shirt");
        driver.findElement(By.cssSelector("#summary_field")).sendKeys("Good shirt");
        driver.findElement(By.cssSelector("#nickname_field")).sendKeys("Ham");
        driver.findElement(By.cssSelector("#review-form span:nth-of-type(1) span")).click();


        WebElement reviewaddedText = driver.findElement(By.cssSelector(".messages  ul  span"));
        String expectedText = "Your review has been accepted for moderation.";
        String actualText = reviewaddedText.getText();
        Assert.assertEquals(expectedText, actualText);

    }


    @After
    public void quit() {
        driver.close();
    }
}
