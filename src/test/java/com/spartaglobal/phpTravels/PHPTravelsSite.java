package com.spartaglobal.phpTravels;

import com.spartaglobal.phpTravels.pages.SignIn;
import org.openqa.selenium.WebDriver;

public class PHPTravelsSite {
    private WebDriver driver;
    private SignIn signIn;

    public PHPTravelsSite(WebDriver driver){
        this.driver = driver;
        this.signIn = new SignIn(driver);
    }

    public SignIn getSignIn(){
        return signIn;
    }
}
