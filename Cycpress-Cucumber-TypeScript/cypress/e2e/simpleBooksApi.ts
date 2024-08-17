import { Given } from "@badeball/cypress-cucumber-preprocessor";

let accessToken: string;

Given("I have a valid access token", () => {
    cy.request({
        method: 'POST',
        url: 'https://simple-books-api.glitch.me/api-clients/',
        body: {
            "clientName": "Postman" + Math.random().toString(5).substring(2),
            "clientEmail": Math.random().toString(5).substring(2) + "@example.com"
        }
    }).then((response) => {
        expect(response.status).equal(201)
        accessToken = response.body.accessToken;
        cy.log(accessToken)
    });
});

Given("I do a get status request", () => {
    cy.request({
        method: 'GET',
        url: 'https://simple-books-api.glitch.me/status',

    }).then((response) => {
        expect(response.status).equal(200);
        cy.log(response.body);

    });

});

Given("I request for all orders", () => {
    cy.request({
        method: 'GET',
        url: 'https://simple-books-api.glitch.me/orders',
        headers: {
            Authorization: "Bearer " + accessToken
        }
    }).then((response) => {
        expect(response.status).equal(200);
        cy.log(JSON.stringify(response.body));
    });
});

Given("I post a new book order", () => {
    cy.request({
        method: 'POST',
        url: 'https://simple-books-api.glitch.me/orders',
        headers: {
            Authorization: "Bearer " + accessToken
        },
        body: {
            "bookId": 1,
            "customerName": Math.random().toString(5).substring(2)
        }
    }).then((response) => {
        expect(response.status).equal(201)
        cy.log(accessToken)
    });
});