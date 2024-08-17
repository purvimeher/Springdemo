import QAVCommonPage from "./QAVCommonPage";

class QAVAlertsPage extends QAVCommonPage {

    private QAVAlertsPageElements = {
        confirmsBtn: () => cy.get('#confirm')

    }

    ClickOnConfirmBtn() {
        this.QAVAlertsPageElements.confirmsBtn().click()
        cy.on('window:alert', (txt) => {
            //Assertion
            expect(txt).to.contains('I appeared after 5 seconds!!');
        });
    }

}

export default QAVAlertsPage