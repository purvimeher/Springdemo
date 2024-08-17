import QAVCommonPage from "./QAVCommonPage";

class QAVAutoSuggestionsPage extends QAVCommonPage{

    private QAVAutoSuggestionsPageElements={
        inputBox:()=> cy.get('#myInput')
    }

    InteractWithInputBox(value:string){
        this.QAVAutoSuggestionsPageElements.inputBox()
        // .pause()
        .type(value)
        // .pause()
        .type('{downarrow}')
        // .pause()
        .type('{enter}');
    }

}

export default QAVAutoSuggestionsPage