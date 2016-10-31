/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.car;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import de.hrw.dbprog.carrent.dblayer.model.reservation.Reservation;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "CARMODELS")
@XmlRootElement
@FilterDefs({ @FilterDef(name = "filterByLabel", parameters = @ParamDef(name = "label", type = "java.lang.String")),
		@FilterDef(name = "filterByManufacturer", parameters = @ParamDef(name = "manufacturer", type = "java.lang.String")),
		@FilterDef(name = "filterByCarType", parameters = @ParamDef(name = "carType", type = "java.lang.Integer")),
		@FilterDef(name = "filterBySeats", parameters = @ParamDef(name = "seats", type = "java.lang.Integer")),
		@FilterDef(name = "filterByFuel", parameters = @ParamDef(name = "fuel", type = "java.lang.String")) })

@Filters(value = { @Filter(name = "filterByLabel", condition = "label = :label"),
		@Filter(name = "filterByManufacturer", condition = "manufacturer = :manufacturer"),
		@Filter(name = "filterByCarType", condition = "carType = :carType"),
		@Filter(name = "filterBySeats", condition = "seats = :seats"),
		@Filter(name = "filterByFuel", condition = "fuel = :fuel") })

@NamedQueries({ @NamedQuery(name = "CarModel.findAll", query = "SELECT CarModel FROM CarModel CarModel"),
		@NamedQuery(name = "CarModel.findByCarModelID", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.carModelID = :carModelID"),
		@NamedQuery(name = "CarModel.findByLabel", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.label = :label"),
		@NamedQuery(name = "CarModel.findByManufacturer", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.manufacturer = :manufacturer"),
		@NamedQuery(name = "CarModel.findBySeats", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.seats = :seats"),
		@NamedQuery(name = "CarModel.findByKw", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.kw = :kw"),
		@NamedQuery(name = "CarModel.findByFuel", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.fuel = :fuel"),
		@NamedQuery(name = "CarModel.findByPricePerDay", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.pricePerDay = :pricePerDay"),
		@NamedQuery(name = "CarModel.findByPricePerKM", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.pricePerKM = :pricePerKM"),
		@NamedQuery(name = "CarModel.findByAxes", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.axes = :axes"),
		@NamedQuery(name = "CarModel.findByCargoLoad", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.cargoLoad = :cargoLoad"),
		@NamedQuery(name = "CarModel.findByCargoVolume", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.cargoVolume = :cargoVolume"),
		@NamedQuery(name = "CarModel.findByLicense", query = "SELECT CarModel FROM CarModel CarModel WHERE CarModel.license = :license") })
public class CarModel implements Serializable {

	/** The Constant QUERY_FINDALL. */
	public static final String QUERY_FINDALL = "CarModel.findAll";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The car model id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "carModelID")
	private Integer carModelID;
	
	/** The label. */
	@Basic(optional = false)
	@Column(name = "label")
	private String label;
	
	/** The manufacturer. */
	@Basic(optional = false)
	@Column(name = "manufacturer")
	private String manufacturer;
	
	/** The seats. */
	@Basic(optional = false)
	@Column(name = "seats")
	private int seats;
	
	/** The kw. */
	@Basic(optional = false)
	@Column(name = "kw")
	private int kw;
	
	/** The fuel. */
	@Basic(optional = false)
	@Column(name = "fuel")
	private String fuel;
	
	/** The price per day. */
	@Basic(optional = false)
	@Column(name = "pricePerDay")
	private float pricePerDay;
	
	/** The price per km. */
	@Basic(optional = false)
	@Column(name = "pricePerKM")
	private float pricePerKM;
	
	/** The axes. */
	@Column(name = "axes")
	private Integer axes;
	
	/** The cargo load. */
	@Basic(optional = false)
	@Column(name = "cargoLoad")
	private int cargoLoad;
	
	/** The cargo volume. */
	@Basic(optional = false)
	@Column(name = "cargoVolume")
	private int cargoVolume;
	
	/** The license. */
	@Basic(optional = false)
	@Column(name = "license")
	private String license;
	
	/** The car features list. */
	@ManyToMany(mappedBy = "carModelsList")
	private List<CarFeature> carFeaturesList;
	
	/** The cars list. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "carModel")
	private List<Car> carsList;
	
	/** The reservations list. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "carModel")
	private List<Reservation> reservationsList;
	
	/** The cartype. */
	@JoinColumn(name = "cartype", referencedColumnName = "carTypeID")
	@ManyToOne(optional = false)
	private CarType cartype;

	/**
	 * Instantiates a new car model.
	 */
	public CarModel() {
	}

	/**
	 * Instantiates a new car model.
	 *
	 * @param carModelID the car model id
	 */
	public CarModel(Integer carModelID) {
		this.carModelID = carModelID;
	}

	/**
	 * Instantiates a new car model.
	 *
	 * @param carModelID the car model id
	 * @param label the label
	 * @param manufacturer the manufacturer
	 * @param seats the seats
	 * @param kw the kw
	 * @param fuel the fuel
	 * @param pricePerDay the price per day
	 * @param pricePerKM the price per km
	 * @param cargoLoad the cargo load
	 * @param cargoVolume the cargo volume
	 * @param license the license
	 */
	public CarModel(Integer carModelID, String label, String manufacturer, int seats, int kw, String fuel,
			float pricePerDay, float pricePerKM, int cargoLoad, int cargoVolume, String license) {
		this.carModelID = carModelID;
		this.label = label;
		this.manufacturer = manufacturer;
		this.seats = seats;
		this.kw = kw;
		this.fuel = fuel;
		this.pricePerDay = pricePerDay;
		this.pricePerKM = pricePerKM;
		this.cargoLoad = cargoLoad;
		this.cargoVolume = cargoVolume;
		this.license = license;
	}

	/**
	 * Gets the car model id.
	 *
	 * @return the car model id
	 */
	public Integer getCarModelID() {
		return carModelID;
	}

	/**
	 * Sets the car model id.
	 *
	 * @param carModelID the new car model id
	 */
	public void setCarModelID(Integer carModelID) {
		this.carModelID = carModelID;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the manufacturer.
	 *
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the manufacturer.
	 *
	 * @param manufacturer the new manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Gets the seats.
	 *
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * Gets the kw.
	 *
	 * @return the kw
	 */
	public int getKw() {
		return kw;
	}

	/**
	 * Sets the kw.
	 *
	 * @param kw the new kw
	 */
	public void setKw(int kw) {
		this.kw = kw;
	}

	/**
	 * Gets the fuel.
	 *
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * Sets the fuel.
	 *
	 * @param fuel the new fuel
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * Gets the price per day.
	 *
	 * @return the price per day
	 */
	public float getPricePerDay() {
		return pricePerDay;
	}

	/**
	 * Sets the price per day.
	 *
	 * @param pricePerDay the new price per day
	 */
	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	/**
	 * Gets the price per km.
	 *
	 * @return the price per km
	 */
	public float getPricePerKM() {
		return pricePerKM;
	}

	/**
	 * Sets the price per km.
	 *
	 * @param pricePerKM the new price per km
	 */
	public void setPricePerKM(float pricePerKM) {
		this.pricePerKM = pricePerKM;
	}

	/**
	 * Gets the axes.
	 *
	 * @return the axes
	 */
	public Integer getAxes() {
		return axes;
	}

	/**
	 * Sets the axes.
	 *
	 * @param axes the new axes
	 */
	public void setAxes(Integer axes) {
		this.axes = axes;
	}

	/**
	 * Gets the cargo load.
	 *
	 * @return the cargo load
	 */
	public int getCargoLoad() {
		return cargoLoad;
	}

	/**
	 * Sets the cargo load.
	 *
	 * @param cargoLoad the new cargo load
	 */
	public void setCargoLoad(int cargoLoad) {
		this.cargoLoad = cargoLoad;
	}

	/**
	 * Gets the cargo volume.
	 *
	 * @return the cargo volume
	 */
	public int getCargoVolume() {
		return cargoVolume;
	}

	/**
	 * Sets the cargo volume.
	 *
	 * @param cargoVolume the new cargo volume
	 */
	public void setCargoVolume(int cargoVolume) {
		this.cargoVolume = cargoVolume;
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

	/**
	 * Gets the car features.
	 *
	 * @return the car features
	 */
	@XmlTransient
	public List<CarFeature> getCarFeatures() {
		return carFeaturesList;
	}

	/**
	 * Sets the car features.
	 *
	 * @param carFeaturesList the new car features
	 */
	public void setCarFeatures(List<CarFeature> carFeaturesList) {
		this.carFeaturesList = carFeaturesList;
	}

	/**
	 * Gets the cars.
	 *
	 * @return the cars
	 */
	@XmlTransient
	public List<Car> getCars() {
		return carsList;
	}

	/**
	 * Sets the cars.
	 *
	 * @param carsList the new cars
	 */
	public void setCars(List<Car> carsList) {
		this.carsList = carsList;
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
	 * Gets the cartype.
	 *
	 * @return the cartype
	 */
	public CarType getCartype() {
		return cartype;
	}

	/**
	 * Sets the cartype.
	 *
	 * @param cartype the new cartype
	 */
	public void setCartype(CarType cartype) {
		this.cartype = cartype;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (carModelID != null ? carModelID.hashCode() : 0);
		return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CarModel)) {
			return false;
		}
		CarModel other = (CarModel) object;
		if ((this.carModelID == null && other.carModelID != null)
				|| (this.carModelID != null && !this.carModelID.equals(other.carModelID))) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "jpa.CarModel[ carModelID=" + carModelID + " ]";
	}

}
