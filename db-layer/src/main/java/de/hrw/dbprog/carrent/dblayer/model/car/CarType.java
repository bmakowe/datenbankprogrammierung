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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "CARTYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarType.findAll", query = "SELECT carType FROM CarType carType"),
    @NamedQuery(name = "CarType.findByCarTypeID", query = "SELECT carType FROM CarType carType WHERE carType.carTypeID = :carTypeID"),
    @NamedQuery(name = "CarType.findByLabel", query = "SELECT carType FROM CarType carType WHERE carType.label = :label")})
public class CarType implements Serializable {

	/** The Constant QUERY_FINDBYLABEL. */
	public static final String QUERY_FINDBYLABEL = "CarType.findByLabel";
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The car type id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carTypeID")
    private Integer carTypeID;
    
    /** The label. */
    @Basic(optional = false)
    @Column(name = "label")
    private String label;
    
    /** The car models list. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartype")
    private List<CarModel> carModelsList;

    /**
     * Instantiates a new car type.
     */
    public CarType() {
    }

    /**
     * Instantiates a new car type.
     *
     * @param carTypeID the car type id
     */
    public CarType(Integer carTypeID) {
        this.carTypeID = carTypeID;
    }

    /**
     * Instantiates a new car type.
     *
     * @param carTypeID the car type id
     * @param label the label
     */
    public CarType(Integer carTypeID, String label) {
        this.carTypeID = carTypeID;
        this.label = label;
    }

    /**
     * Gets the car type id.
     *
     * @return the car type id
     */
    public Integer getCarTypeID() {
        return carTypeID;
    }

    /**
     * Sets the car type id.
     *
     * @param carTypeID the new car type id
     */
    public void setCarTypeID(Integer carTypeID) {
        this.carTypeID = carTypeID;
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
     * Gets the car models.
     *
     * @return the car models
     */
    @XmlTransient
    public List<CarModel> getCarModels() {
        return carModelsList;
    }

    /**
     * Sets the car models.
     *
     * @param carModelsList the new car models
     */
    public void setCarModels(List<CarModel> carModelsList) {
        this.carModelsList = carModelsList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carTypeID != null ? carTypeID.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarType)) {
            return false;
        }
        CarType other = (CarType) object;
        if ((this.carTypeID == null && other.carTypeID != null) || (this.carTypeID != null && !this.carTypeID.equals(other.carTypeID))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.CarType[ carTypeID=" + carTypeID + " ]";
    }
    
}
