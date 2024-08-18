import { Given } from "@badeball/cypress-cucumber-preprocessor";
import QAVHomePage from "./utils/dto/QAVHomePage";
import SignInDetails from "./utils/dto/SignInDetails";
import { plainToInstance } from 'class-transformer';

const qavHomePage = new QAVHomePage();

Given(/^I execute a custom command$/, () => {
    qavHomePage.visitPage("/demo/");
    cy.login('Avatar Meherbaba Ki Jai!!!', 'Sachitananda Paramananda Meherbaba Vigyananda!!!');
});

Given(/^I execute cypress info commands$/, () => {
    cy.log('CPU ARCH : ' + Cypress.arch);
    cy.log('Browser details : ' + JSON.stringify(Cypress.browser));
    cy.log('Testing type : ' + Cypress.testingType);
    cy.log('Current Test : ' + JSON.stringify(Cypress.currentTest));
    cy.log('Spec Info : ' + JSON.stringify(Cypress.spec));
    cy.log('Cypress Version Info : ' + Cypress.version);
});


Given(/^I execute custom cypress query commands$/, () => {
    // qavHomePage.visitPage("/demo/");
    // cy.login('Avatar Meherbaba Ki Jai!!!', 'Sachitananda Paramananda Meherbaba Vigyananda!!!');
});


Given(/^I try to convert json into custom object$/, function () {
    let signInDetails: SignInDetails = new SignInDetails();
    cy.fixture("signupdetails").then((content) => {
        Object.assign(signInDetails, content);
        //    signInDetails = plainToInstance(SignInDetails, content as Object);
        cy.log('Converted Object : ' + JSON.stringify(signInDetails));
    });
    cy.fixture('testdata.json').then((testData) => {
        cy.log(JSON.stringify(testData.TC02.case_id));
        cy.log(JSON.stringify(testData.TC02.case));
    });
});