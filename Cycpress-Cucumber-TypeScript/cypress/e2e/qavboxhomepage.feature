Feature: qavbox.github.io

  Scenario: visiting the QVABox HomePage
    When I load qavbox home page
    Then I should see a valid title
    When I click on link "SignUp Form"
    And I fill up signup details
    And I go back to HomePage
    When I click on link "DragnDrop"
    And I drag and drop with draggable into droppable
    And I change the slider position to "50"
    Then slider range displayed should be "50"
    And I go back to HomePage
    When I click on link "WebTable"
    And I interact with webtable "Performance"
    And I go back to HomePage
    And I click on link "Alerts"
    And I interact with different alerts
    And I go back to HomePage
