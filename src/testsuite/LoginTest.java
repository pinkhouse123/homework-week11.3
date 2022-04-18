package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter username and password
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // Click login button
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]")).click();
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        // Enter username and password
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // Click login button
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//div[@id='flash']")).click();

    }

    @Test
    public void verifyThePasswordErrorMessage(){
        // Enter username and password
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        // Click login button
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//div[@id='flash']")).click();

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}




