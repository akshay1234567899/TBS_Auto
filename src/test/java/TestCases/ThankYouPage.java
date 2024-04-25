package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ThankYouPage extends Base {
    @BeforeMethod
    public void setUp() throws IOException { initialization();}

    @Test
    public void checkorderplacedsuccessfully() throws InterruptedException {
        obj.getLoginPage().VerifyUserLoginsuccessfully();
        obj.getAdditemcart().Additemoncart();
        obj.getAdditemcart().AddItemOnCart();
        obj.getcheckoutpage().checkoutpageitem();
        obj.getorderpayment().enterpaymentcarddetails();
        obj.getthankyoupage().verifthankyoupage();
        obj.getLoginPage().VerifyUserlogoutsuccessfully();
        obj.getLoginPage().teardown();
    }
}
