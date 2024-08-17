import { Given } from "@badeball/cypress-cucumber-preprocessor";

let accessToken;
Given("I do a get status request", () => {

    cy.request({
        method: "GET",
        url: "https://simple-books-api.glitch.me/status"
    }).then((response) => {
        cy.log(response.status.toString());
        cy.log(response.body);
        expect(response.status).eq(200)
    });

});

Given("I do a get orders request", () => {

    cy.request({
        method: "GET",
        url: "https://simple-books-api.glitch.me/orders",
        headers: {
            Authorization: 'Bearer ' + accessToken
        }
    }).then((response) => {
        cy.log(response.status.toString());
        cy.log( JSON.stringify(response.body));
        expect(response.status).eq(200)
    });
});

Given("I have a valid auth token", () => {

    cy.request({
        method: "POST",
        url: "https://simple-books-api.glitch.me/api-clients/",
        body: {
            "clientName": "Postman",
            "clientEmail": Math.random().toString(5).substring(2) + "@example.com"
        }
    }).then((response) => {
        expect(response.status).eq(201);
        accessToken = response.body.accessToken
        cy.log('ACCESS TOKEN IS :' + accessToken);
    })
});


Given("I post a new book order", () => {

    cy.request({
        method: "POST",
        url: "https://simple-books-api.glitch.me/orders/",
        headers: {
            Authorization: 'Bearer ' + accessToken
        },
        body: {
            "bookId": 1,
            "customerName": "John"
        }
    }).then((response) => {
        expect(response.status).eq(201);
    })
});

//
Given("I want to use query params", () => {

    cy.request({
        method: "GET",
        url: "https://restcountries.com/v3.1/name/aruba",
        qs:{
            fullText:true
        }
    }).then((response) => {
        expect(response.status).eq(200);
        cy.log( JSON.stringify(response.body));
    })
});