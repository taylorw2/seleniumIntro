package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class StaticDropDowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("driver.webdriver.chrome", "/Users/wesleytaylor/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement currencyDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select curencySelections = new Select(currencyDropDown);
        List<WebElement> currencyOptions = curencySelections.getOptions();
        for(int i=0; i<currencyOptions.size(); i++ ){
            String expectedCurrency = currencyOptions.get(i).getText();
            curencySelections.selectByIndex(i);
            List<WebElement> selected = curencySelections.getAllSelectedOptions();
            Assert.assertEquals(selected.size(), 1);
            Assert.assertEquals(selected.get(0).getText(), expectedCurrency);
        }
        WebElement passengers = driver.findElement(By.id("divpaxinfo"));
        passengers.click();
        Thread.sleep(2000);
        WebElement passengerAdultAdd = driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
        WebElement passengerAdultSpan = driver.findElement(By.xpath("//span[@id='spanAudlt']"));
        WebElement passengerAdultDec = driver.findElement(By.xpath("//span[@id='hrefDecAdt']"));
        for(int i =1; i < 5; i++){
            passengerAdultAdd.click();
            Thread.sleep(100);
            Assert.assertEquals(Integer.valueOf(passengerAdultSpan.getText()), i+1);
            Assert.assertEquals(passengers.getText(), i + 1 + " Adult");
        }
        driver.close();
    }
}
