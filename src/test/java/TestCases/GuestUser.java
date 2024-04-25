package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class GuestUser extends Base {
    @BeforeMethod
    public void setUp() throws IOException { initialization();}

    @Test
    public void orderfromguestuser() throws InterruptedException {

        obj.getAdditemcart().Additemoncart();
        obj.getAdditemcart().AddItemOnCart();
        obj.getcheckoutpage().checkoutpageitem();
        obj.getguestuser().guestinformation();
        obj.getorderpayment().enterpaymentcarddetails();
        obj.getthankyoupage().verifthankyoupage();
        obj.getLoginPage().teardown();
    }
}

