package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddItemOnCartPage extends Base {
    @BeforeMethod
    public void setUp() throws IOException { initialization();}
    @Test
    public void cartItem() throws InterruptedException {
        obj.getLoginPage().VerifyUserLoginsuccessfully();
        obj.getAdditemcart().Additemoncart();
        obj.getAdditemcart().AddItemOnCart();
        obj.getLoginPage().VerifyUserlogoutsuccessfully();
        obj.getLoginPage().teardown();
    }
}

