export class Question {

	id: number;
	text: String;
	numAnswers: number;
	totEmployers: number;

	constructor(id, text, numAnswers, totEmployers) {

		this.id = id;
		this.text = text;
		this.numAnswers = numAnswers;
		this.totEmployers = totEmployers;
	}
}