import { Given, Then } from "@badeball/cypress-cucumber-preprocessor";

let responseVar;

Given("I do a get request", () => {
  cy.intercept('GET', '/api/users', {
    statusCode: 200,
    body: [
      {
        id: 1,
        name: 'John Doe',
        email: 'john.doe@example.com',
      },
      {
        id: 2,
        name: 'Jane Doe',
        email: 'jane.doe@example.com',
      },
    ],
  });

  cy.request({
    method: "GET",
    url: "/api/users"
  }).then((response) => {
    responseVar = response.status;
    cy.log(response.body);
  })
});

Then("status should be 200", () => {
  expect(responseVar).eql(200);
});
