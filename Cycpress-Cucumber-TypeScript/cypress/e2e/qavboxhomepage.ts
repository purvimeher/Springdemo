import { When, Then } from "@badeball/cypress-cucumber-preprocessor";

When(/^I load qavbox home page$/, () => {
    cy.visit("https://qavbox.github.io/demo/");
});

Then(/^I should see a valid title$/, () => {
    cy.title().should('eq', 'QAVBOX Demo');

});

When(/^I click on link "([^"]*)"$/, (linkText) => {


    cy.get('#form1').as('mainForm');
    cy.get('@mainForm').find('.container').as('mainContainer');

    cy.get('@mainContainer').find('ul li').should('have.length', 10);

    cy.get('.myhmenu a').each(($txt) => {
        if ($txt.text() == linkText) {
            cy.wrap($txt).click();
        }
    })
});

When(/^I fill up signup details$/, () => {
    // cy.fixture("signupdetails").as('signupDetails').then((signupDetails) => {
    //     cy.get('#username').type(signupDetails.firstName);
    //     cy.get('#email').type(signupDetails.email);
    //     cy.get('#tel').type(signupDetails.telephone);
    //     cy.get('select[name="sgender"]').select(signupDetails.gender);
    //     cy.get('input[name="experience"]').check(signupDetails.experience);
    //     cy.get('input[name="language"]').check([signupDetails.language]);

    //     cy.get('#tools').select(signupDetails.options);
    //     cy.get('input[value="Home"]').scrollIntoView();
    // })

    cy.fixture("signupdetails").then((testData) => {
        cy.get('#username').type(testData.firstName);

        cy.get('select[name="sgender"]').select('na');

        cy.get('input[name="experience"]').check('five');

        cy.get('input[name="language"]').check("manualtesting");
        cy.get('#tools').select(["Selenium", "Docker"]);

        cy.get('input[value="Home"]').scrollIntoView();

        cy.get('input[value="Home"]').rightclick();

        cy.get('#submit').click();

        cy.on('window:alert', (txt) => {
            //Assertion
            expect(txt).to.contains('Registration Done!');
        });
    })
});

When(/^I drag and drop with draggable into droppable$/, () => {
    const dataTransfer = new DataTransfer();
    cy.get('#draggable').trigger("mousedown", {
        which: 1
    });

    cy.get('#droppable')
        .trigger("mousemove")
        .trigger("mouseup", { force: true });
});


When(/^I change the slider position to "([^"]*)"$/, (position) => {
    cy.get('input[type=range]').as('range').invoke('val', position).trigger('change');
});

Then(/^slider range displayed should be "([^"]*)"$/, (position) => {
    cy.get('#range').then(($el) => {
        cy.wrap($el).invoke('text').should('eq', position);
    })
});

When(/^I go back to HomePage$/, () => {
    cy.get('input[value="Home"]').click();
});


When(/^I interact with webtable "([^"]*)"$/, (value) => {
    cy.get('#table01 tbody').within(() => {
        cy.get('tr').should('have.length', 3);
        cy.get('tr').each(($row) => {
            cy.wrap($row).find('td:nth-child(2)').invoke('text').then((text) => {

                if (text == value) {
                    cy.wrap($row).find('td:nth-child(1)  input').check();
                    cy.wrap($row).find('td:nth-child(5)').click()
                }

            });
        });
    });
});

When(/^I interact with different alerts$/, () => {
    cy.get('#confirm').click()
    cy.on('window:alert', (txt) => {
        //Assertion
        expect(txt).to.contains('I appeared after 5 seconds!!');
    });
});