package locators;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class locators2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        WebElement username =  driver.findElement(By.id("inputUsername"));
        username.sendKeys("wesley_taylor");
        WebElement password = driver.findElement(By.name("inputPassword"));
        password.sendKeys("rahulshettyacademy");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement successMessage = driver.findElement(By.tagName("p"));
        String message = successMessage.getText();
        Assert.assertEquals(message, "You are successfully logged in.");

    }
}
