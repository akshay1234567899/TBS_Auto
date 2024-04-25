package Pages;

import TestBase.Base;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Random;

public class Checkoutpage extends Base {
    public Checkoutpage(){PageFactory.initElements(driver,this);}
    Random random = new Random();

    @FindBy(xpath = "//a[@href=\"/cart\"]")
    WebElement checkout_Icon;

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement addcartquantity;

    @FindBy(xpath = "(//input[@id=\"coors-light~2002\"])[2]")
    WebElement enterproductquantity;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    WebElement clickonchekcoutbutton;

    @FindBy(xpath = "//div[@class=\"slick-list\"]//following::img[@alt=\"next\"]")
    WebElement clickonNextButton;

   @FindBy(xpath = "//div[@class='relative mt-[2px]']/following::input[@id='11:00 AM - 11:30 AM']")
   WebElement selecttimeslot;

   @FindBy(xpath = "//input[@name=\"terms\"]")
   WebElement termandcondition;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement clickonContinuebtn;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    WebElement addtocart_button;

    @FindBy(xpath = "//input[@placeholder=\"Enter Email Address\"]")
    WebElement enteremailaddress;

    public void checkoutpageitem() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//a[@href=\"/cart\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
//        actions.moveToElement(clickonchekcoutbutton).click().perform();
        Thread.sleep(15000);


        try {
            WebElement priceElement = driver.findElement(By.xpath("//p[contains(text(),'Cart Total')]/following-sibling::p"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priceElement);
            Thread.sleep(5000);
            double cartTotal = Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
            System.out.println("Actual price: " + cartTotal);

            if (cartTotal <20) {
                for (int i = 0; i < 5; i++) {
                    driver.findElement(By.xpath("(//img[@src=\"/cart-plus.svg\"])[2]"));
                }
                actions.moveToElement(clickonchekcoutbutton).click().perform();

            } else if (cartTotal ==20) {
//
//                    driver.findElement(By.xpath("(//img[@src=\"/cart-plus.svg\"])[2]")).click();
//                    cartTotal = Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));

                actions.moveToElement(clickonchekcoutbutton).click().perform();
            } else
            {
                actions.moveToElement(clickonchekcoutbutton).click().perform();
            }

        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }


        Thread.sleep(15000);
        js.executeScript("window.scrollBy(0, 800)");
        Thread.sleep(8000);
//       WebElement selectslot= driver.findElement(By.xpath("//div[@class=\"space-y-2 pt-[30px] xs:pt-[25px]\"]//div[@class=\"flex justify-between basis-full md:basis-1/2\"]//label[@for=\"11:00 AM - 11:30 AM\"]")).click();
//        actions.moveToElement(selecttimeslot).click().build().perform();

    }
}
