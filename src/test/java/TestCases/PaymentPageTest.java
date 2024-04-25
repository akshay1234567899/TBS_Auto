package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentPageTest extends Base {
    @BeforeMethod
    public void setUp() throws IOException { initialization();}

    @Test
    public void verifypaymentPage() throws InterruptedException {
        obj.getLoginPage().VerifyUserLoginsuccessfully();
        obj.getAdditemcart().Additemoncart();
        obj.getAdditemcart().AddItemOnCart();
        obj.getcheckoutpage().checkoutpageitem();
        obj.getloggedinuserorder().loggedinuserorder();
        obj.getorderpayment().enterpaymentcarddetails();
        obj.getLoginPage().VerifyUserlogoutsuccessfully();
        obj.getorderpayment().teardown();
    }
}
