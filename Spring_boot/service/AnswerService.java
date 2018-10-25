package com.happyapp.service;

import com.happyapp.dao.AnswerDao;

public class AnswerService {

    private AnswerDao answerDao = new AnswerDao();


    public String getAnswerById(int id) {

        return this.answerDao.getAnswerById(id);
    }

    public void insertAnswer(int employee, int question, String value) {

        this.answerDao.insertAnswer(employee, question, value);
    }

}
