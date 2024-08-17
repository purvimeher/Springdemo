import QAVCommonPage from "./QAVCommonPage";

class QAVWebTablePage extends QAVCommonPage{

    private QAVWebTablePageElements={
        table_one:() => cy.get('#table01 tbody')
    }

    InteractWithTable(searchText){
        this.QAVWebTablePageElements.table_one().within(() => {
            cy.get('tr').should('have.length', 3);
            cy.get('tr').each(($row) => {
                cy.wrap($row).find('td:nth-child(2)').invoke('text').then((text) => {
    
                    if (text == searchText) {
                        cy.wrap($row).find('td:nth-child(1)  input').check();
                        cy.wrap($row).find('td:nth-child(5)').click()
                    }
                });
            });
        });
    }
}

export default QAVWebTablePage