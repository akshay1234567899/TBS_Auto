package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GuestUserDeliveryOrder extends Base {
    @BeforeMethod
    public void setUp() throws IOException { initialization();}

    @Test
    public void deliveryorderforguestuser() throws InterruptedException {
        obj.getAdditemcart().Additemoncart();
        obj.getAdditemcart().AddItemOnCart();
        obj.getcheckoutpage().checkoutpageitem();
        obj.getdeliveryorderguestuser().homedeliveryforguestuser();
        obj.getthankyoupage().verifthankyoupage();
        obj.getthankyoupage().teardown();
    }
}
