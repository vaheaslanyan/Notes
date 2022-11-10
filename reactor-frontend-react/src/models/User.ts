export class User {
    userId: number;
    email: string;
    firstName: string;
    lastName: string;

    constructor(userId = -1, email = '', firstName = '', lastName = '') {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}