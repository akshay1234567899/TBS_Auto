package TestCases;

import TestBase.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateAccountTest extends Base {
@BeforeMethod
public void setUp() throws IOException { initialization();}

@Test
public void CreateAccountForNewUser() throws InterruptedException {
    obj.getCreateAccount().CreateNewAccount();
    obj.getLoginPage().teardown();
}
}

