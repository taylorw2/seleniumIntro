package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class switchingWindows {
    public static void main(String[] args){
        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebElement blinkyText = driver.findElement(By.cssSelector(".blinkingText"));
        blinkyText.click();
        Set<String> handles =  driver.getWindowHandles();
        Iterator<String> webids = handles.iterator();
        String parent = driver.getWindowHandle();
        String id = "";
        while(webids.hasNext()){
            id = webids.next();
            if(!parent.equalsIgnoreCase(id)){
                driver.switchTo().window(id);
                System.out.println(driver.switchTo().window(id).getTitle());
            }
        }
        String emailString= driver.findElement(By.cssSelector("p[class=\"im-para red\"]")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailString);
        driver.switchTo().window(parent);
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(emailString);
        driver.quit();
    }
}
