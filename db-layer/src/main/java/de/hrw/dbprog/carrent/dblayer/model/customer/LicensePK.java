/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.customer;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@SuppressWarnings("serial")
@Embeddable
public class LicensePK implements Serializable {

    /** The customer. */
    @Basic(optional = false)
    @Column(name = "customer")
    private int customer;
    
    /** The license. */
    @Basic(optional = false)
    @Column(name = "license")
    private String license;

    /**
     * Instantiates a new license pk.
     */
    public LicensePK() {
    }

    /**
     * Instantiates a new license pk.
     *
     * @param customer the customer
     * @param license the license
     */
    public LicensePK(int customer, String license) {
        this.customer = customer;
        this.license = license;
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public int getCustomer() {
        return customer;
    }

    /**
     * Sets the customer.
     *
     * @param customer the new customer
     */
    public void setCustomer(int customer) {
        this.customer = customer;
    }

    /**
     * Gets the license.
     *
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the license.
     *
     * @param license the new license
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customer;
        hash += (license != null ? license.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LicensePK)) {
            return false;
        }
        LicensePK other = (LicensePK) object;
        if (this.customer != other.customer) {
            return false;
        }
        if ((this.license == null && other.license != null) || (this.license != null && !this.license.equals(other.license))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.LicensesPK[ customer=" + customer + ", license=" + license + " ]";
    }
    
}
