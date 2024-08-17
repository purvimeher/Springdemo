class QAVIFramesPage {
    private QAVIFramesPageElements = {
        inputBoxFromOuterFrame: () => cy.get('#input1'),
        pTextFromInnerFirstFrame: '#frametext',
        inputBoxFromInnerSecondFrame: '#frameinput',
        firstIFrame: ()=> cy.get('#Frame1').its('0.contentDocument'),
        secondIFrame: ()=> cy.get('#Frame2').its('0.contentDocument'),
    }

    enterTextInOuterFrameInputBox(value: string) {
        this
        this.QAVIFramesPageElements.inputBoxFromOuterFrame().type(value);
    }

    enterTextInInsideFrameInputBox(value: string) {
        this.QAVIFramesPageElements.secondIFrame()
        .find(this.QAVIFramesPageElements.inputBoxFromInnerSecondFrame).type(value);
    }

    verifyTextInInsideFrameInputBox(value: string) {
        this.QAVIFramesPageElements.firstIFrame()
        .find(this.QAVIFramesPageElements.pTextFromInnerFirstFrame).invoke('text').should('eq', value);
    }
}

export default QAVIFramesPage