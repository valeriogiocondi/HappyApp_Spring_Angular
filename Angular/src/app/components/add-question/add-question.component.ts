import { Component, OnInit } from '@angular/core';

import { AddQuestionService } from '../../services/add-question/add-question.service';
import { Question } from '../../entities/question';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.less']
})

export class AddQuestionComponent implements OnInit {

	public show:boolean = false;
	public question:String = "";

  questions: Question[] = [];

  constructor(private questionService: AddQuestionService) { 

  }

  ngOnInit() {

  }

  onWrite(val : String) {  
	
		if (val.length > 0)
			this.show = true;
		else
			this.show = false;

		this.question = val;
	}

	sendQuestion() {/*

		alert(this.question);

    this.questionService.getQuestions()
      .subscribe((value: boolean) => {
        
        // if (boolean)
        //   alert("OK");


      // .subscribe((value: Question[]) => {

      //   value.map(item => {

      //     var object = new Question(item.id, item.text, item.numAnswers, item.totEmployers);
      //     this.questions.push(object);
      //   });
    });		*/
	}
}
