package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class seleniumIntro {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Invoke the browser
        //What browser will we use > Chrome , firefox, safari
        //chrome -> chromedriver -> methods()
        //selenium manager will download a browser exe for me
        //System.setProperty("webdriver.chrome.driver", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/");
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }
}
