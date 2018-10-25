import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { QuestionsComponent } from './components/questions/questions.component';
import { QuestionComponent } from './components/question/question.component';
import { AddQuestionComponent } from './components/add-question/add-question.component';
import { EmployeesComponent } from './components/employees/employees.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
	{
		path: '',
		component: HomeComponent
	},
	{
		path: 'questions',
		component: QuestionsComponent
	},
	{
		path: 'questions/:id',
		component: QuestionComponent
	},
	{
		path: 'add-question',
		component: AddQuestionComponent
	},
	{
		path: 'employees',
		component: EmployeesComponent
	},
	{
		path: 'employees/:id',
		component: EmployeeComponent
	},
	{
		path: 'login',
		component: LoginComponent
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
