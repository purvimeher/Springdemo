Feature: qavbox.github.io

  Scenario: visiting the QVABox HomePage
    When I load qavbox home page
    Then I should see a valid title
    When I click on link "SignUp Form"
    And I fill up signup details
    When I click on link "DragnDrop"
    And I change the slider position to "50"
    Then slider range displayed should be "50"
