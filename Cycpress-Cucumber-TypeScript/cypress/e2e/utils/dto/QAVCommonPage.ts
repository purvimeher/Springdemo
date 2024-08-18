class QAVCommonPage {

    private QAVCommonPageElements = {
        homePageBtn: () => cy.get('input[value="Home"]')
    }

    clickHomePage(): void {
        this.QAVCommonPageElements.homePageBtn().click();
    }

    visitPage(url) {
        cy.visit(url).debug({ log: true });
        cy.hash({ log: false });
        cy.getAllCookies().then((cookie)=>{
            cy.log(cookie.length.toString())
            cy.log(JSON.stringify(cookie[0]))
        });
        cy.clearAllCookies();
        cy.getAllCookies().then((cookie)=>{
            cy.log(cookie.length.toString())
            cy.log(JSON.stringify(cookie[0]))
        });
        cy.location({log:false}).then((loc) => {
            cy.log('Pathname : '+loc.pathname);
        });
        cy.url({log:false}).then((url) => {
            cy.log('Current active URL : ' + url)
        });
        //TO pause and debug 
        // cy.pause();
    }
}

export default QAVCommonPage