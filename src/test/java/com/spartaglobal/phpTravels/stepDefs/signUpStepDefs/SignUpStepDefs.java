package com.spartaglobal.phpTravels.stepDefs.signUpStepDefs;

import com.spartaglobal.phpTravels.PHPTravelsSite;
import com.spartaglobal.phpTravels.seleniumConfig.SeleniumConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpStepDefs {

    private static SeleniumConfig seleniumConfig = new SeleniumConfig("chrome","C:\\Users\\fabio\\Downloads\\chromedriver.exe");
    private static PHPTravelsSite phpTravelsSite = new PHPTravelsSite(seleniumConfig.getDriver());

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        phpTravelsSite.getSignIn().goToHomePage();
    }

    @When("I press the MyAccount button")
    public void i_press_the_MyAccount_button() {
        phpTravelsSite.getSignIn().clickMyAccountButton();
    }

    @And("I press the SignUp button")
    public void i_press_the_SignUp_button() {
        phpTravelsSite.getSignUp().clickSignUpButton();
    }

    @Then("I should be redirected to the Sign Up Page")
    public void i_should_be_redirected_to_the_Sign_Up_Page() {
        Assert.assertEquals(phpTravelsSite.getSignUp().checkIfRedirectedToSignUp(),"https://www.phptravels.net/register");
    }

    /**
     *   Scenario Outline: I will be able to fill out the details correctly and have an account created
     */

    @Given("I am on the Sign Up page")
    public void i_am_on_the_Sign_Up_page() {
        phpTravelsSite.getSignUp().goToSignUpPage();
    }

    @When("I enter a valid first name {string}")
    public void i_enter_a_valid_first_name(String string) {
        phpTravelsSite.getSignUp().enterFirstName(string);
    }

    @When("I enter a valid last name {string}")
    public void i_enter_a_valid_last_name(String string) {
        phpTravelsSite.getSignUp().enterLastName(string);
    }

    @And ("I enter a valid phone number {string}")
    public void i_enter_a_valid_phone_number(String string) {
      phpTravelsSite.getSignUp().enterPhoneNumber(string);
    }
    @When("I enter a valid email {string}")
    public void i_enter_a_valid_email(String string) {
        phpTravelsSite.getSignUp().enterEmail(string);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String string) {
        phpTravelsSite.getSignUp().enterPassword(string);
    }

    @When("I confirm my password {string}")
    public void i_confirm_my_password(String string) {
       phpTravelsSite.getSignUp().confirmPassword(string);
    }

    @When("I press the Sign Up button")
    public void i_press_the_Sign_Up_button() {
        phpTravelsSite.getSignUp().clickSignUpButtonInsideSignUp();
    }

    @Then("I should be taken to my account's page")
    public void i_should_be_taken_to_my_account_s_page() {
        phpTravelsSite.getSignUp().threadSleep();
        Assert.assertEquals(phpTravelsSite.getSignUp().getAccountURL(),"https://www.phptravels.net/account/");
    }

    /**
     *     Scenario Outline: I will receive a valid error message if my passwords entered do not match
     */

    @When("I enter a different password {string}")
    public void i_enter_a_different_password(String string) {
        phpTravelsSite.getSignUp().confirmPassword(string);
    }

    @Then("I should receive a valid error message")
    public void i_should_receive_a_valid_error_message() {
        phpTravelsSite.getSignUp().threadSleep();
       String errorText =  phpTravelsSite.getSignUp().getErrorMessageText();
       Assert.assertTrue(errorText.contains("Password not matching with confirm password."));
    }
}
