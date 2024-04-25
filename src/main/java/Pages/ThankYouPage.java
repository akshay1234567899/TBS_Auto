package Pages;

import TestBase.Base;
import org.openqa.selenium.support.PageFactory;


public class ThankYouPage extends Base {
public ThankYouPage() {PageFactory.initElements(driver, this);}

public void verifthankyoupage() throws InterruptedException {
Thread.sleep(13000);
String pageTitle = driver.getTitle();
if (pageTitle.contains("Thank you for your order - The Beer Store")) {
    System.out.println("Successfully placed order!");
}
else {
    System.out.println("Failed to place order!");
}
}
}