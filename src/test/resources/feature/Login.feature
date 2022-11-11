@login
Feature: Login
  In order to manage the employee details
  as a admin
  I would like to access the orange hrm dashboard

  Background: 
    Given I have browser with Orange HRM application

  @valid @smoke
  Scenario: Verify Valid Login
    When I enter username as 'admin'
    And I enter password as 'admin123'
    And I click on login
    Then I should access the dashboard page with url 'https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index'

  @invalid
  Scenario Outline: Verify Invalid Login
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    Then I should not access to portal with error message as 'Invalid credentials'

    Examples: 
      | username | password |
      | saul     | saul123  |
      | kim      | kim123   |
