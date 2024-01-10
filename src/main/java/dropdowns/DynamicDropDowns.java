package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicDropDowns {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement country = driver.findElement(By.id("autosuggest"));
        country.sendKeys("ind");
        Thread.sleep(1000);
        List<WebElement> countryOptios = driver.findElements(By.xpath("//ul[@id=\"ui-id-1\"] //a[contains(@id,\"ui-id\")]"));
        for(WebElement option : countryOptios){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }

        WebElement fromCityDropDown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        fromCityDropDown.click();
        Thread.sleep(1000);

        WebElement bengaluru = driver.findElement(By.xpath("//a[@value='BLR']"));
        bengaluru.click();

        WebElement toCityDropDown = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        toCityDropDown.click();

        WebElement chennai = driver.findElement(By.xpath("(//a[@value=\"MAA\"])[1]"));
        chennai.click();

        WebElement departDate = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        departDate.click();
        WebElement leftCalYear = driver.findElement(By.className("ui-datepicker-year"));
        Thread.sleep(2000);
        WebElement calendarAdvance = driver.findElement(By.cssSelector("a[class=\"ui-datepicker-next ui-corner-all\"]"));

    }
}
