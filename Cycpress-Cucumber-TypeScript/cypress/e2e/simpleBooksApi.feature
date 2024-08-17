Feature: Simple books API  Test

  Scenario: GET API TEST
    Given I have a valid access token
    And I do a get status request
    And I post a new book order
    And I request for all orders
