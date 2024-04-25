package Pages;

import TestBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class DeliveryOrderGuestUser extends Base {
    public DeliveryOrderGuestUser(){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//p[contains(text(),'Home Delivery')]//ancestor::div/button")
    WebElement ClickOnHomeDeliverybtn;

    @FindBy(xpath = "//div[@name='Salutation']//button[@type='button']")
    WebElement selectsalutation;

    @FindBy(xpath = "//input[@id=\"firstname\"]")
    WebElement enterfirstname;
    @FindBy(xpath = "//input[@id=\"lastname\"]")
    WebElement enterlastname;

    Random random = new Random();
    Actions actions= new Actions(driver);
    String randomEmail = "test" + random.nextInt(1000) + "@gmail.com";

    @FindBy(xpath = "//input[@id=\"phone\"]")
    WebElement phonenumber;

    @FindBy(id = "deliveryAddress")
    WebElement deliveryaddress;


    @FindBy(xpath = "//div[@class='relative mt-[2px]']/input[@id=\"11:00 AM - 1:00 PM\"]")
    WebElement selecttimeslot;

    @FindBy(xpath = "//input[@name=\"terms\"]")
    WebElement termandcondition;

    @FindBy(xpath = "//div[@class=\"mt-1\"]//following::input[@id='lds']")
    WebElement checkbox2;

    public void homedeliveryforguestuser() throws InterruptedException {
        Random random = new Random();
        actions.moveToElement(ClickOnHomeDeliverybtn).click().build().perform();
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectsalutation).click().perform();

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

        WebElement entermail = driver.findElement(By.id("email"));
        entermail.sendKeys(randomEmail);

        String phoneNumber= prop.getProperty("phonenumber");
        phonenumber.sendKeys(phoneNumber);

        actions.moveToElement(deliveryaddress).click().build().perform();
        String streetaddress= prop.getProperty("StreetAddress");
        deliveryaddress.sendKeys(streetaddress);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(15000);
        List<WebElement> options1 = driver.findElements(By.xpath("//div[@class=\"absolute bg-white overflow-auto max-h-[170px] scroll-bar-grey py-[10px] z-[2] w-full shadow-lg  rounded-[5px] mt-[5px]\"]//ul//li"));
        System.out.println("Drop Down size element:"+options1.size());
        Thread.sleep(5000);

        for (WebElement option : options1) {
            if (option.getText().equalsIgnoreCase("198 Queen St E, Brampton, ON, L6V 1B7")) {
                actions.moveToElement(option).click().perform();
                break;
            }
        }
//
//        int randomIndex = random.nextInt(options1.size());
//        WebElement randomOption = options1.get(randomIndex);
//        actions.moveToElement(randomOption).click().perform();

        Thread.sleep(8000);
        actions.moveToElement(selecttimeslot).click().build().perform();


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
        actions.moveToElement(checkbox2).click().build().perform();
        Thread.sleep(3000);

        WebElement continueButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        actions.doubleClick(continueButton).perform();
    }
}
