/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.benjaminhalasz.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benjaminhalasz
 */
@Entity
@Table(name = "application")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
    , @NamedQuery(name = "Application.findById", query = "SELECT a FROM Application a WHERE a.id = :id")
    , @NamedQuery(name = "Application.findByHasEmailSent", query = "SELECT a FROM Application a WHERE a.hasEmailSent = :hasEmailSent")})
public class Application implements Serializable {

    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hasEmailSent")
    private Short hasEmailSent;
    
    
    
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "personId")

private Person person;

    public Application() {
    }

    public Application(Integer id) {
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

    public Short getHasEmailSent() {
        return hasEmailSent;
    }

    public void setHasEmailSent(Short hasEmailSent) {
        Short oldHasEmailSent = this.hasEmailSent;
        this.hasEmailSent = hasEmailSent;
        changeSupport.firePropertyChange("hasEmailSent", oldHasEmailSent, hasEmailSent);
    }

    public Person getPersonId() {
        return person;
    }

    public void setPersonId(Person person) {
        Person oldPersonId = this.person;
        this.person = person;
        changeSupport.firePropertyChange("personId", oldPersonId, person);
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
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.benjaminhalasz.model.Application[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
