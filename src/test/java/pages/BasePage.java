package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Logger logger;

    public BasePage(WebDriver driver, WebDriverWait webDriverWait, Logger logger) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        this.logger = logger;
    }

    public void HomePageTitle(){
        logger.info("You are on homepage!");
        driver.get("https://www.gittigidiyor.com");
        //System.out.println("You are on homepage!");
    }
}
