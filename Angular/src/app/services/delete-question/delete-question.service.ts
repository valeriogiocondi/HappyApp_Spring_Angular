import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Question } from '../../entities/question';


@Injectable()
export class DeleteQuestionService {

  url: string = 'http://localhost:8080/happy-app/questions/1';

  constructor(private http: HttpClient) {

  }

	// DELETE

  getQuestions(): Observable<Question[]> {

    return this.http.get(this.url).map((res: Question[]) => res);
  }
}
