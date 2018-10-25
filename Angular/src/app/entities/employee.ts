export class Employee {

	id: number;
	firstName: String;
	lastName: String;
	company: String;
	email: String;

	constructor(id, firstName, lastName, company, email) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.email = email;
	}
}