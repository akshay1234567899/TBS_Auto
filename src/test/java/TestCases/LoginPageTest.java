package TestCases;

import TestBase.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {

    public LoginPageTest(){super();}

    @BeforeMethod
    public void setUp() throws IOException { initialization();}

    @Test(priority = 0)
    public void VerifyLoginPageTitle(){
        String title = obj.getLoginPage().validateLoginPageTitle();
        Assert.assertEquals(title,"Home - The Beer Store");
    }

    @Test(priority = 1)
    public void Logintest() throws InterruptedException {
        obj.getLoginPage().VerifyUserLoginsuccessfully();
        obj.getLoginPage().VerifyUserlogoutsuccessfully();
        obj.getLoginPage().teardown();
    }
}

