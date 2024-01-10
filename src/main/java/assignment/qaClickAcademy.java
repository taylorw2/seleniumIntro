package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class qaClickAcademy {
    public static void main(String[] args){

        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        System.out.println(driver.findElements(By.cssSelector("a")).size());
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks= footer.findElements(By.cssSelector("a"));
        System.out.println(footerLinks.size());
        WebElement linksColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> links = linksColumn.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(int i =1 ; i < links.size(); i++){
            Actions a = new Actions(driver);
            WebElement link = links.get(i);
            if(System.getProperty("os.name").toLowerCase().contains("mac")) {
                link.sendKeys(Keys.COMMAND, Keys.RETURN);
            } else{
                link.sendKeys(Keys.CONTROL, Keys.RETURN);
            }
            System.out.println(link.getText());
            //a.keyDown(Keys.COMMAND).moveToElement(link).click().keyUp(Keys.COMMAND).build().perform();

        }
    }
}
