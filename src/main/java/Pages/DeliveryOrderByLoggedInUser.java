package Pages;

import TestBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

public class DeliveryOrderByLoggedInUser extends Base {
    public DeliveryOrderByLoggedInUser() {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//p[contains(text(),'Home Delivery')]//ancestor::div/button")
    WebElement ClickOnHomeDeliverybtn;
    @FindBy(xpath = "//div[@class='relative mt-[2px]']/input[@id=\"11:00 AM - 1:00 PM\"]")
    WebElement selecttimeslot;

    @FindBy(xpath = "//input[@name=\"terms\"]")
    WebElement termandcondition;

public void deliveryorderfromloggedinuser() throws InterruptedException {

    Actions actions = new Actions(driver);
    Random random = new Random();
    actions.moveToElement(ClickOnHomeDeliverybtn).click().build().perform();
    Thread.sleep(5000);
    actions.moveToElement(selecttimeslot).click().build().perform();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 500)");


    int randomDay = random.nextInt(31) + 1;
    String day = String.format("%02d", randomDay);
    int randommonth=random.nextInt(12)+1;
    String month=String.format("%02d", randommonth);

    int minYear = 1900;
    int maxYear = 2005;
    int randomYear = random.nextInt(maxYear - minYear + 1) + minYear;
    String year = String.valueOf(randomYear);

    WebElement Date = driver.findElement(By.xpath("//input[@id=\"dobDay\"]"));
    Date.sendKeys(day);

    Thread.sleep(4000);
    WebElement Month = driver.findElement(By.xpath("//input[@id='dobMonth']"));
    Month.sendKeys(month);

    WebElement Year = driver.findElement(By.xpath("//input[@id='dobYear']"));
    Year.sendKeys(year);
    Thread.sleep(3000);

    WebElement continueButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
    actions.doubleClick(continueButton).perform();
}
}
