package com.happyapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.happyapp.Model.QuestionsEntity;
import com.happyapp.dao.obj_response.QuestionsResponse;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.happyapp.util.JsonUtility.getJSON;

public class HibernateUtility {

    @Autowired
    private static SessionFactory sessionFactory;

    public static Session getSession() {

        try {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        return sessionFactory.openSession();
    }

    public static String readDataSimple(Class classObj, Object istanceObj, int id) {

        Session session = getSession();

        try {

            istanceObj = session.get(classObj, id);
            return getJSON(istanceObj);

        } catch (HibernateException e) {

            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
        return "error";
    }


    /* return read1(new Callable<Void>() {
         public Void call() {

             Query queryHQL;
             queryHQL = session.createQuery("SELECT DISTINCT E1.id, E1.text, COUNT(E2.id) FROM QuestionsEntity E1, AnswersEntity E2 WHERE E1.employer = ?0 AND E1.id = E2.question GROUP BY E1.id ORDER BY E1.id");
             for (int i=0, n=parameters.length; i<n; i++)
                 queryHQL.setParameter(i, parameters[i]);
             resultList = queryHQL.list();

             return null;
         }
     }, id);*/

    public static <T> String read1(Callable<Void> callback, T... parameters) {

        Session session;
        List resultList;

        session = getSession();

        try {
            try {
                session.beginTransaction();

                Query queryHQL;
                queryHQL = session.createQuery("SELECT DISTINCT E1.id, E1.text, COUNT(E2.id) FROM QuestionsEntity E1, AnswersEntity E2 WHERE E1.employer = ?0 AND E1.id = E2.question GROUP BY E1.id ORDER BY E1.id");
                for (int i=0, n=parameters.length; i<n; i++)
                    queryHQL.setParameter(i, parameters[i]);
                resultList = queryHQL.list();

                session.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }

//            return getJSON(resultList);
            return  "";

        } catch (HibernateException e) {

            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return "error";
    }
    public static <T> String readDataJoin(String queryString,  T... parameters) {

        Session session;
        Query queryHQL;
        List resultList;
        QuestionsResponse questionsList;

        session = getSession();

        try {
            session.beginTransaction();

            queryHQL = session.createQuery(queryString);
            for (int i=0, n=parameters.length; i<n; i++)
                queryHQL.setParameter(i, parameters[i]);

            resultList = queryHQL.list();
            session.getTransaction().commit();
            return getJSON(resultList);

        } catch (HibernateException e) {

            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return "error";
    }

    public String readData(ArrayList<Class> classes, ArrayList<Object> istances, int id) {

        Transaction tx;
        Session session;
        ObjectMapper mapper;
        String resultJSON;

        tx = null;
        session = getSession();
        mapper = new ObjectMapper();
        resultJSON = "";

        try {
            tx = session.beginTransaction();

//            Criteria c = session.createCriteria(Class.class);
//            c.createAlias("dokument.role", "role"); // inner join by default
//            c.createAlias("role.contact", "contact");
//            c.add(Restrictions.eq("contact.lastName", "Test"));
//            return c.list();

            try {
                resultJSON = mapper.writeValueAsString(istances);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return resultJSON;
    }

    public static <T> String getData(String queryString, T... parameters) {

        Transaction tx;
        Session session;
        Query queryHQL;
        ObjectMapper mapper;
        String resultJSON;

        tx = null;
        session = getSession();
        mapper = new ObjectMapper();
        resultJSON = "";

        try {
            tx = session.beginTransaction();
            queryHQL = session.createQuery(queryString);
            for (int i=0, n=parameters.length; i<n; i++)
                queryHQL.setParameter(i, parameters[i]);
            List resultList = queryHQL.list();

            try {
                resultJSON = mapper.writeValueAsString(resultList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return resultJSON;
    }

    public static <T> void insertData(String tableName, ArrayList<String> columns, ArrayList values) {

        Transaction tx;
        Session session;
        Query queryHQL;
        String queryString;

        tx = null;
        session = getSession();
        queryString = "INSERT into "+tableName+" ";

        try {

            queryString += "(";

            for (String col : columns)
                queryString += col+", ";

            queryString += ")";
            queryString += " VALUES";
            queryString += "(";

            for (Object val : values)
                queryString += val+", ";

            queryString += ")";

            tx = session.beginTransaction();
            queryHQL = session.createQuery(queryString);

            //Add new Employee object
//            EmployeeEntity emp = new EmployeeEntity();
//            emp.setEmail("lokesh@mail.com");
//            emp.setFirstName("lokesh");
//            emp.setLastName("gupta");

            //Save the employee in database
//            session.save(emp);

//            for (int i=0, n=parameters.length; i<n; i++)
//                if (parameters[i].getClass().getName() == "java.lang.String")
//                    queryHQL.setParameter(i, parameters[i], StandardBasicTypes.STRING);
//                else
//                    queryHQL.setParameter(i, parameters[i]);

            queryHQL.executeUpdate();
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> void updateData(String queryString, T... parameters) {

        Transaction tx;
        Session session;
        Query queryHQL;

        tx = null;
        session = getSession();

        try {
            tx = session.beginTransaction();
            queryHQL = session.createQuery(queryString);
            for (int i=0, n=parameters.length; i<n; i++)
                if (parameters[i].getClass().getName() == "java.lang.String")
                    queryHQL.setParameter(i, parameters[i], StandardBasicTypes.STRING);
                else
                    queryHQL.setParameter(i, parameters[i]);
            queryHQL.executeUpdate();
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteData(int id) {

        Transaction tx;
        Session session;
        QuestionsEntity question;

        tx = null;
        session = getSession();
        question = session.get(QuestionsEntity.class, id);

        try {
            tx = session.beginTransaction();
            session.delete(question);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
