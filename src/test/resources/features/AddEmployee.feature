#Author: zoia.pekun@orangehrm.com
@addEmployee @sprint5
Feature: Add Employeee

  Background: 
    Given I looged in into OrangeHRM
    And I click on PIM link
    And I click on Add Employee link

  @smoke
  Scenario Outline: Add Employee
    When I provide Employee details "<fName>" and "<mName>" and "<lName>" and "<location>"
    And I click on Save button
    Then I see Employee added successfully "<fName>" and "<lName>"

    Examples: 
      | fName | mName | lName | location |
      | Anna  | M     | Peter | HQ       |
      | Karl  | S     | Mint  | HQ       |
      | Mason | J     | Wells | HQ       |

  @regression
  Scenario Outline: Add Employee and Create Login Details
    When I provide Employee details "<fName>" and "<mName>" and "<lName>" and "<location>"
    And I click on create login details
    And I provide all mandatory fields "<userName>" and "<password>" and "<status>" and "<essRole>" and "<supervisor>"
    And I click on Save button
    Then I see Employee added successfully "<fName>" and "<lName>"

    Examples: 
      | fName | mName | lName | location | userName   | password       | status   | essRole     | supervisor         |
      | Anna  | M     | Peter | HQ       | anna-admim | Anna123@&^an89 | Enabled  | Default ESS | Default Supervisor |
      | Karl  | S     | Mint  | HQ       | AKarl      | K123arl&^%mM   | Disabled | Default ESS | Default Supervisor |

  @temp
  Scenario: AddEmployee Label Verification
    Then I see following labels
      | First Name           |
      | Middle Name         |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
