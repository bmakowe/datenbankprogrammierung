/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.reservation;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import de.hrw.dbprog.carrent.dblayer.model.car.Car;
import de.hrw.dbprog.carrent.dblayer.model.customer.Customer;

// TODO: Auto-generated Javadoc
/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "LOANCONTRACTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanContract.findAll", query = "SELECT loanContract FROM LoanContract loanContract"),
    @NamedQuery(name = "LoanContract.findByLoanContractID", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.loanContractID = :loanContractID"),
    @NamedQuery(name = "LoanContract.findByStartDate", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.startDate = :startDate"),
    @NamedQuery(name = "LoanContract.findByEndDate", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.endDate = :endDate"),
    @NamedQuery(name = "LoanContract.findByStartMileAge", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.startMileAge = :startMileAge"),
    @NamedQuery(name = "LoanContract.findByEndMileAge", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.endMileAge = :endMileAge"),
    @NamedQuery(name = "LoanContract.findByBillingAmount", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.billingAmount = :billingAmount"),
    @NamedQuery(name = "LoanContract.findByAlreadyPayed", query = "SELECT loanContract FROM LoanContract loanContract WHERE loanContract.alreadyPayed = :alreadyPayed")})
public class LoanContract implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /** The loan contract id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loanContractID")
    private Integer loanContractID;
    
    /** The start date. */
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    /** The end date. */
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    
    /** The start mile age. */
    @Basic(optional = false)
    @Column(name = "startMileAge")
    private int startMileAge;
    
    /** The end mile age. */
    @Basic(optional = false)
    @Column(name = "endMileAge")
    private int endMileAge;
    
    /** The billing amount. */
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "billingAmount")
    private Float billingAmount;
    
    /** The already payed. */
    @Column(name = "alreadyPayed")
    private Boolean alreadyPayed;
    
    /** The car. */
    @JoinColumn(name = "car", referencedColumnName = "licenseNumber")
    @ManyToOne
    private Car car;
    
    /** The customer. */
    @JoinColumn(name = "customer", referencedColumnName = "customerID")
    @ManyToOne(optional = false)
    private Customer customer;

    /**
     * Instantiates a new loan contract.
     */
    public LoanContract() {
    }

    /**
     * Instantiates a new loan contract.
     *
     * @param loanContractID the loan contract id
     */
    public LoanContract(Integer loanContractID) {
        this.loanContractID = loanContractID;
    }

    /**
     * Instantiates a new loan contract.
     *
     * @param loanContractID the loan contract id
     * @param startDate the start date
     * @param endDate the end date
     * @param startMileAge the start mile age
     * @param endMileAge the end mile age
     */
    public LoanContract(Integer loanContractID, Date startDate, Date endDate, int startMileAge, int endMileAge) {
        this.loanContractID = loanContractID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startMileAge = startMileAge;
        this.endMileAge = endMileAge;
    }

    /**
     * Gets the loan contract id.
     *
     * @return the loan contract id
     */
    public Integer getLoanContractID() {
        return loanContractID;
    }

    /**
     * Sets the loan contract id.
     *
     * @param loanContractID the new loan contract id
     */
    public void setLoanContractID(Integer loanContractID) {
        this.loanContractID = loanContractID;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the start mile age.
     *
     * @return the start mile age
     */
    public int getStartMileAge() {
        return startMileAge;
    }

    /**
     * Sets the start mile age.
     *
     * @param startMileAge the new start mile age
     */
    public void setStartMileAge(int startMileAge) {
        this.startMileAge = startMileAge;
    }

    /**
     * Gets the end mile age.
     *
     * @return the end mile age
     */
    public int getEndMileAge() {
        return endMileAge;
    }

    /**
     * Sets the end mile age.
     *
     * @param endMileAge the new end mile age
     */
    public void setEndMileAge(int endMileAge) {
        this.endMileAge = endMileAge;
    }

    /**
     * Gets the billing amount.
     *
     * @return the billing amount
     */
    public Float getBillingAmount() {
        return billingAmount;
    }

    /**
     * Sets the billing amount.
     *
     * @param billingAmount the new billing amount
     */
    public void setBillingAmount(Float billingAmount) {
        this.billingAmount = billingAmount;
    }

    /**
     * Gets the already payed.
     *
     * @return the already payed
     */
    public Boolean getAlreadyPayed() {
        return alreadyPayed;
    }

    /**
     * Sets the already payed.
     *
     * @param alreadyPayed the new already payed
     */
    public void setAlreadyPayed(Boolean alreadyPayed) {
        this.alreadyPayed = alreadyPayed;
    }

    /**
     * Gets the car.
     *
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the car.
     *
     * @param car the new car
     */
    public void setCar(Car car) {
        this.car = car;
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
     * @param customer the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanContractID != null ? loanContractID.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanContract)) {
            return false;
        }
        LoanContract other = (LoanContract) object;
        if ((this.loanContractID == null && other.loanContractID != null) || (this.loanContractID != null && !this.loanContractID.equals(other.loanContractID))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.LoanContract[ loanContractID=" + loanContractID + " ]";
    }
    
}
