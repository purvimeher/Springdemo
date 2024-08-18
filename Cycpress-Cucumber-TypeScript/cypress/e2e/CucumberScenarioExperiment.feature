Feature: Cucumber Scenario Experiment

  Scenario: experimenting with cucumber steps in typescript
    Given I have a data table
      | meher | baba     |
      | sai   | baba     |
      | hari  | ashtakam |
    When I create SignInDetails object using data table
      | hari  | ashtakam | 111111 | male | one | cypress   |
      | meher | baba     | 123456 | male | one | java      |
      | sai   | baba     |  67890 | male | one | typescipt |
    And I call another step from this step 10
