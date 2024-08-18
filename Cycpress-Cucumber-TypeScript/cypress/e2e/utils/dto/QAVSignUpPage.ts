import QAVCommonPage from "./QAVCommonPage";

export class QAVSignUpPage extends QAVCommonPage{

    private QAVSignUpPageElements = {
        usernameInput: () => cy.get('#username'),
        emailInput: () => cy.get('#email'),
        telephoneInput:()=>cy.get('#tel'),
        genderSelect:()=> cy.get('select[name="sgender"]'),
        experienceRadioBtn:()=>cy.get('input[name="experience"]'),
        languageCheckBx:()=>cy.get('input[name="language"]'),
        toolsMultiSelect:()=>cy.get('#tools'),
        fileInput: () => cy.get('input[name="datafile"]'),
        submitBtn: () => cy.get('#submit'),
        formElement:()=> cy.get('#form1')
    }

    enterUsername(username) {
        this.QAVSignUpPageElements.usernameInput().clear();
        this.QAVSignUpPageElements.usernameInput().type(username);
    }

    enterEmail(email) {
        this.QAVSignUpPageElements.emailInput().clear();
        this.QAVSignUpPageElements.emailInput().type(email);
    }

    enterTelephoneNo(telephone) {
        this.QAVSignUpPageElements.telephoneInput().clear();
        this.QAVSignUpPageElements.telephoneInput().type(telephone);
    }

    selectGender(gender: 'na' |'male'|'female') {
        this.QAVSignUpPageElements.genderSelect().select(gender);
    }

    selectExperience(exp:'one'|'two'|'three'|'four'|'five'|'six'|'seven'|'above seven') {
        this.QAVSignUpPageElements.experienceRadioBtn().check(exp);
    }

    selectSkills(...exp) {
        this.QAVSignUpPageElements.languageCheckBx().check(exp);
    }

    selectTools(tools) {
        this.QAVSignUpPageElements.toolsMultiSelect().select(tools);
    }

    clickSubmit() {
        this.QAVSignUpPageElements.submitBtn().click();
    }

    uploadFile(file: string[]) {
        this.QAVSignUpPageElements.fileInput().selectFile(file);
    }

    getFormElement():any{
        return this.QAVSignUpPageElements.formElement().submit();
    }
}