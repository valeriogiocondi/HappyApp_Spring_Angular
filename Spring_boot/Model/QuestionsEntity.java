package com.happyapp.Model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "Questions", schema = "happyapp_db", catalog = "")
public class QuestionsEntity {
    private int id;
    private int employer;
    private String text;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "employer")
    public int getEmployer() {
        return employer;
    }

    public void setEmployer(int employer) {
        this.employer = employer;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
