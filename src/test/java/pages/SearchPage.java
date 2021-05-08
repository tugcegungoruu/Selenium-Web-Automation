package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class SearchPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Logger logger;

    public SearchPage(WebDriver driver, WebDriverWait webDriverWait, Logger logger) {
        this.driver=driver;
        this.webDriverWait=webDriverWait;
        this.logger=logger;
    }
    public void SearchItem(String key){
        driver.get("https://www.gittigidiyor.com");
        By searchArea = By.xpath("//input[@type='text']");
        driver.findElement(searchArea).sendKeys(key);

        By searchButton = By.cssSelector(".qjixn8-0.sc-1bydi5r-0.hKfdXF");
        driver.findElement(searchButton).click();
        //System.out.println("You searched for the word " + key);
        logger.info("You searched for the word " + key);
    }
}