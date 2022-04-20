package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessFullyWithValidCredentials() {
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input")).sendKeys("markie123@gmail.com");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        String actualMsg = driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText();
        String expectedMsg = "Accounts Overview";
        Assert.assertEquals("Display Message", expectedMsg, actualMsg);

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input")).sendKeys("markie123@gmail.com");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        String actualMsg=driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expectedMsg="Please enter a username and password.";
        Assert.assertEquals("Error Message",expectedMsg,actualMsg);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input")).sendKeys("markie123@gmail.com");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        driver.findElement(By.xpath("//div[@id='leftPanel']/ul/li[8]/a")).click();
        String actualMsg = driver.findElement(By.xpath("//div[@id='leftPanel']/h2")).getText();
        String expectedMsg = "Customer Login";
        Assert.assertEquals("Customer Login Message", expectedMsg, actualMsg);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
