package com.happyapp.service;

import com.happyapp.dao.EmployerDao;

public class EmployerService {

    private EmployerDao employerDao = new EmployerDao();


    public String getEmployerById(int id) {

        return this.employerDao.getEmployerById(id);
    }

    public String getEmployerCompany(int id) {

        return this.employerDao.getEmployerCompany(id);
    }

    public String getEmployerQuestions(int id) {

        return this.employerDao.getEmployerQuestions(id);
    }

    public String getEmployerEmployees(int id) {

        return this.employerDao.getEmployerEmployees(id);
    }

    public String getEmployerAnswer(int id) {

        return this.employerDao.getEmployerAnswer(id);
    }

    public void insertQuestion(int employer, String value) {

        this.employerDao.insertQuestion(employer, value);
    }
}
