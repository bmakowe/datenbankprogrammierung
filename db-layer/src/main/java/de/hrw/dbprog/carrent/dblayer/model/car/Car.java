/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.car;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.hrw.dbprog.carrent.dblayer.model.reservation.LoanContract;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "CARS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT car FROM Car car"),
    @NamedQuery(name = "Car.findByLicenseNumber", query = "SELECT car FROM Car car WHERE car.licenseNumber = :licenseNumber"),
    @NamedQuery(name = "Car.findByCarModel", query = "SELECT car FROM Car car WHERE car.carModel = :carModel"),
    @NamedQuery(name = "Car.findByMileAge", query = "SELECT car FROM Car car WHERE car.mileAge = :mileAge"),
    @NamedQuery(name = "Car.findByMotDate", query = "SELECT car FROM Car car WHERE car.motDate = :motDate"),
    @NamedQuery(name = "Car.findByDateOfPurchase", query = "SELECT car FROM Car car WHERE car.dateOfPurchase = :dateOfPurchase")})
public class Car implements Serializable {

	/** The Constant QUERY_FINDALL. */
	public static final String QUERY_FINDALL = "Car.findAll";
	
	/** The Constant QUERY_FINDBYCARMODEL. */
	public static final String QUERY_FINDBYCARMODEL = "Car.findByCarModel";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /** The license number. */
    @Id
    @Basic(optional = false)
    @Column(name = "licenseNumber")
    private String licenseNumber;
    
    /** The mile age. */
    @Basic(optional = false)
    @Column(name = "mileAge")
    private int mileAge;
    
    /** The mot date. */
    @Basic(optional = false)
    @Column(name = "motDate")
    @Temporal(TemporalType.DATE)
    private Date motDate;
    
    /** The date of purchase. */
    @Basic(optional = false)
    @Column(name = "dateOfPurchase")
    @Temporal(TemporalType.DATE)
    private Date dateOfPurchase;
    
    /** The car model. */
    @JoinColumn(name = "carModel", referencedColumnName = "carModelID")
    @ManyToOne(optional = false)
    private CarModel carModel;
    
    /** The loan contracts list. */
    @OneToMany(mappedBy = "car")
    private List<LoanContract> loanContractsList;
    
    /**
     * Instantiates a new car.
     */
    public Car() {
    }

    /**
     * Instantiates a new car.
     *
     * @param licenseNumber the license number
     */
    public Car(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Instantiates a new car.
     *
     * @param licenseNumber the license number
     * @param mileAge the mile age
     * @param motDate the mot date
     * @param dateOfPurchase the date of purchase
     */
    public Car(String licenseNumber, int mileAge, Date motDate, Date dateOfPurchase) {
        this.licenseNumber = licenseNumber;
        this.mileAge = mileAge;
        this.motDate = motDate;
        this.dateOfPurchase = dateOfPurchase;
    }

    /**
     * Gets the license number.
     *
     * @return the license number
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the license number.
     *
     * @param licenseNumber the new license number
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Gets the mile age.
     *
     * @return the mile age
     */
    public int getMileAge() {
        return mileAge;
    }

    /**
     * Sets the mile age.
     *
     * @param mileAge the new mile age
     */
    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    /**
     * Gets the mot date.
     *
     * @return the mot date
     */
    public Date getMotDate() {
        return motDate;
    }

    /**
     * Sets the mot date.
     *
     * @param motDate the new mot date
     */
    public void setMotDate(Date motDate) {
        this.motDate = motDate;
    }

    /**
     * Gets the date of purchase.
     *
     * @return the date of purchase
     */
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    /**
     * Sets the date of purchase.
     *
     * @param dateOfPurchase the new date of purchase
     */
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    /**
     * Gets the car model.
     *
     * @return the car model
     */
    public CarModel getCarModel() {
        return carModel;
    }

    /**
     * Sets the car model.
     *
     * @param carModel the new car model
     */
    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    /**
     * Gets the loan contracts.
     *
     * @return the loan contracts
     */
    @XmlTransient
    public List<LoanContract> getLoanContracts() {
        return loanContractsList;
    }

    /**
     * Sets the loan contracts.
     *
     * @param loanContractsList the new loan contracts
     */
    public void setLoanContracts(List<LoanContract> loanContractsList) {
        this.loanContractsList = loanContractsList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licenseNumber != null ? licenseNumber.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.licenseNumber == null && other.licenseNumber != null) || (this.licenseNumber != null && !this.licenseNumber.equals(other.licenseNumber))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.Car[ licenseNumber=" + licenseNumber + " ]";
    }
    
}
