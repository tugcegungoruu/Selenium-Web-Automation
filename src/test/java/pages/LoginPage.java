package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class LoginPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Logger logger;

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait, Logger logger){
        this.driver=driver;
        this.webDriverWait=webDriverWait;
        this.logger=logger;
    }
    public void Login(){
        driver.get("https://www.gittigidiyor.com/uye-girisi");

        By username = By.id("L-UserNameField");
        driver.findElement(username).sendKeys("tucegungoru@gmail.com");

        By password = By.id("L-PasswordField");
        driver.findElement(password).sendKeys("GG12345");

        By loginButton = By.id("gg-login-enter");
        driver.findElement(loginButton).click();
        //System.out.println("You have successfully logged in.");
        logger.info("The user is logged in.");
    }
}
