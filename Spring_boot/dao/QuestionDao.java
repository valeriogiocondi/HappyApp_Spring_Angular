package com.happyapp.dao;

import com.happyapp.Model.QuestionsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static com.happyapp.util.HibernateUtility.*;

public class QuestionDao {

    public String getQuestionById(int id) {

        /*
         *   GET QUESTION BY $id
         */

        return readDataSimple(QuestionsEntity.class, new QuestionsEntity(), id);
    }

//    NON DISPONIBILE => NON PERMESSO
//
//   public void updateQuestion(int id, String value) {
//
//        /*
//         *  UPDATE QUESTION
//         */
//
//        updateData("UPDATE QuestionsEntity SET text = ?1 WHERE id = ?0", id, value);
//    }

    public void deleteQuestion(int id) {

        /*
         *   DELETE QUESTION
         */

        deleteData(id);

        // Cancellare anche le risposte, altrimenti non ha senso
    }
}
