import QAVCommonPage from "./QAVCommonPage";

class QAVDelayPage extends QAVCommonPage {
    private QAVDelayPageElements = {
        formBtns: () => cy.get('#form1 input[type="button"]'),
        h2Text: () => cy.get('#two', { timeout: 6000 }),
        h2BottomText: () => cy.get('#delay', { timeout: 6000 }),
        h2Bottom2Text: () => cy.get('#loaderdelay', { timeout: 6000 })
    }

    clickButton(buttonText: 'Try me' | 'Click me' | 'Start') {
        this.QAVDelayPageElements.formBtns().each(($btnText) => {
            if (cy.wrap($btnText).invoke('attr', 'value').should('eq', buttonText + '!')) {
                cy.wrap($btnText).click();
                //breaking out of each loop
                return false;
            }
        });
    }

    verifyDelayedTextIsDisplayed(textPresent: 'Try me' | 'Click me' | 'Start') {
        switch (textPresent) {
            case 'Try me':
                this.QAVDelayPageElements.h2BottomText().should('be.visible', true);
                break;
            case 'Click me':
                this.QAVDelayPageElements.h2Text().should('be.visible', true);
                break;
            case 'Start':
                this.QAVDelayPageElements.h2Bottom2Text().should('be.visible', true);
                break;
        }
    }
}

export default QAVDelayPage