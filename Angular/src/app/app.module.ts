import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router'

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { QuestionsComponent } from './components/questions/questions.component';
import { EmployeesComponent } from './components/employees/employees.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { QuestionComponent } from './components/question/question.component';
import { LoginComponent } from './components/login/login.component';
import { AddQuestionComponent } from './components/add-question/add-question.component';

import { GetQuestionsService } from './services/get-questions/get-questions.service';
import { AddQuestionService } from './services/add-question/add-question.service';
import { GetEmployeesService } from './services/get-employees/get-employees.service';
import { DeleteQuestionService } from './services/delete-question/delete-question.service';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    QuestionsComponent,
    EmployeesComponent,
    EmployeeComponent,
    QuestionComponent,
    LoginComponent,
    AddQuestionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    GetQuestionsService, 
    AddQuestionService, 
    GetEmployeesService, DeleteQuestionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
