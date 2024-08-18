import QAVCommonPage from "./QAVCommonPage";

class QAVHomePage extends QAVCommonPage{

    private QAVHomePageElements = {
        mainfFormBtns: () => cy.get('fieldset').filter('#regform').find('.myhmenu a',{log :true})
        //another way to get hold of buttons
        // mainfFormBtns: () => cy.get('.myhmenu').children('li').children('b').children('a')
    }

    clickOnLink(linkText) {
        // cy.once('uncaught:exception', () => false )

        this.QAVHomePageElements.mainfFormBtns().each(($txt) => {
            if ($txt.text() == linkText) {
                cy.wrap($txt).click();
            }
        })
    }

    checkNoOfButtons():void{
    this.QAVHomePageElements.mainfFormBtns().should('have.length', 10);
    }

    verifyAllTenButtonsExistsInOrder(){
        this.QAVHomePageElements.mainfFormBtns().spread(($btn1,$btn2,$btn3,$btn4,$btn5,$btn6,$btn7,$btn8,$btn9,$btn10)=>{
            cy.wrap($btn1).invoke('text').should('eq','SignUp Form');
            cy.wrap($btn2).invoke('text').should('eq','WebTable');
            cy.wrap($btn3).invoke('text').should('eq','List Items');
            cy.wrap($btn4).invoke('text').should('eq','iFrames');
            cy.wrap($btn5).invoke('text').should('eq','Alerts');
            cy.wrap($btn6).invoke('text').should('eq','Links');
            cy.wrap($btn7).invoke('text').should('eq','DragnDrop');
            cy.wrap($btn8).invoke('text').should('eq','Delay');
            cy.wrap($btn9).invoke('text').should('eq','Shadow DOM');
            cy.wrap($btn10).invoke('text').should('eq','Auto Suggestions');
        })
    }
}

export default QAVHomePage