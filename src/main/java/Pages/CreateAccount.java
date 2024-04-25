package Pages;

import TestBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;

public class CreateAccount extends Base {
public CreateAccount(){PageFactory.initElements(driver,this);}

@FindBy(xpath = "//p[contains(text(),'Account')]")
WebElement AccountBTN;

@FindBy(xpath = "//a[@href='/register']")
WebElement CreateAnAccount;

@FindBy(xpath = "//div[@name='Salutation']//button[@type='button']")
WebElement salutation_dropdwon;

@FindBy(xpath = "(//div[@class='mt-1'])[1]//input[@type='checkbox']")
WebElement TermandConditioin;

@FindBy(xpath = "//div[@class='mt-1']//input[@id='updateAndPromotions']")
WebElement policyandcontact;

@FindBy(xpath = "//button[contains(text(),'register')]")
WebElement registerbutton;

@FindBy(xpath = "//button[contains(text(),'Accept all cookies')]")
WebElement acceptallcookies;

public void CreateNewAccount() throws InterruptedException {
Thread.sleep(5000);
AccountBTN.click();
CreateAnAccount.click();
Thread.sleep(5000);
salutation_dropdwon.click();

List<WebElement> options = driver.findElements(By.xpath("//div[@name='Salutation']//ul//li[@data-value=\"Mr\"]"));
for (WebElement option : options) {
option.click();
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
Random random = new Random();

String alphabet = "abcdefghijklmnopqrstuvwxyz";
String baseFirstName = "Demo";
String baseLastName = "Test";
int randomIndex = random.nextInt(alphabet.length());
String randomFirstName = baseFirstName + alphabet.charAt(randomIndex);
randomIndex = random.nextInt(alphabet.length());
String randomLastName = baseLastName + alphabet.charAt(randomIndex);

String randomEmail = "demotest" + random.nextInt(1000) + "@gmail.com";
String randomPhoneNumber = "8" + String.format("%09d", random.nextInt(1000000000));
String randomPassword = "demo@" + random.nextInt(1000);

int randomDay = random.nextInt(31) + 1;
String day = String.format("%02d", randomDay);

int randommonth=random.nextInt(12)+1;
String month=String.format("%02d", randommonth);

int minYear = 1900;
int maxYear = 2005;
int randomYear = random.nextInt(maxYear - minYear + 1) + minYear;
String year = String.valueOf(randomYear);


WebElement firstname = driver.findElement(By.id("firstname"));
firstname.sendKeys(randomFirstName);

WebElement lastname = driver.findElement(By.id("lastname"));
lastname.sendKeys(randomLastName);

WebElement entermail = driver.findElement(By.name("email"));
entermail.sendKeys(randomEmail);

WebElement enterPhoneMail = driver.findElement(By.id("phone"));
enterPhoneMail.sendKeys(randomPhoneNumber);

WebElement enterpassword = driver.findElement(By.xpath("//input[@id='password']"));
enterpassword.sendKeys("demo@123");

WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
confirmpassword.sendKeys("demo@123");

WebElement Date = driver.findElement(By.xpath("//input[@id='dobDay']"));
Date.sendKeys(day);

Thread.sleep(4000);
WebElement Month = driver.findElement(By.xpath("//input[@id='dobMonth']"));
Month.sendKeys(month);

WebElement Year = driver.findElement(By.xpath("//input[@id='dobYear']"));
Year.sendKeys(year);
Thread.sleep(3000);
acceptallcookies.click();

Actions actions = new Actions(driver);
WebElement checkbox = driver.findElement(By.xpath("(//div[@class='mt-1'])[1]//input[@type='checkbox']"));
actions.click(checkbox).build().perform();

Thread.sleep(4000);
actions.moveToElement(registerbutton).click().perform();
}
}

