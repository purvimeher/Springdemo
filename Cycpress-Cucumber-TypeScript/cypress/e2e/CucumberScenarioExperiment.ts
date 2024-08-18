import { DataTable, Given, Step, When } from "@badeball/cypress-cucumber-preprocessor";
import SignInDetails from './utils/dto/SignInDetails';

let signInDetailsList: SignInDetails[] = new Array();
Given(/^I have a data table$/, (table: DataTable) => {
    table.raw().forEach((row) => {

        // row.forEach((col)=>{
        //     cy.log(col.toUpperCase());
        // })
        cy.log(row[0].toString().toUpperCase() + ' : ' + row[1].toString().toUpperCase());
        // cy.log(' : ');

        const expected = [
            ["meher", "baba"],
            ["sai", "baba"],
            ["hari", "ashtakam"]
        ];
        assert.deepEqual(table.raw(), expected);
    });
});

When(/^I create SignInDetails object using data table$/, (table: DataTable) => {
    table.raw().forEach((row) => {
        let signInDetails = new SignInDetails();
        signInDetails.firstName = row[0];
        signInDetails.email = row[1];
        signInDetails.telephone = row[2];
        signInDetails.gender = row[3];
        signInDetails.experience = row[4];
        signInDetails.language = row[5];
        signInDetails.options = row[6].split(',');

        signInDetailsList.push(signInDetails);
        // cy.log(JSON.stringify(signInDetails));
        // cy.log(signInDetailsList.length.toString());

    });
});

When(/^I call another step from this step ([^"]*)$/,(value:number)=>{
    cy.log('This from caller step : '+value);
    Step(this,"this is another step 20");
});


When(/^this is another step([^"]*)$/,(value:number)=>{
    cy.log('This is from another step : '+value);
    signInDetailsList.forEach((object) => {
        cy.log(JSON.stringify(object));
    });

    cy.log(signInDetailsList.length.toString());
});