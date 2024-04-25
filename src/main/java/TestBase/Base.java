package TestBase;

import PageFactory.ObjectFactory;
import Utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static Properties prop ;
    public static WebDriver driver ;
    protected static ObjectFactory obj ;

     public Base() {
         try {
             prop = new Properties();
             FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Config//config.properties");
             prop.load(ip);
         } catch (FileNotFoundException e) {

             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    public void initialization() throws IOException {
        obj = new ObjectFactory();
        String browserName = prop.getProperty("browser");

//        Object WebDriverManager = null;
        if (browserName.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("enable-automation");
//            options.addArguments("--remote-allow-origins=*");
//            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("enable-automation");
//            options.addArguments("--remote-allow-origins=*");
//            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.Page_Load_Time));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.Implicit_Wait_Time));
//        driver.quit();
    }
    public void teardown(){
        driver.close();
        driver.quit();
    }
    }

