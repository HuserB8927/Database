/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.benjaminhalasz.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author benjaminhalasz
 */
@Entity
@SequenceGenerator(name="visa", initialValue=10)
@Table(name = "person")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id")
    , @NamedQuery(name = "Person.findByFamilyName", query = "SELECT p FROM Person p WHERE p.familyName = :familyName")
    , @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone")
    , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email")
    , @NamedQuery(name = "Person.findByCountry", query = "SELECT p FROM Person p WHERE p.country = :country")
    , @NamedQuery(name = "Person.findByDestination", query = "SELECT p FROM Person p WHERE p.destination = :destination")
    , @NamedQuery(name = "Person.findByDateOfLeaving", query = "SELECT p FROM Person p WHERE p.dateOfLeaving = :dateOfLeaving")
    , @NamedQuery(name = "Person.findByForHowLong", query = "SELECT p FROM Person p WHERE p.forHowLong = :forHowLong")})
public class Person implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @OneToMany(
       mappedBy = "Person",
       cascade = CascadeType.ALL,
       orphanRemoval = true
   )
private List<Application> applications = new ArrayList<>();
    
    

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "familyName")
    private String familyName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "country")
    private String country;
    @Column(name = "destination")
    private String destination;
    @Column(name = "dateOfLeaving")
    private String dateOfLeaving;
    @Column(name = "forHowLong")
    private String forHowLong;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        String oldFamilyName = this.familyName;
        this.familyName = familyName;
        changeSupport.firePropertyChange("familyName", oldFamilyName, familyName);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        changeSupport.firePropertyChange("surname", oldSurname, surname);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        changeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        String oldDestination = this.destination;
        this.destination = destination;
        changeSupport.firePropertyChange("destination", oldDestination, destination);
    }

    public String getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(String dateOfLeaving) {
        String oldDateOfLeaving = this.dateOfLeaving;
        this.dateOfLeaving = dateOfLeaving;
        changeSupport.firePropertyChange("dateOfLeaving", oldDateOfLeaving, dateOfLeaving);
    }

    public String getForHowLong() {
        return forHowLong;
    }

    public void setForHowLong(String forHowLong) {
        String oldForHowLong = this.forHowLong;
        this.forHowLong = forHowLong;
        changeSupport.firePropertyChange("forHowLong", oldForHowLong, forHowLong);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.benjaminhalasz.model.Person[ id=" + id + " ]";
    }

//    @XmlTransient
//    public List<Application> getApplication() {
//        return applications;
//    }

    public void setApplication(List<Application> applications) {
        this.applications = applications;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
}
