/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.customer;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "LICENSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "License.findAll", query = "SELECT license FROM License license"),
    @NamedQuery(name = "License.findByCustomer", query = "SELECT license FROM License license WHERE license.licensePK.customer = :customer"),
    @NamedQuery(name = "License.findByLicense", query = "SELECT license FROM License license WHERE license.licensePK.license = :license")})
public class License implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The license pk. */
    @EmbeddedId
    protected LicensePK licensePK;
    
    /** The customer. */
    @JoinColumn(name = "customer", referencedColumnName = "customerID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    /**
     * Instantiates a new license.
     */
    public License() {
    }

    /**
     * Instantiates a new license.
     *
     * @param licensePK the license pk
     */
    public License(LicensePK licensePK) {
        this.licensePK = licensePK;
    }

    /**
     * Instantiates a new license.
     *
     * @param customer the customer
     * @param license the license
     */
    public License(int customer, String license) {
        this.licensePK = new LicensePK(customer, license);
    }

    /**
     * Gets the license pk.
     *
     * @return the license pk
     */
    public LicensePK getLicensePK() {
        return licensePK;
    }

    /**
     * Sets the license pk.
     *
     * @param licensePK the new license pk
     */
    public void setLicensePK(LicensePK licensePK) {
        this.licensePK = licensePK;
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer.
     *
     * @param customers the new customer
     */
    public void setCustomer(Customer customers) {
        this.customer = customers;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licensePK != null ? licensePK.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof License)) {
            return false;
        }
        License other = (License) object;
        if ((this.licensePK == null && other.licensePK != null) || (this.licensePK != null && !this.licensePK.equals(other.licensePK))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.License[ licensePK=" + licensePK + " ]";
    }
    
}
