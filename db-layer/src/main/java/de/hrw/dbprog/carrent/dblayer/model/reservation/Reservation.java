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

import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;
import de.hrw.dbprog.carrent.dblayer.model.customer.Customer;

// TODO: Auto-generated Javadoc
/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "RESERVATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT reservation FROM Reservation reservation"),
    @NamedQuery(name = "Reservation.findByReservationID", query = "SELECT reservation FROM Reservation reservation WHERE reservation.reservationID = :reservationID"),
    @NamedQuery(name = "Reservation.findByStartDate", query = "SELECT reservation FROM Reservation reservation WHERE reservation.startDate = :startDate"),
    @NamedQuery(name = "Reservation.findReservationByCarModel", query = "SELECT reservation FROM Reservation reservation WHERE reservation.carModel = :carModel"),
    @NamedQuery(name = "Reservation.findByEndDate", query = "SELECT reservation FROM Reservation reservation WHERE reservation.endDate = :endDate")})
public class Reservation implements Serializable {

	/** The query find reservations by carmodel. */
	public static String QUERY_FIND_RESERVATIONS_BY_CARMODEL = "Reservation.findReservationByCarModel";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /** The reservation id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservationID")
    private Integer reservationID;
    
    /** The start date. */
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    /** The end date. */
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    
    /** The car model. */
    @JoinColumn(name = "carModel", referencedColumnName = "carModelID")
    @ManyToOne(optional = false)
    private CarModel carModel;
    
    /** The customer. */
    @JoinColumn(name = "customer", referencedColumnName = "customerID")
    @ManyToOne(optional = false)
    private Customer customer;

    /**
     * Instantiates a new reservation.
     */
    public Reservation() {
    }

    /**
     * Instantiates a new reservation.
     *
     * @param reservationID the reservation id
     */
    public Reservation(Integer reservationID) {
        this.reservationID = reservationID;
    }

    /**
     * Gets the reservation id.
     *
     * @return the reservation id
     */
    public Integer getReservationID() {
        return reservationID;
    }

    /**
     * Sets the reservation id.
     *
     * @param reservationID the new reservation id
     */
    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
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
        hash += (reservationID != null ? reservationID.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationID == null && other.reservationID != null) || (this.reservationID != null && !this.reservationID.equals(other.reservationID))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.Reservation[ reservationID=" + reservationID + " ]";
    }
    
}
