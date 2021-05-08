package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class SecondPage{
    WebDriver driver;
    WebDriverWait webDriverWait;
    Logger logger;
    JavascriptExecutor jse;

    public SecondPage(WebDriver driver, WebDriverWait webDriverWait, Logger logger){
        this.driver=driver;
        this.webDriverWait=webDriverWait;
        this.logger=logger;
        this.jse = (JavascriptExecutor) driver;
    }
    public void getSecondPage(){
        jse.executeScript("window.scrollBy(0,9000)");
        By secondPageButton = By.cssSelector("ul[class='clearfix'] [href='/arama/?k=Bilgisayar&sf=2']");
        driver.findElement(secondPageButton).click();

        String secondPageUrl = "https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2";
        String isSecondPage = driver.getCurrentUrl();

        if(isSecondPage.equals(secondPageUrl)){
            //System.out.println("You are on the second page.");
            logger.info("You are on the second page.");
        }
        else{
            //System.out.println("You are not on the second page.");
            logger.info("You are not on the second page.");
        }
        logger.info("Checked whether it is on the second page.");
    }

    public void addToBasket() throws InterruptedException {
        By productDetailButton = By.cssSelector("[class='catalog-view clearfix products-container']>:nth-child(1)");
        driver.findElement(productDetailButton).click();
        jse.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        By addToBasketButton = By.cssSelector("[id='purchaseSoldInfoActionButtons'] [id='add-to-basket']");
        driver.findElement(addToBasketButton).click();

        By priceValue = By.xpath("//*[@id='sp-price-lowPrice']");
        String priceText = driver.findElement(priceValue).getText();

        Thread.sleep(2000);

        driver.get("https://www.gittigidiyor.com/sepetim");
        By price2 = By.cssSelector("div[class='total-price']");
        String price = driver.findElement(price2).getText();

        Thread.sleep(2000);

        //System.out.println(priceText + price);

        if (priceText.equals(price)) {
            //System.out.println("Product prices are equal.");
            logger.info("Product prices are equal.");
            logger.info("Price of the item in the basket: " + priceText);
            logger.info("Price of the item: " + price);

        }
        else {
            //System.out.println("Product prices are not equal.");
            logger.info("Product prices are not equal.");
        }
        logger.info("Product prices have been compared.");
    }

    public void addToProduct() throws InterruptedException {
        By addButton = By.cssSelector("option[value='2']");
        driver.findElement(addButton).click();
        Thread.sleep(2000);

        By totalAmount = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-child(1)");
        String amount = driver.findElement(totalAmount).getText();
        String amountText= "Ürün Toplamı (2 Adet)";
        //System.out.println(amount + amountText);

        if(amount.equals(amountText)){
            //System.out.println("The product is " + amount + " pieces.");
            logger.info(amount);
        }
        else{
            //System.out.println("The number of products in your basket is different.");
            logger.info("The number of products in your basket is different.");
        }
        logger.info("The number of products has been increased.");
        Thread.sleep(2000);
    }

    public void deleteProduct() throws InterruptedException {
        By deleteButton = By.cssSelector("a[title='Sil']");
        driver.findElement(deleteButton).click();
        Thread.sleep(2000);
        logger.info("The product has been deleted.");
    }

    public void controlBasket() throws InterruptedException {
        String basket = "Sepetinizde ürün bulunmamaktadır.";
        By basketControl = By.cssSelector("div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']>:nth-child(1)");
        String basketText = driver.findElement(basketControl).getText();
        Thread.sleep(2000);
        //System.out.println(basket + basketText);
        if (basket.equals(basketText)) {
            //System.out.println("There are no products in your basket.");
            logger.info("There are no products in your basket.");
        }
        else {
            //System.out.println("There are products in your basket.");
            logger.info("There are products in your basket.");
        }
        logger.info("It has been checked whether the basket is empty.");
    }
}
