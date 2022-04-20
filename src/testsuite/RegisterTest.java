package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
        String actualMsg=driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText();
        String expectedMsg="Signing up is easy!";
        Assert.assertEquals("Signin Message",expectedMsg,actualMsg);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("lee");
        driver.findElement(By.id("customer.lastName")).sendKeys("lolo");
        driver.findElement(By.id("customer.address.street")).sendKeys("420, chor gali");
        driver.findElement(By.id("customer.address.city")).sendKeys("ulasnagar");
        driver.findElement(By.id("customer.address.state")).sendKeys("ohio");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("357006");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("074204204200");
        driver.findElement(By.id("customer.ssn")).sendKeys("34567");
        WebElement emailField=driver.findElement(By.id("customer.username"));
        emailField.click();
        Random randomGenerator = new Random();// random generator class
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username"+ randomInt +"@gmail.com");// creating random email generator
        driver.findElement(By.id("customer.password")).sendKeys("123456");
        driver.findElement(By.id("repeatedPassword")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
