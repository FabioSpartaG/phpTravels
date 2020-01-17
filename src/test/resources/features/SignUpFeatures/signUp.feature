Feature: As a user,
  I want to be able to create an account
  So that I can have access to more features of the website

  Scenario: I will be able to access the Sign Up Page
    Given I am on the homepage
    When I press the MyAccount button
    And I press the SignUp button
    Then I should be redirected to the Sign Up Page


  @outline
  Scenario Outline: I will receive a valid error message if my passwords entered do not match
    Given I am on the Sign Up page
    When I enter a valid first name "<firstname>"
    And I enter a valid last name "<lastname>"
    And I enter a valid phone number "<phoneNumber>"
    And I enter a valid email "<email>"
    And I enter a valid password "<password>"
    And I enter a different password "<repassword>"
    And I press the Sign Up button
    Then I should receive a valid error message
    Examples:
      | firstname      | lastname      | email                              |password           | repassword  | phoneNumber |
      | Fabio          | Fernandes     | testemail@test.com                 |Test1234           | Test12345  | 079456321   |

    @outline
      Scenario Outline: I will receive a valid error message if I input an invalid password
      Given I am on the Sign Up page
      When I enter a valid first name "<firstname>"
      And I enter a valid last name "<lastname>"
      And I enter a valid phone number "<phoneNumber>"
      And I enter a valid email "<email>"
      And I enter an invalid password "<signUpInvalidPassword>"
      And I confirm my password "<repassword>"
      And I press the Sign Up button
      Then I should receive a valid error message
      Examples:
        | firstname      | lastname      | email                              |signUpInvalidPassword           | repassword  | phoneNumber |
        | Fabio          | Fernandes     | testemail@test.com                 |test                            | test        | 079456321   |

    @outline
      Scenario Outline: I will receive a valid error message if I input an invalid email
      Given I am on the Sign Up page
      When I enter a valid first name "<firstname>"
      And I enter a valid last name "<lastname>"
      And I enter a valid phone number "<phoneNumber>"
      And I enter an invalid email "<signUpInvalidEmail>"
      And I enter a valid password "<password>"
      And I confirm my password "<repassword>"
      And I press the Sign Up button
      Then I should receive a valid error message
      Examples:
        | firstname      | lastname      | signUpInvalidEmail                 |password           | repassword  | phoneNumber |
        | Fabio          | Fernandes     | testemail                          |Test1234           | Test1234    | 079456321   |

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
      | firstname      | lastname      | email                             |password            | repassword| phoneNumber |
      | Fabio          | Fernandes     | testemail@spartatest123.test         |Test1234           | Test1234  | 079456321   |
