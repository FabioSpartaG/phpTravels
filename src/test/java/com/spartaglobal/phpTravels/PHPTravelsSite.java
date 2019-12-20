package com.spartaglobal.phpTravels;

import com.spartaglobal.phpTravels.pages.SignIn;
import com.spartaglobal.phpTravels.pages.SignUp;
import org.openqa.selenium.WebDriver;

public class PHPTravelsSite {
    private WebDriver driver;
    private SignIn signIn;
    private SignUp signUp;
    public PHPTravelsSite(WebDriver driver){
        this.driver = driver;
        this.signIn = new SignIn(driver);
        this.signUp = new SignUp(driver);
    }

    public SignIn getSignIn(){
        return signIn;
    }

    public SignUp getSignUp(){
        return signUp;
    }
}
