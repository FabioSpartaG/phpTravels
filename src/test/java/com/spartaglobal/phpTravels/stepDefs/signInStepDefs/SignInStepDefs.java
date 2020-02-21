package com.spartaglobal.phpTravels.stepDefs.signInStepDefs;

import com.spartaglobal.phpTravels.PHPTravelsSite;
import com.spartaglobal.phpTravels.seleniumConfig.SeleniumConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInStepDefs {


    private static SeleniumConfig seleniumConfig = new SeleniumConfig("chrome","D:\\Java\\chromedriver.exe");
    private static PHPTravelsSite phpTravelsSite = new PHPTravelsSite(seleniumConfig.getDriver());

    /**
     *   Scenario: I will be able to access the login page
     */
    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
       phpTravelsSite.getSignIn().goToHomePage();
    }

    @When("I press the MyAccount button")
    public void i_press_the_MyAccount_button() {
        phpTravelsSite.getSignIn().clickMyAccountButton();
    }

    @And("I press the Login button")
    public void i_press_the_Login_button() {
        phpTravelsSite.getSignIn().clickLoginButton();
    }

    @Then("I will be taken to the page to login")
    public void i_will_be_taken_to_the_page_to_login() {
    Assert.assertEquals(phpTravelsSite.getSignIn().checkIfRedirectedToLoginPage(),"https://www.phptravels.net/login");
    }


/**
 *   Scenario Outline: I will enter a correct username and password and successfully login
 */

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
    phpTravelsSite.getSignIn().goToLoginPage();
    }

    @When("I enter a valid email {string}")
    public void i_enter_a_valid_email(String string) {
        phpTravelsSite.getSignIn().enterUsername(string);
    }
    @And("I enter a valid password {string}")
    public void i_enter_a_valid_password(String string) {
        phpTravelsSite.getSignIn().enterPassword(string);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        phpTravelsSite.getSignIn().clickLoginPageLoginButton();
    }

    @Then("I will be taken to my account page")
    public void i_will_be_taken_to_my_account_page() {
        try {
            Thread.sleep(3*1000); // Wait 3 seconds before moving to the Assert condition
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(phpTravelsSite.getSignIn().checkIfLoginSuccessful(),"https://www.phptravels.net/account/");
    }


    /**
     *       Scenario Outline: I will enter an incorrect email and password and receive a valid error message
     */

    @When("I enter an invalid email {string}")
    public void i_enter_an_invalid_email(String string) {
        phpTravelsSite.getSignIn().enterUsername(string);
    }

    @When("I enter an invalid password {string}")
    public void i_enter_an_invalid_password(String string) {
        phpTravelsSite.getSignIn().enterPassword(string);
    }

    @Then("I will receive an error message")
    public void i_will_receive_an_error_message() {
        phpTravelsSite.getSignIn().setTimeout();
        Assert.assertEquals("Invalid Email or Password", phpTravelsSite.getSignIn().checkErrorMessageText());
    }
}
