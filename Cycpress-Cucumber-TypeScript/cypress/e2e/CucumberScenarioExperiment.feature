Feature: Cucumber Scenario Experiment

  Scenario: Experimenting with cucumber steps in typescript
    Given I have a data table
      | meher | baba     |
      | sai   | baba     |
      | hari  | ashtakam |
    When I create SignInDetails object using data table
      | hari  | ashtakam | 111111 | male | one | cypress   | Selenium,Oracle           |
      | meher | baba     | 123456 | male | one | java      | typescript,Oracle,cypress |
      | sai   | baba     |  67890 | male | one | typescipt | Java,Oracle               |
    And I call another step from this step 10
