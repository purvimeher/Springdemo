@includeShadowDom(true)
@screenshotOnRunFailure(true)
# @retries(5)
Feature: qavbox.github.io

  Scenario: visiting the QVABox HomePage
    When I load qavbox home page
    Then I should see a valid title
    # And I should see all ten buttons
    # And I read testData file and display content
    # When I click on link "SignUp Form"
    # And I fill up signup details with all valid details
    # And I click on HomePage button
    # And I click on link "WebTable"
    # And I interact with webtable "Performance"
    # And I click on HomePage button
    # And I click on link "DragnDrop"
    # And I drag and drop with draggable into droppable
    # And I change the slider position to "50"
    # Then slider range displayed should be 50
    # When I click on HomePage button
    # And I click on link "Alerts"
    # And I interact with different alerts
    # And I click on HomePage button
    # And I click on link "Links"
    # Then number of buttons on links page should be 3
    # When I click on Link button "New Tab"
    # And I click on HomePage button
    # And I click on link "Auto Suggestions"
    # And I interact with auto suggesstion controls "Ind"
    # And I click on HomePage button
    # And I click on link "Delay"
    # And I interact with delay buttons "Click me"
    # Then The text "Click me" should appear after five seconds
    # When I click on HomePage button
    # And I click on link "iFrames"
    # And I enter text "Meher" into input box in outer frame
    # Then I verify text present in second frame
    # When I enter text "Meher" into input box in Inner frame
    # And I click on HomePage button
    And I click on link "Shadow DOM"
