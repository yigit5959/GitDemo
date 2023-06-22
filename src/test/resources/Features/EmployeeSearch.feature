Feature:  Searching the employee



  Background:
    When user enters valid email and valid password
    And click login button
    When user clicks on PIM option




  @smoke1

  Scenario: Search Employee by Id

   # Given open the browser and luch HRMS application
    #When user enters valid email and valid password
    #And click login button
    #When user clicks on PIM option
    When user enters valid employee id
    And Clicks on search button
    And user see employee information is displayed
   # And Close the browser



  @smoke1
    Scenario: Seaech Employee by Job Title
     # Given open the browser and luch HRMS application
     # When user enters valid email and valid password
     # And click login button
     # When user clicks on PIM option
      When user enters valid employee id
      When user select Job Title
      And Clicks on search button
      And user see employee information is displayed
     # And Close the browser






