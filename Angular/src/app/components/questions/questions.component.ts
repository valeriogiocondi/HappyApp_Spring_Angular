import { Component, OnInit } from '@angular/core';

import { GetQuestionsService } from '../../services/get-questions/get-questions.service';
import { Question } from '../../entities/question';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.less']
})

export class QuestionsComponent implements OnInit {

  questions: Question[] = [];

  constructor(private questionsService: GetQuestionsService){
    
  }

  ngOnInit() {

    this.getQuestions();
  }

  getQuestions(): void {

    this.questionsService.getQuestions()
      .subscribe((value: Question[]) => {

        value.map(item => {

          var object = new Question(item.id, item.text, item.numAnswers, item.totEmployers);
          this.questions.push(object);
        });
      });
  }
}
