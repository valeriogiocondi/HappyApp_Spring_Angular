package com.happyapp.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Answers", schema = "happyapp_db", catalog = "")
public class AnswersEntity {
    private int id;
    private Integer question;
    private Integer employee;
    private Integer response;
    private String comment;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "question")
    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    @Basic
    @Column(name = "employee")
    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "response")
    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswersEntity that = (AnswersEntity) o;
        return id == that.id && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, response);
    }
}
