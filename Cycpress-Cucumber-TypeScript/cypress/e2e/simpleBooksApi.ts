import { Given } from "@badeball/cypress-cucumber-preprocessor";

let accessToken: string;
// Given("I have a valid access token", () => {
//     cy.request({
//         method: 'POST',
//         url: 'https://simple-books-api.glitch.me/api-clients/',
//         body: {
//             "clientName": "Postman"+Math.random().toString(5).substring(2),
//             "clientEmail": Math.random().toString(5).substring(2)+"@example.com"
//         }
//     }).then((response)=>{
//         expect(response).equal(200)
//     });
// });


Given("I have a valid access token", () => {
    cy.request({
        method: 'GET',
        url: 'https://restcountries.com/v3.1/alpha',
        qs: {
            codes:'170,est'
        }
    }).then((response) => {
        expect(response.status).equal(200);
        // cy.log(JSON.stringify(response.body[0].name));
    });
});