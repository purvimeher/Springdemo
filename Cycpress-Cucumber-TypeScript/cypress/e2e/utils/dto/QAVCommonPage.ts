class QAVCommonPage{

    private QAVCommonPageElements={
        homePageBtn:()=>cy.get('input[value="Home"]')     
    }

    clickHomePage():void{
        this.QAVCommonPageElements.homePageBtn().click();
    }

    visitPage(url){
        cy.visit("/demo/").debug({log:true});
        cy.hash({log:false});
        cy.clearAllCookies();
        cy.location().then((loc)=>{
            cy.log(loc.pathname);
        });
        //TO pause and debug 
        // cy.pause();
    }
}

export default QAVCommonPage