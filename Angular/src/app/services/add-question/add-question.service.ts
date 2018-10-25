import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Question } from '../../entities/question';


@Injectable()
export class AddQuestionService {

  url: string = 'http://localhost:8080/happy-app/employers/1/add-question/';

  constructor(private http: HttpClient) {

  }

  // POST
  
  getQuestions(): Observable<Question[]> {

    return this.http.get(this.url).map((res: Question[]) => res);
  }
}
