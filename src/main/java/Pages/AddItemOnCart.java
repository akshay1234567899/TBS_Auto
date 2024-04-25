package Pages;

import TestBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AddItemOnCart extends Base {
public AddItemOnCart() {
    PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//div[@style=\"position:relative\"]//ul[@data-orientation=\"horizontal\"]//a[text()='Shop Our Beers']")
WebElement ShopOurBeer;

@FindBy(xpath = "//a[contains(text(),'Shop All Beers')]")
WebElement ShopAllBeers;

@FindBy(xpath = "//span[@class='icon-store inline-flex text-[20px]']")
WebElement selectDropDown;

@FindBy(xpath = "//input[@placeholder='Search by postal code or city']")
WebElement searchstore;

@FindBy(xpath = "//button[@aria-label=\"search\"]")
WebElement clickonSearchIcon;

@FindBy(xpath = "//button[contains(text(),'Buy Now')]")
WebElement ButNowBTN;

@FindBy(xpath = "//button[contains(text(),'Buy Now')]")
WebElement clickOnBuyNow;

@FindBy(xpath = "//div[@class=\"row\"]//span[@class=\"icon-store inline-flex text-[20px]\"]")
WebElement storeicon;

@FindBy(xpath = "//button[contains(text(),'Accept all cookies')]")
WebElement acceptcookies;


@FindBy(xpath = "//button[contains(text(),'Save as my store')]")
WebElement saveasmystore;

@FindBy(xpath = "//a[@aria-label='QUEEN ST. Store details}']")
WebElement StoreDetails;

@FindBy(xpath = "//a[contains(text(),'Shop Our Beers')]")
WebElement shopourbeers;

@FindBy(xpath = "//button[@type=\"button\"]//span[contains(text(),'Relevance')]")
WebElement Relevance_filter;

@FindBy(xpath = "//ul[@class=\"itemUl shadow-[0_4px_30px_0px_rgba(0,0,0,0.07)] rounded-[5px] z-10 bg-white py-[10px] absolute lef-0 top-full w-full block\"]")
WebElement filter_frame;

@FindBy(xpath = "//a[contains(text(),'Shop All Beers')]")
WebElement shopallbeers;
@FindBy(xpath = "//a[@aria-label=\"COORS LIGHT 30 X Can 355 ml\"]")
WebElement pickfirstbeer;


@FindBy(xpath = "//div[@class=\"flex flex-row md:flex-row md:gap-[30px]\"]//input[@name=\"email\"]")
WebElement subscribe_to_our_newsletter;


@FindBy(xpath = "//button[@id=\"ageConfirm\"]")
WebElement checkbox;

@FindBy(xpath = "//button[@id=\"terms\"]")
WebElement term_condition;

@FindBy(xpath = "//button[contains(text(),'SUBSCRIBE')]")
WebElement subscribebutton;
@FindBy(xpath = "//img[@alt=\"close icon\"]")
WebElement closebutton;

@FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
WebElement addtocart_button;

@FindBy(xpath = "//input[@type=\"text\"]")
WebElement addcartquantity;

@FindBy(xpath = "//img[@alt=\"checkout_icon\"]")
WebElement clickoncarticon;

public void Additemoncart() throws InterruptedException {
    Thread.sleep(8000);
    storeicon.click();
    Thread.sleep(5000);
    searchstore.click();
    searchstore.sendKeys("Queen St E, Brampton, ON, Canada");
    Thread.sleep(5000);
    clickonSearchIcon.click();
    acceptcookies.click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 500)");
    Thread.sleep(8000);
    StoreDetails.click();
    Thread.sleep(8000);
    WebElement saveAsMyStore = driver.findElement(By.xpath("//button[contains(text(),'Save as my store')]"));
    Actions actions = new Actions(driver);
    actions.moveToElement(saveAsMyStore).click().build().perform();
}

public void AddItemOnCart() throws InterruptedException {
    shopourbeers.click();
    shopallbeers.click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[text()='Relevance']")).click();
    Thread.sleep(5000);


    SortFiltersEnums[] enumValues = SortFiltersEnums.values();
    Random random = new Random();
    SortFiltersEnums randomEnumValue = enumValues[random.nextInt(enumValues.length)];

    String filter = "//div//ul[@class='itemUl shadow-[0_4px_30px_0px_rgba(0,0,0,0.07)] rounded-[5px] z-10 bg-white py-[10px] absolute lef-0 top-full w-full block']//li[text()='%s']";
    driver.findElement(By.xpath(String.format(filter, randomEnumValue.getResourcesName()))).click();

    //div[@class='flex flex-col']//h2[@class='font-sans font-bold text-[14px]  eq-height recipes-height leading-[1.4] block']
    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='flex flex-col']//div[@class=\"px-[16px] md:px-[20px] font-sans font-medium text-[14px]\"]"));
    System.out.println("Number of products found: " + elements.size());
    Thread.sleep(5000);

    int numOfElements = elements.size();
    Thread.sleep(6000);
    int randomIndex = random.nextInt(numOfElements);
    WebElement randomElement = elements.get(randomIndex);
    System.out.println(randomElement);
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomElement);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Thread.sleep(8000);
//    driver.findElement(By.xpath(String.format("(//div[@class='flex flex-col']//h2[@class='font-sans font-bold text-[14px]  eq-height recipes-height leading-[1.4] block'])[%s]", randomIndex))).click();
    WebElement element = driver.findElement(By.xpath(String.format("(//a[contains(text(),'Buy Now')])[%s]", randomIndex)));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().perform();
    Thread.sleep(5000);

// logged in user -----------------------format.
    String Useremailaddress = prop.getProperty("username");
    subscribe_to_our_newsletter.sendKeys(Useremailaddress);
    checkbox.click();
    term_condition.click();
    actions.moveToElement(subscribebutton).click().build().perform();
//    closebutton.click();
    Thread.sleep(9000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 500)");
    Thread.sleep(9000);
    addcartquantity.clear();
    addcartquantity.sendKeys("2");
    actions.moveToElement(addtocart_button).click().perform();
}
}

