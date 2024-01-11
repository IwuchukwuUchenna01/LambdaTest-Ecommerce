package Etest;

import io.qameta.allure.Description;
import org.testng.annotations.*;

public class EcommerceTest {
    EcommerceObjects ecommerce = new EcommerceObjects();
    @BeforeMethod
    public void openPage(){
        ecommerce.setUp();
    }
    @Test (priority = 0)
    @Description("Default User Login")
    public void createUser(){
        ecommerce.accountCreation();
        ecommerce.createUser();
        ecommerce.confirmAccountCreation(Selectors.element,Selectors.webText);
        ecommerce.logout();
        ecommerce.login();
    }
    @Test (priority = 1)
    @Description("First User Login")
    public void createUser1(){
        ecommerce.accountCreation();
        ecommerce.createUser();
        ecommerce.confirmAccountCreation(Selectors.element,Selectors.webText);
        ecommerce.logout();
        ecommerce.login();
    }
    @Test (priority = 2)
    @Description("second user successfully logged in")
    public void createUser2(){
        ecommerce.accountCreation();
        ecommerce.createUser();
        ecommerce.confirmAccountCreation(Selectors.element,Selectors.webText);
        ecommerce.logout();
        ecommerce.login();
    }
    @AfterMethod
    public void takeOut(){
        ecommerce.logout();
        ecommerce.tearDown();
    }
    @AfterTest
    public void tearDown(){
        ecommerce.tearDown();
    }
}
