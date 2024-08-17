import QAVCommonPage from "./QAVCommonPage";

class QAVDragAndDropPage extends QAVCommonPage {

    private QAVDragAndDropPageElements = {
        draggable: () => cy.get('#draggable'),
        droppable: () => cy.get('#droppable'),
        slider: () => cy.get('input[type=range]'),
        spanSliderText:()=> cy.get('span[id=range]')
    }

    DragAndDropWithDraggablIntoDroppable() {
        const dataTransfer = new DataTransfer();
        this.QAVDragAndDropPageElements.draggable().trigger("mousedown", {
            which: 1
        });

        this.QAVDragAndDropPageElements.droppable()
            .trigger("mousemove")
            .trigger("mouseup", { force: true });
    }

    ChangeTheSliderPositionTo(position: number) {
        this.QAVDragAndDropPageElements.slider().invoke('val', position).trigger('change');
    }

    verifySliderPostionText(position) {
        this.QAVDragAndDropPageElements.spanSliderText().then(($el) => {
            cy.wrap($el).invoke('text').should('eq', position);
        });
    }
}

export default QAVDragAndDropPage