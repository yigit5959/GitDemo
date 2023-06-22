Feature: Employee


  @testcase2
  Scenario: Adding a new Employee

    Given open the browser and luch HRMS application
    When user enters valid email and valid password
    And click login button
    When user clicks on PIM option
    And user click on add employeee button
    And user enter firstname and middlename and last name
   # And user clicks on save button
    And Close the browser


    Scenario: adding thr employee from front end and verifying it from back end


