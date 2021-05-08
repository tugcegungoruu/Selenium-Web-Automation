import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SecondPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    final static Logger logger = Logger.getLogger(String.valueOf(BaseTest.class));

    @Before
    public void TestAutomation() throws IOException {
        logger.info("Testing process started.");
        System.setProperty("webdriver.chrome.driver", "C:/Users/tuceg/Selenium/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test
    public void TestCases() throws InterruptedException {

        logger.info("Homepage opened.");
        BasePage basePage = new BasePage(driver, webDriverWait, logger);
        basePage.HomePageTitle();
        LoginPage loginPage = new LoginPage(driver, webDriverWait, logger);
        loginPage.Login();

        SearchPage searchPage = new SearchPage(driver, webDriverWait, logger);
        searchPage.SearchItem("Bilgisayar");

        SecondPage secondPage = new SecondPage(driver, webDriverWait, logger);
        secondPage.getSecondPage();
        secondPage.addToBasket();
        secondPage.addToProduct();
        secondPage.deleteProduct();
        secondPage.controlBasket();
    }

    @After
    public void EndTest(){
        driver.quit();
        logger.info("The test is complete.");
    }
}
