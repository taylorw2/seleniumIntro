package loginPagePArctice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    public static void main(String[] args) {
        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        List<WebElement> usernameAndPassword = driver.findElements(By.cssSelector("i"));
        String username = usernameAndPassword.get(0).getText();
        String password = usernameAndPassword.get(1).getText();

        System.out.println(username + " : "+ password);

        WebElement elUsername = driver.findElement(By.id("username"));
        elUsername.sendKeys(username);
        WebElement elPassword = driver.findElement(By.id("password"));
        elPassword.sendKeys(password);

        WebElement elUserRadio = driver.findElement(By.xpath("//input[@value=\"user\"]"));
        elUserRadio.click();

        WebElement elOkayButtn = driver.findElement(By.id("okayBtn"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(elOkayButtn));
        elOkayButtn.click();


        WebElement userTypedropDown = driver.findElement(By.cssSelector("select"));
        userTypedropDown.click();
        Select userTypeSelections = new Select(userTypedropDown);
        List<WebElement> userTypeOptions =  userTypeSelections.getOptions();
        for(WebElement option : userTypeOptions){
            if(option.getText().equalsIgnoreCase("Consultant")){
                option.click();
            }
        }
        WebElement signInBtn = driver.findElement(By.id("signInBtn"));
        signInBtn.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//app-card/div/div[@class=\"card-footer\"]/button"))));
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//app-card/div/div[@class=\"card-footer\"]/button"));
        for(WebElement button : addToCartButtons){
            button.click();
        }

        WebElement checkOut = driver.findElement(By.xpath("//a[@class=\"nav-link\"]"));
        checkOut.click();



    }
}
