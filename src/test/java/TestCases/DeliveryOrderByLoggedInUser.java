package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeliveryOrderByLoggedInUser extends Base {

    @BeforeMethod
    public void setUp() throws IOException { initialization();}

    @Test
    public void verifyDeliveryOrderloggedinUser() throws InterruptedException {
        obj.getLoginPage().VerifyUserLoginsuccessfully();
        obj.getAdditemcart().Additemoncart();
        obj.getAdditemcart().AddItemOnCart();
        obj.getcheckoutpage().checkoutpageitem();
        obj.getloggedindeliveryorder().deliveryorderfromloggedinuser();
        obj.getthankyoupage().verifthankyoupage();
        obj.getdeliveryorderguestuser().teardown();
    }
}
