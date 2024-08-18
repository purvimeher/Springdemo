class SignInDetails {

    public firstName: string;
    public email: string;
    public telephone: string;
    public gender: string;
    public experience: string;
    public language: string;
    public options: string[];


    public getFirstName(): string {
        return this.firstName;
    }

    public getEmail(): string {
        return this.email;
    }

    public getTelephone(): string {
        return this.telephone;
    }

    public getGender(): string {
        return this.gender;
    }

    public getExperience(): string {
        return this.experience;
    }

    public getLanguage(): string {
        return this.language;
    }

    public getOptions(): string[] {
        return this.options;
    }
}

export default SignInDetails