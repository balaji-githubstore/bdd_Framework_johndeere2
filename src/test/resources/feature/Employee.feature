@employee
Feature: Employee
  In order to manage the add,edit,delete employee details
  as a admin
  I would like get access to modfiy the employee records

#created on nov 11

  @addemployee
  Scenario Outline: Verify Add Valid Employee
    Given I have browser with Orange HRM application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    And I click on PIM menu
    And I click on Add Employee
    And I fill the new employee details
      | firstname | middlename   | lastname |
      | <fname>   | <middlename> | <lname>  |
    And I click on save employee
    Then I should see the added name under personal details page

    Examples: 
      | username | password | fname | middlename | lname |
      | admin    | admin123 | john  | m          | wick  |
      #| admin    | admin123 | peter | m          | hein  |

