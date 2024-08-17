import QAVCommonPage from "./QAVCommonPage";

class QAVLinksPage extends QAVCommonPage{

    private QAVLinksPageElements={
        formButtons :()=> cy.get('form input[type="button"]')
    }

    verifyAllButtonsArePresent(noOfButton: number){
        this.QAVLinksPageElements.formButtons().should('have.length', noOfButton)
    }

    clickOnSpecificButton(buttonName:string){
        this.QAVLinksPageElements.formButtons().each(($btn)=>{
            if($btn.text() == buttonName){
                cy.wrap($btn).click();
            }
        })
    }
}

export default QAVLinksPage