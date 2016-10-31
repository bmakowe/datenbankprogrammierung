/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.customer;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.hrw.dbprog.carrent.dblayer.model.reservation.LoanContract;
import de.hrw.dbprog.carrent.dblayer.model.reservation.Reservation;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "SELECT customer FROM Customer customer"),
		@NamedQuery(name = "Customer.findByCustomerID", query = "SELECT customer FROM Customer customer WHERE customer.customerID = :customerID"),
		@NamedQuery(name = "Customer.findByForeName", query = "SELECT customer FROM Customer customer WHERE customer.foreName = :foreName"),
		@NamedQuery(name = "Customer.findBySurname", query = "SELECT customer FROM Customer customer WHERE customer.surname = :surname"),
		@NamedQuery(name = "Customer.findByPostcode", query = "SELECT customer FROM Customer customer WHERE customer.postcode = :postcode"),
		@NamedQuery(name = "Customer.findByCity", query = "SELECT customer FROM Customer customer WHERE customer.city = :city"),
		@NamedQuery(name = "Customer.findByStreet", query = "SELECT customer FROM Customer customer WHERE customer.street = :street"),
		@NamedQuery(name = "Customer.findByMail", query = "SELECT customer FROM Customer customer WHERE customer.mail = :mail"),
		@NamedQuery(name = "Customer.findByPhoneNumber", query = "SELECT customer FROM Customer customer WHERE customer.phoneNumber = :phoneNumber") })
public class Customer implements Serializable {

	/** The Constant QUERY_FINDALL. */
	public static final String QUERY_FINDALL = "Customer.findAll";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The customer id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "customerID")
	private Integer customerID;
	
	/** The fore name. */
	@Basic(optional = false)
	@Column(name = "foreName")
	private String foreName;
	
	/** The surname. */
	@Basic(optional = false)
	@Column(name = "surname")
	private String surname;
	
	/** The postcode. */
	@Basic(optional = false)
	@Column(name = "postcode")
	private String postcode;
	
	/** The city. */
	@Basic(optional = false)
	@Column(name = "city")
	private String city;
	
	/** The street. */
	@Basic(optional = false)
	@Column(name = "street")
	private String street;
	
	/** The mail. */
	@Basic(optional = false)
	@Column(name = "mail")
	private String mail;
	
	/** The phone number. */
	@Basic(optional = false)
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	/** The reservations list. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Reservation> reservationsList;
	
	/** The licenses list. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<License> licensesList;
	
	/** The loan contracts list. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<LoanContract> loanContractsList;

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerID the customer id
	 */
	public Customer(Integer customerID) {
		this.customerID = customerID;
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerID the customer id
	 * @param foreName the fore name
	 * @param surname the surname
	 * @param postcode the postcode
	 * @param city the city
	 * @param street the street
	 * @param mail the mail
	 * @param phoneNumber the phone number
	 */
	public Customer(Integer customerID, String foreName, String surname, String postcode, String city, String street,
			String mail, String phoneNumber) {
		this.customerID = customerID;
		this.foreName = foreName;
		this.surname = surname;
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public Integer getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerID the new customer id
	 */
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	/**
	 * Gets the fore name.
	 *
	 * @return the fore name
	 */
	public String getForeName() {
		return foreName;
	}

	/**
	 * Sets the fore name.
	 *
	 * @param foreName the new fore name
	 */
	public void setForeName(String foreName) {
		this.foreName = foreName;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the postcode.
	 *
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * Sets the postcode.
	 *
	 * @param postcode the new postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 *
	 * @param mail the new mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the reservations.
	 *
	 * @return the reservations
	 */
	@XmlTransient
	public List<Reservation> getReservations() {
		return reservationsList;
	}

	/**
	 * Sets the reservations.
	 *
	 * @param reservationsList the new reservations
	 */
	public void setReservations(List<Reservation> reservationsList) {
		this.reservationsList = reservationsList;
	}

	/**
	 * Gets the licenses.
	 *
	 * @return the licenses
	 */
	@XmlTransient
	public List<License> getLicenses() {
		return licensesList;
	}

	/**
	 * Sets the licenses.
	 *
	 * @param licensesList the new licenses
	 */
	public void setLicenses(List<License> licensesList) {
		this.licensesList = licensesList;
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
		hash += (customerID != null ? customerID.hashCode() : 0);
		return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) object;
		if ((this.customerID == null && other.customerID != null)
				|| (this.customerID != null && !this.customerID.equals(other.customerID))) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "jpa.Customer[ customerID=" + customerID + " ]";
	}

}
