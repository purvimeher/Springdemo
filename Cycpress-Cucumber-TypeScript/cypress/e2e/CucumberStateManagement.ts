import { Given } from "@badeball/cypress-cucumber-preprocessor";
import SignInDetails from './utils/dto/SignInDetails';

let signInDetails:SignInDetails ;
let JsonData:any;
Given("a step asynchronously assigning to World", function () {
    cy.then(() => {
        this.foo = "bar";
    });
    cy.fixture("signupdetails").then((content)=>{

           this.JsonData = content; 
    });
});

Given("a step accessing said assignment synchronously", function () {
        this.signInDetails = Object.assign(SignInDetails,this.JsonData);
        cy.log(JSON.stringify(this.signInDetails));

    expect(this.foo).to.equal("bar");
});