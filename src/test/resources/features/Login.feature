#Author: zoia.pekun@orangehrm.com
@sprint3 @login
Feature: Login

  Background: 
    Given I see OrangeHRM logo

  @smoke @test
  Scenario: Valid login
    When I enter valid username and password
    And I click login button
    Then I successfully logged in

  @regression
  Scenario: Invalid login
    When I enter invalid username and password
    And I click login button
    Then I see error message is displayed

  @temp
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin4   | Admin123   | Invalid Credentials |
      | Admin5   | Syntax123! | Invalid Credentials |
