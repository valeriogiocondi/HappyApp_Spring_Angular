package com.happyapp.dao;

import com.happyapp.Model.EmployeesEntity;

import static com.happyapp.util.HibernateUtility.*;

public class EmployeeDao {

    public String getEmployeeById(int id) {

        /*
         *   GET EMPLOYEE BY $id
         */

        return readDataSimple(EmployeesEntity.class, new EmployeesEntity(), id);
    }

    public String getEmployeeCompany(int id) {

        /*
         *   GET COMPANY
         */

        return readDataJoin("SELECT DISTINCT E2 FROM EmployeesEntity E1, CompaniesEntity E2 WHERE E1.id = ?0 AND E2.id = E1.company", id);
    }

    public String getEmployeeQuestions(int id) {

        /*
         *   GET QUESTIONS
         */

//        return readDataJoin("SELECT DISTINCT E2 FROM EmployeesEntity E1, QuestionsEntity E2 WHERE E1.id = ?0 AND E2.employer = E1.company ORDER BY E2.id", id);
        return "";
    }

    public String getEmployeeAnswer(int id) {

        /*
         *   GET ANSWERS
         */

        return readDataJoin("SELECT DISTINCT E1 FROM AnswersEntity E1 WHERE E1.employee = ?0", id);
    }
}
