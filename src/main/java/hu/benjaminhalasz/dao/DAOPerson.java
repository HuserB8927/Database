/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.benjaminhalasz.dao;

import hu.benjaminhalasz.model.Application;
import hu.benjaminhalasz.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author benjaminhalasz
 */
public class DAOPerson {
    EntityManagerFactory emf;
    EntityManager em;
    Person p;
    Application a;
    
    public DAOPerson() { //Default constructor
        emf = Persistence.createEntityManagerFactory("VisaApplicationProgramPU"); //Instance of entityManagerFactory
        em = emf.createEntityManager(); //Instance of entityManager
    }
    public DAOPerson(Person p, Application a) {
        emf = Persistence.createEntityManagerFactory("VisaApplicationProgramPU");
        em = emf.createEntityManager();
        this.p = p;
        this.a = a;
    }
    public void close() {
        em.close();
        emf.close();
    }
    public void insert(Person p, Application a) { //creating new record. 
        em.getTransaction().begin(); //When a user fills up a form we will each other fields to an instance of the Person table
        em.persist(p); //then we persist it
        em.persist(a);
        em.getTransaction().commit(); //and create a new row
    }
    public Person findById(int id) { //when the user clicks on a row in the Person table we will need to find that record and display its properties
        Person p = em.find(Person.class, id);
     
        return p;
        //then we have to options: delete or update
    }
    public void delete(Person p) {//The form fill pass a Person object with those values either to update or delete method here
        em.getTransaction().begin(); 
        
        Person person = findById(p.getId());
        em.remove(person); 
        em.getTransaction().commit(); 
    }
    public void update(Person p) {
        Person person = em.find(Person.class, p.getId());
        em.getTransaction().begin();
        person.setFamilyName(p.getFamilyName());
        person.setSurname(p.getSurname());
        person.setEmail(p.getEmail());
        person.setPhone(p.getPhone());
        person.setCountry(p.getCountry());
        person.setDestination(p.getDestination());
        person.setDateOfLeaving(p.getDateOfLeaving());
        person.setForHowLong(p.getForHowLong());
        em.getTransaction().commit();
    
}
}