Feature: As a user,
      I want to be able to enter a username and password
      So that I have access to my account

  Scenario: I will be able to access the login page
    Given I am on the homepage
    When I press the MyAccount button
    And I press the Login button
    Then I will be taken to the page to login

  @outline
  Scenario Outline: I will enter an incorrect email and password and receive a valid error message
    Given I am on the login page
    When I enter an invalid email "<email>"
    And I enter an invalid password "<password>"
    And I click the login button
    Then I will receive an error message

    Examples:
      | email                | password    |
      | bigdickwen@gmail.com | bigdickwenbigdicknow    |

  @outline
  Scenario Outline: I will enter a correct username and password and successfully login
    Given I am on the login page
    When I enter a valid email "<username>"
    And I enter a valid password "<password>"
    And I click the login button
    Then I will be taken to my account page

    Examples:
      | username            | password |
      | user@phptravels.com | demouser |

