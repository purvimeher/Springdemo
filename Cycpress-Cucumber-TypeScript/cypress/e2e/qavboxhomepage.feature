Feature: qavbox.github.io
  Scenario: visiting the QVABox HomePage
    When I load qavbox home page
    Then I should see a valid title
    When I click on link "SignUp Form"
    And I fill up singnup details