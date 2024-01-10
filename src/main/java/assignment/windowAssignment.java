package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class windowAssignment {
    public static void main(String[] args){

        System.setProperty("webdriver.driver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/");
        WebElement content = driver.findElement(By.id("content"));
        List<WebElement> links = content.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(WebElement link : links){
            if(link.getText().equalsIgnoreCase("Multiple Windows")){
                Actions a = new Actions(driver);
                a.moveToElement(link).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).perform();
                break;
            }
        }
        String parentWindowId = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handleIter =  handles.iterator();
        while(handleIter.hasNext()){
            String handleId = handleIter.next();
            if(!handleId.equals(parentWindowId)){
                driver.switchTo().window(handleId);
                break;
            }
        }
        WebElement childContent = driver.findElement(By.id("content"));
        WebElement childContentLink = childContent.findElement(By.tagName("a"));
        Actions childAction = new Actions(driver);
        childAction.moveToElement(childContentLink).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).perform();
        String childWindowId =driver.getWindowHandle();
        handles = driver.getWindowHandles();
        handleIter =  handles.iterator();
        while(handleIter.hasNext()){
            String handleId = handleIter.next();
            if(!handleId.equals(parentWindowId) && !handleId.equals(childWindowId)){
                driver.switchTo().window(handleId);
                break;
            }
        }
        WebElement grandChildContent = driver.findElement(By.xpath("//div[@class=\"example\"]"));
        System.out.println(grandChildContent.getText());
        driver.switchTo().window(childWindowId);
        WebElement childContentText = driver.findElement(By.xpath("//div[@class=\"example\"]/h3"));
        System.out.println(childContentText.getText());
        driver.quit();

    }
}
