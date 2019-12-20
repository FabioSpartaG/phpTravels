package com.spartaglobal.phpTravels.pages;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    private WebDriver driver;

    public SignUp (WebDriver driver){
        this.driver = driver;
    }

    private By signUpButton = By.linkText("Sign Up");
    private String signUpURL = "https://www.phptravels.net/register";
    private By firstNameTextBox = By.name("firstname");
    private By lastNameTextBox = By.name("lastname");
    private By phoneTextBox = By.name("phone");
    private By emailTextBox = By.name("email");
    private By passwordTextBox = By.name("password");
    private By confirmPasswordTextBox = By.name("confirmpassword");
    private By getSignUpButton = By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']");

    public SignUp clickSignUpButton(){
        driver.findElement(signUpButton).click();
        return this;
    }

    public String checkIfRedirectedToSignUp(){
       return driver.getCurrentUrl();
    }

    public SignUp goToSignUpPage(){
        driver.navigate().to(signUpURL);
        return this;
    }

    public SignUp enterFirstName(String firstName){
        driver.findElement(firstNameTextBox).sendKeys(firstName);
        return this;
    }

    public SignUp enterLastName(String lastName){
        driver.findElement(lastNameTextBox).sendKeys(lastName);
        return this;
    }

    public SignUp enterPhoneNumber(String phoneNum){
        driver.findElement(phoneTextBox).sendKeys(phoneNum);
        return this;
    }

    public SignUp enterEmail (String email){
        driver.findElement(emailTextBox).sendKeys(email);
        return this;
    }

    public SignUp enterPassword(String password){
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public SignUp confirmPassword(String password){
        driver.findElement(confirmPasswordTextBox).sendKeys(password);
        return this;
    }

    public SignUp clickSignUpButtonInsideSignUp (){
        driver.findElement(getSignUpButton).click();
        return this;
    }

    public String getAccountURL(){
       return driver.getCurrentUrl();
    }
}