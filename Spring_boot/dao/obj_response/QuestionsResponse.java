package com.happyapp.dao.obj_response;

public class QuestionsResponse {

    public int id;
    public String text;
    public Long numAnswers;
    public Long totEmployers;

    public QuestionsResponse(int id, String text, Long numAnswers, Long totEmployers) {

        this.id = id;
        this.text = text;
        this.numAnswers = numAnswers;
        this.totEmployers = totEmployers;
    }
}
