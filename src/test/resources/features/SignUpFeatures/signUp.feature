Feature: As a user,
  I want to be able to create an account
  So that I can have access to more features of the website

  Scenario: I will be able to access the Sign Up Page
    Given I am on the homepage
    When I press the MyAccount button
    And I press the SignUp button
    Then I should be redirected to the Sign Up Page

  @outline
  Scenario Outline: I will be able to fill out the details correctly and have an account created
    Given I am on the Sign Up page
    When I enter a valid first name "<firstname>"
    And I enter a valid last name "<lastname>"
    And I enter a valid phone number "<phoneNumber>"
    And I enter a valid email "<email>"
    And I enter a valid password "<password>"
    And I confirm my password "<repassword>"
    And I press the Sign Up button
    Then I should be taken to my account's page

    Examples:
      | firstname      | lastname      | email                             |password           | repassword| phoneNumber |
      | Fabio          | Fernandes     | ffernandes@spartaglobalx.com       |Test1234           | Test1234  | 079456321   |