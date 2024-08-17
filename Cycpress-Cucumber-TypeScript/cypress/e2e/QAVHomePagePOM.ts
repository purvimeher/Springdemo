import { Then, When } from "@badeball/cypress-cucumber-preprocessor";
import { QAVSignUpPage } from "./utils/dto/QAVSignUpPage"
import QAVHomePage from './utils/dto/QAVHomePage';
import QAVWebTablePage from "./utils/dto/QAVWebTablePage";
import QAVDragAndDropPage from "./utils/dto/QAVDragAndDropPage";
import QAVAlertsPage from "./utils/dto/QAVAlertsPage";
import QAVLinksPage from "./utils/dto/QAVLinksPage";
import QAVAutoSuggestionsPage from "./utils/dto/QAVAutoSuggestionsPage";
import QAVDelayPage from "./utils/dto/QAVDelayPage";
import QAVIFramesPage from "./utils/dto/QAVIFramesPage";

const qavHomePage = new QAVHomePage();
const qavSignUpPage = new QAVSignUpPage();
const qavWebTablePage = new QAVWebTablePage();
const qavDragDropPage = new QAVDragAndDropPage();
const qavAlertsPage = new QAVAlertsPage();
const qavLinksPage = new QAVLinksPage();
const qavAutoSuggestion = new QAVAutoSuggestionsPage();
const qavDelayPage = new QAVDelayPage();
const qavIframePage = new QAVIFramesPage();

When(/^I load qavbox home page$/, () => {
  qavHomePage.visitPage("https://qavbox.github.io/demo/");
});

When(/^I read testData file and display content$/,()=>{
    cy.readFile('cypress/fixtures/example.json').then((content)=>{
        cy.log(JSON.stringify(content));
    });

});

Then(/^I should see a valid title$/, () => {
    cy.title().should('eq', 'QAVBOX Demo');
});

Then(/^I should see all ten buttons$/, () => {
   qavHomePage.verifyAllTenButtonsExistsInOrder();
});

When(/^I click on link "([^"]*)"$/, (linkText) => {
    qavHomePage.clickOnLink(linkText);
});

When(/^I fill up signup details with (all valid details|partial details)$/, (option:string) => {
    cy.log(option);
    
    qavSignUpPage.enterUsername('Test POM')
    qavSignUpPage.enterEmail('somerandom@email.com');
    qavSignUpPage.enterTelephoneNo('1234556');
    qavSignUpPage.selectGender('male');
    qavSignUpPage.selectExperience('five');
    qavSignUpPage.selectSkills('java');
    qavSignUpPage.selectTools('Selenium');
    qavSignUpPage.uploadFile(['cypress/fixtures/example.json', 'cypress/fixtures/signupdetails.json']);
    qavSignUpPage.clickSubmit();
});

When(/^I click on HomePage button$/, () => {
    qavHomePage.clickHomePage();
});

When(/^I interact with webtable "([^"]*)"$/, (value) => {
    qavWebTablePage.InteractWithTable(value);
});

When(/^I drag and drop with draggable into droppable$/, () => {
 qavDragDropPage.DragAndDropWithDraggablIntoDroppable();
});

When(/^I change the slider position to "([^"]*)"$/, (position) => {
    qavDragDropPage.ChangeTheSliderPositionTo(50);
});

Then(/^slider range displayed should be ([^"]*)$/, (position) => {
    qavDragDropPage.verifySliderPostionText(position);
});

When(/^I interact with different alerts$/, () => {
    qavAlertsPage.ClickOnConfirmBtn();
});

Then(/^number of buttons on links page should be ([^"]*)$/, (noOfButtons:number) => {
    qavLinksPage.verifyAllButtonsArePresent(noOfButtons);
});

When(/^I click on Link button "([^"]*)"$/, (buttonName:string) => {
    qavLinksPage.clickOnSpecificButton(buttonName);
});

When(/^I interact with auto suggesstion controls "([^"]*)"$/, (value:string) => {
    qavAutoSuggestion.InteractWithInputBox(value);
});


When(/^I interact with delay buttons "([^"]*)"$/, (value) => {
    qavDelayPage.clickButton('Click me');
});

Then(/^The text "([^"]*)" should appear after five seconds$/, (position) => {
    qavDelayPage.verifyDelayedTextIsDisplayed('Click me')
});

When(/^I enter text "([^"]*)" into input box in outer frame$/, (value:string) => {
    qavIframePage.enterTextInOuterFrameInputBox(value);
});

When(/^I verify text present in second frame$/, () => {
    qavIframePage.verifyTextInInsideFrameInputBox('I am inside Frame');
});

When(/^I enter text "([^"]*)" into input box in Inner frame$/, (value:string) => {
    qavIframePage.enterTextInInsideFrameInputBox(value);
});