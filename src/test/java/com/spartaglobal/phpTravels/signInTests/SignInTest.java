package com.spartaglobal.phpTravels.signInTests;

import com.spartaglobal.phpTravels.PHPTravelsSite;
import com.spartaglobal.phpTravels.seleniumConfig.SeleniumConfig;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest {

    private static SeleniumConfig seleniumConfig = new SeleniumConfig("chrome","C:\\Users\\fabio\\Downloads\\chromedriver.exe");
    private static PHPTravelsSite phpTravelsSite = new PHPTravelsSite(seleniumConfig.getDriver());

    @Test
    public void goToHomePage(){
        phpTravelsSite.getSignIn().goToHomePage();
    }

    @Test
    public void testErrorMessage(){
       phpTravelsSite.getSignIn().goToLoginPage().enterPassword("xd").enterUsername("test").clickLoginPageLoginButton();
       seleniumConfig.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Invalid Email or Password",phpTravelsSite.getSignIn().checkErrorMessageText());
    }
}
