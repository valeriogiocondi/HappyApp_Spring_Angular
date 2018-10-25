import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Employee } from '../../entities/employee';


@Injectable()
export class GetEmployeesService {

  url: string = 'http://localhost:8080/happy-app/employers/1/employees';

  constructor(private http: HttpClient) {

  }

  getEmployees(): Observable<Employee[]> {

    return this.http.get(this.url).map((res: Employee[]) => res);
  }
}
