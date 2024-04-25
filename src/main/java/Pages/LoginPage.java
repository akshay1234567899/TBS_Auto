package Pages;

import TestBase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

public LoginPage(){PageFactory.initElements(driver,this);}

public   String validateLoginPageTitle(){ return driver.getTitle(); }

@FindBy(xpath = "//p[contains(text(),'Account')]")
WebElement  AccountBTN;

@FindBy(xpath = "//div[@class='space-y-2 form-itm']//input[@name='email']")
WebElement emailaddress;

@FindBy(xpath = "//div[@class='space-y-2 form-itm']//input[@name='password']")
WebElement enterpassword;

@FindBy(xpath = "//button[@type='submit']")
WebElement clickLoginBTN;

@FindBy(xpath = "//img[@alt='user']")
WebElement Usersnap;

@FindBy(xpath = "//a[contains(text(),'Logout')]")
WebElement Logout;

public void VerifyUserLoginsuccessfully() throws InterruptedException {
    Thread.sleep(10000);
    AccountBTN.click();
    String Useremailaddress = prop.getProperty("username");
    String Usercredential = prop.getProperty("password");
    emailaddress.sendKeys(Useremailaddress);
    enterpassword.sendKeys(Usercredential);
    clickLoginBTN.click();
}
public void VerifyUserlogoutsuccessfully() throws InterruptedException {
    Thread.sleep(10000);
    Usersnap.click();
    Logout.click();
}
}



