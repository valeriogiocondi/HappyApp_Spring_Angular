import { Component, OnInit } from '@angular/core';

import { GetEmployeesService } from '../../services/get-employees/get-employees.service';
import { Employee } from '../../entities/employee';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.less']
})

export class EmployeesComponent implements OnInit {

  employees: Employee[] = [];

  constructor(private getEmployees: GetEmployeesService){
    
  }

  ngOnInit() {

    this.getQuestions();
  }

  getQuestions(): void {

    this.getEmployees.getEmployees()
      .subscribe((value: Employee[]) => {

        value.map(item => {

          var object = new Employee(item.id, item.firstName, item.lastName, item.company, item.email);
          this.employees.push(object);
        });
      });
  }
}
