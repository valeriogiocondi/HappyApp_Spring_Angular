package com.happyapp.dao;

import com.happyapp.Model.EmployeesEntity;
import com.happyapp.Model.EmployersEntity;
import com.happyapp.Model.QuestionsEntity;
import com.happyapp.dao.obj_response.QuestionsResponse;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.happyapp.util.HibernateUtility.*;
import static com.happyapp.util.JsonUtility.getJSON;

public class EmployerDao {

    public String getEmployerById(int id) {

        /*
         *   GET EMPLOYER BY $id
         */


        return readDataSimple(EmployersEntity.class, new EmployersEntity(), id);
    }

    public String getEmployerCompany(int id) {

        /*
         *   GET COMPANY
         */

        return readDataJoin("SELECT DISTINCT E2 FROM EmployersEntity E1, CompaniesEntity E2 WHERE E1.id = ?0 AND E2.id = E1.company", id);
    }

    public String getEmployerQuestions(int id) {

        /*
         *   GET QUESTIONS
         */

        Session session;
        List<Object> resultQuestions;
        List resultEmployer;
        ArrayList<QuestionsResponse> questionsResponse;
        Iterator itr;

        session = getSession();
        questionsResponse = new ArrayList<QuestionsResponse>();

        try {

            Query queryHQL;
            queryHQL = session.createQuery("SELECT DISTINCT E1.id, E1.text, COUNT(E2.id) FROM QuestionsEntity E1, AnswersEntity E2 WHERE E1.employer = ?1 AND E1.id = E2.question GROUP BY E1.id ORDER BY E1.id");
            queryHQL.setParameter(1, id);
            resultQuestions = (List<Object>) queryHQL.list();

            queryHQL = session.createQuery("SELECT COUNT(E1.id) FROM EmployeesEntity E1 WHERE E1.employer = ?1");
            queryHQL.setParameter(1, id);
            resultEmployer = queryHQL.getResultList();

            itr = resultQuestions.iterator();
            while(itr.hasNext()){

                Object[] obj = (Object[]) itr.next();
                questionsResponse.add(new QuestionsResponse((int)obj[0], String.valueOf(obj[1]), (Long)obj[2], (Long)resultEmployer.get(0)));
            }

//                session.flush();
//                session.getTransaction().commit();
            return  getJSON(questionsResponse);

        } catch (HibernateException e) {

            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return "error";
    }

    public String getEmployerEmployees(int id) {

        /*
         *   GET EMPLOYEES
         */

        Session session;
        List<Object> employeesHibernate;
        ArrayList<EmployeesEntity> resultEmployees;
        Iterator itr;

        session = getSession();
        resultEmployees = new ArrayList<EmployeesEntity>();

        try {

            Query queryHQL;
            queryHQL = session.createQuery("SELECT E.id, E.firstName, E.lastName, E.email FROM EmployeesEntity E WHERE E.employer = ?1");
            queryHQL.setParameter(1, id);
            employeesHibernate = (List<Object>) queryHQL.list();

            itr = employeesHibernate.iterator();
            while(itr.hasNext()){

                Object[] obj = (Object[]) itr.next();
                resultEmployees.add(new EmployeesEntity((int)obj[0], String.valueOf(obj[1]),  String.valueOf(obj[2]),  String.valueOf(obj[3]))) ;
            }


//                session.flush();
//                session.getTransaction().commit();
            return  getJSON(resultEmployees);

        } catch (HibernateException e) {

            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return "error";

//        return readDataJoin("SELECT DISTINCT E2.id, E2.firstName, E2.lastName, E3.name,  E2.email FROM EmployersEntity E1, EmployeesEntity E2, CompaniesEntity E3 WHERE E1.id = ?0 AND E2.company = E1.company ORDER BY E2.id", id);
    }

    public String getEmployerAnswer(int id) {

        /*
         *   GET EPLOYEES ANSWERS
         */

//        return readDataJoin("SELECT DISTINCT E1 FROM AnswersEntity E1 WHERE E1.employer = ?0", id);
        return "";
    }

    public void insertQuestion(int employer, String text) {

        /*
         *  INSERT QUESTION
         */

        QuestionsEntity question;
        Session session = getSession();

        try {
            question = new QuestionsEntity();
            question.setEmployer(employer);
            question.setText(text);

            session.beginTransaction();
            session.save(question);
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
