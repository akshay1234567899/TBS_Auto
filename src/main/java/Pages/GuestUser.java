package Pages;

import TestBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Random;

public class GuestUser extends Base {
public GuestUser(){PageFactory.initElements(driver,this);}
Random random = new Random();
String randomEmail = "demotest" + random.nextInt(1000) + "@gmail.com";

@FindBy(xpath = "//input[@id='email'])")
WebElement enteremail;

@FindBy(xpath = "//input[@id=\"firstname\"]")
WebElement enterfirstname;
@FindBy(xpath = "//input[@id=\"lastname\"]")
WebElement enterlastname;
@FindBy(id="streetAddress")
WebElement streetaddress;

@FindBy(xpath = "//div[@name='Salutation']//button[@type='button']")
WebElement selectsalutation;

@FindBy(id="city")
WebElement entercityname;

@FindBy(xpath = "//div[@name=\"province\"]")
WebElement enterprovince;

@FindBy(xpath = "//input[@id=\"postalCode\"]")
WebElement postalcode;

@FindBy(xpath = "//input[@id=\"phone\"]")
WebElement phonenumber;
@FindBy(xpath = "//input[@name=\"terms\"]")
WebElement termandcondition;

@FindBy(xpath = "//div[@class='relative mt-[2px]']/following::input[@id='11:00 AM - 11:30 AM']")
WebElement selecttimeslot;

public void guestinformation() throws InterruptedException {

WebElement entermail = driver.findElement(By.id("email"));
entermail.sendKeys(randomEmail);
Actions actions = new Actions(driver);
actions.moveToElement(selectsalutation).click().perform();

//    List<WebElement> salutationOptions = driver.findElements(By.xpath("//ul[@class=\"itemUl shadow-[0_4px_30px_0px_rgba(0,0,0,0.07)] rounded-[5px] z-10 bg-white py-[10px] absolute lef-0 top-full w-full   block\"]"));
//    for (WebElement option : salutationOptions) {
//        Thread.sleep(5000);
//            String optionText = option.getText();
//        System.out.println(optionText);
//            if (optionText.equals("Mr")) {
//                option.click();
//            Thread.sleep(5000);
//        }
List<WebElement> options = driver.findElements(By.xpath("//ul//li[@data-value=\"Mr\"]"));
for (WebElement option : options) {
Thread.sleep(5000);
String optionText = option.getText();
if (optionText.equals("Mr")) {
actions.moveToElement(option).click().perform();
break;
}
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}


String firstname= prop.getProperty("firstname");
enterfirstname.sendKeys(firstname);

String lastname= prop.getProperty("lastname");
enterlastname.sendKeys(lastname);

String streetadd= prop.getProperty("cityname");
entercityname.sendKeys(streetadd);

Thread.sleep(5000);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0, 500)");
Thread.sleep(8000);
enterprovince.click();

List<WebElement> option= driver.findElements(By.xpath("//ul[@class='itemUl shadow-[0_4px_30px_0px_rgba(0,0,0,0.07)] rounded-[5px] z-10 bg-white py-[10px] absolute lef-0 top-full w-full   block']//li"));
for(WebElement option1:option){
    if (option1.getText().equalsIgnoreCase("Nova Scotia")){
        actions.moveToElement(option1).click().perform();
    }
}



//List<WebElement> option1 = driver.findElements(By.xpath("//ul[@class='itemUl shadow-[0_4px_30px_0px_rgba(0,0,0,0.07)] rounded-[5px] z-10 bg-white py-[10px] absolute lef-0 top-full w-full block']//li"));
//if (!option1.isEmpty()) {
//    Random random = new Random();
//    int randomIndex = random.nextInt(option1.size());
//    WebElement randomOption = option1.get(randomIndex);
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomOption);
//    actions.moveToElement(randomOption).click().perform();
//} else {
//    System.out.println("No options matching the criteria found.");
//}

String postcode= prop.getProperty("Postalcode");
postalcode.sendKeys(postcode);

String phoneNumber= prop.getProperty("phonenumber");
phonenumber.sendKeys(phoneNumber);

String address= prop.getProperty("StreetAddress");
streetaddress.sendKeys(address);

actions.moveToElement(selecttimeslot).click().build().perform();

Random random = new Random();
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

actions.moveToElement(termandcondition).click().build().perform();
Thread.sleep(3000);

WebElement continueButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
actions.doubleClick(continueButton).perform();
}
}


