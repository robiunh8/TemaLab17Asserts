package extratests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {

    private WebDriver driver;

    @Before
    public void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void AddtoCartTest() {
        driver.findElement(By.cssSelector(".level0.nav-5.parent > .has-children.level0")).click();
        driver.findElement(By.cssSelector(".product-name [title]")).click();
        driver.findElement(By.cssSelector("[alt='Blue']")).click();
        driver.findElement(By.cssSelector("a[name='xs'] > .swatch-label")).click();
        driver.findElement(By.cssSelector(".product-shop button[title='Add to Cart']")).click();

        WebElement addedToCartText = driver.findElement(By.cssSelector(".success-msg span"));
        String expectedText = "Slim fit Dobby Oxford Shirt was added to your shopping cart.";
        String actualtext= addedToCartText.getText();
        Assert.assertEquals(actualtext,expectedText);


    }

    @After
    public void quit() {
        driver.close();
    }
}
