package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        WebElement username =  driver.findElement(By.id("inputUsername"));
        username.sendKeys("wesley_taylor");
        WebElement password = driver.findElement(By.name("inputPassword"));
        password.sendKeys("wow");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();
        WebElement err = driver.findElement(By.className("error"));
        System.out.println(err.getText());
        WebElement forgotPasswordHelp = driver.findElement(By.linkText("Forgot your password?"));
        forgotPasswordHelp.click();
        Thread.sleep(1000);
        WebElement forgotPasswordName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        forgotPasswordName.sendKeys("wesTaylor");
        WebElement forgotPasswordEmail = driver.findElement(By.xpath("//input[@type='text'][2]"));
        forgotPasswordEmail.sendKeys("wesleyromantaylor1987@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//form/input[3]"));
        phone.sendKeys("206-343-3021");
        WebElement reset = driver.findElement(By.className("reset-pwd-btn"));
        reset.click();
        WebElement tempPassword = driver.findElement(By.className("infoMsg"));
        String pwText = tempPassword.getText();
        String[] pwTextArr = pwText.split(" ");
        WebElement goToLogin = driver.findElement(By.className("go-to-login-btn"));
        goToLogin.click();
        Thread.sleep(1000);
        username.sendKeys("wesTaylor");
        pwTextArr[4] = pwTextArr[4].replace("\'","");
        System.out.println(pwTextArr[4]);
        password.sendKeys(pwTextArr[4]);
        submitButton.click();
        driver.close();
    }
}
