package com.spartaglobal.phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignIn {

    private WebDriver driver;
    private String homePageURL = "https://www.phptravels.net/index.php";
    private By myAccountButton = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']");
    private By loginButton = By.xpath("//a[@class='dropdown-item active tr']");

    // Login Page
    private String loginPageURL = "https://www.phptravels.net/login";
    private By emailTextBox = By.name("username");
    private By passwordTextBox = By.name("password");
    private By loginPageLoginButton = By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");

    private By errorMessageText = By.xpath("//div[@class='alert alert-danger']");
    public SignIn(WebDriver driver){
        this.driver = driver;
    }

    public SignIn goToHomePage(){
        driver.navigate().to(homePageURL);
        return this;
    }

    public SignIn clickMyAccountButton(){
        driver.findElement(myAccountButton).click();

        return this;
    }
    public SignIn clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    public String checkIfRedirectedToLoginPage(){
        return driver.getCurrentUrl();
    }

    public SignIn goToLoginPage(){
        driver.navigate().to(loginPageURL);
        return this;
    }

    public SignIn enterUsername(String email){
    driver.findElement(emailTextBox).sendKeys(email);
    return this;
    }

    public SignIn enterPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public SignIn clickLoginPageLoginButton(){
        driver.findElement(loginPageLoginButton).click();
        return this;
    }

    public String checkIfLoginSuccessful(){
        return driver.getCurrentUrl();
    }

    public void setTimeout(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String checkErrorMessageText() {
        return driver.findElement(errorMessageText).getText();
    }
}
