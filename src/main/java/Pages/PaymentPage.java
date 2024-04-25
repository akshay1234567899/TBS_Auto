package Pages;

import TestBase.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

public class PaymentPage extends Base {
public PaymentPage(){PageFactory.initElements(driver,this);}

@FindBy(xpath = "//input[@id=\"cardNumber\"]")
WebElement carddetails;

@FindBy(xpath = "//input[@id=\"cardName\"]")
WebElement cardholdername;

@FindBy(xpath = "//input[@id=\"mm\"]")
WebElement entermonth;

@FindBy(xpath = "//input[@id=\"yy\"]")
WebElement enteryear;

@FindBy(xpath = "//input[@id=\"securityCode\"]")
WebElement entercvv;

@FindBy(xpath = "//button[@type=\"submit\"]")
WebElement paynow;


public void enterpaymentcarddetails()  throws InterruptedException {
    Thread.sleep(9000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 800)");

//    payment card details..........................
    String Cardnumber= prop.getProperty("CardNumber");
    carddetails.sendKeys(Cardnumber);
    cardholdername.sendKeys("demo test");
    Random random = new Random();
    int randomMonth = random.nextInt(12) + 1;
    int randomYear = random.nextInt(6) + 25;
    int randomCVV = random.nextInt(900) + 100;
    entermonth.sendKeys(String.format("%02d", randomMonth));
    enteryear.sendKeys(String.valueOf(randomYear));
    entercvv.sendKeys(String.valueOf(randomCVV));
    Thread.sleep(5000);
    Actions actions = new Actions(driver);
    actions.moveToElement(paynow).click().build().perform();
}
}
