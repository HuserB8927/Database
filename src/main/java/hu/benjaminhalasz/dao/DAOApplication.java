package hu.benjaminhalasz.dao;


import hu.benjaminhalasz.model.Application;
import hu.benjaminhalasz.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benjaminhalasz
 */
public class DAOApplication {

EntityManagerFactory emf;
    EntityManager em;
    Application a;
    Person p;
    
    
    public DAOApplication() { //Default constructor
        emf = Persistence.createEntityManagerFactory("VisaApplicationProgramPU"); //Instance of entityManagerFactory
        em = emf.createEntityManager(); //Instance of entityManager
    }
    public DAOApplication(Application a, Person p) {
        emf = Persistence.createEntityManagerFactory("VisaApplicationProgramPU");
        em = emf.createEntityManager();
        this.a = a;
        this.p = p;
    }
    public void insert(Application a) { //creating new record. 
        em.getTransaction().begin(); //When a user fills up a form we will each other fields to an instance of the Person table
        em.persist(a); //then we persist it
        em.getTransaction().commit(); //and create a new row
    }
    public void delete(Application a) {//The form fill pass a Person object with those values either to update or delete method here
        em.getTransaction().begin(); 
        Application application = findById(a.getId());
        em.remove(application);
        em.getTransaction().commit(); 
    }
    public Application findById(int id) { //when the user clicks on a row in the Person table we will need to find that record and display its properties
        Application a = em.find(Application.class, id);
        return a;
        //then we have to options: delete or update
    }
    public void close() {
        em.close();
        emf.close();
    }
    
}