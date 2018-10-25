import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Question } from '../../entities/question';


@Injectable()
export class GetQuestionsService {

  url: string = 'http://localhost:8080/happy-app/employers/1/questions';

  constructor(private http: HttpClient) {

  }

  getQuestions(): Observable<Question[]> {

    return this.http.get(this.url).map((res: Question[]) => res);
  }
}
