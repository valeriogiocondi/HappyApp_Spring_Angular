package com.happyapp.service;

import com.happyapp.dao.EmployeeDao;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();


    public String getEmployeeById(int id) {

        return this.employeeDao.getEmployeeById(id);
    }

    public String getEmployeeCompany(int id) {

        return this.employeeDao.getEmployeeCompany(id);
    }

    public String getEmployeeQuestions(int id) {

        return this.employeeDao.getEmployeeQuestions(id);
    }

    public String getEmployeeAnswer(int id) {

        return this.employeeDao.getEmployeeAnswer(id);
    }
}
