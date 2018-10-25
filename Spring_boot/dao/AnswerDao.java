package com.happyapp.dao;

import com.happyapp.Model.AnswersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static com.happyapp.util.HibernateUtility.getSession;
import static com.happyapp.util.HibernateUtility.readDataSimple;

public class AnswerDao {

    public String getAnswerById(int id) {

        /*
         *   GET ANSWER BY $id
         */

        return readDataSimple(AnswersEntity.class, new AnswersEntity(), id);
    }

    public void insertAnswer(int employee, int question, String text) {

        /*
         *  INSERT ANSWER
         */

        AnswersEntity answer;
        Session session = getSession();

        try {
            answer = new AnswersEntity();
            answer.setEmployee(employee);
            answer.setQuestion(question);
            answer.setComment(text);

            session.beginTransaction();
            session.save(answer);
            session.getTransaction().commit();

        } catch (HibernateException e) {

            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {

            session.close();
        }
    }
}
