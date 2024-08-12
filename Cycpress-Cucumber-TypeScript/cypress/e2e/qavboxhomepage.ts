import { When, Then } from "@badeball/cypress-cucumber-preprocessor";

When("I load qavbox home page", () => {
  cy.visit("https://qavbox.github.io/demo/");
});

Then("I should see a valid title", () => {
        cy.title().should('eq','QAVBOX Demo');
});

When(/^I click on link "([^"]*)"$/, (linkText) => {
    cy.get('.myhmenu a').each(($txt)=>{
       if($txt.text()== linkText){
        cy.wrap($txt).click();
       }
    })
});

When(/^I fill up singnup details$/, () => {
    cy.fixture("signupdetails").as('signupDetails').then((signupDetails)=>{
        cy.get('#username').type(signupDetails.firstName);
        cy.get('#email').type(signupDetails.email);
        cy.get('#tel').type(signupDetails.telephone);
        cy.get('select[name="sgender"]').select(signupDetails.gender);
        cy.get('input[name="experience"]').check(signupDetails.experience);
        cy.get('input[name="language"]').check(signupDetails.language);

        cy.get('#tools').select(signupDetails.options);
    })
});