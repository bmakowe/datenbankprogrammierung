/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hrw.dbprog.carrent.dblayer.model.car;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Entity
@Table(name = "CARFEATURES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarFeature.findAll", query = "SELECT CarFeature FROM CarFeature CarFeature"),
    @NamedQuery(name = "CarFeature.findByCarFeatureID", query = "SELECT CarFeature FROM CarFeature CarFeature WHERE CarFeature.carFeatureID = :carFeatureID"),
    @NamedQuery(name = "CarFeature.findByLabel", query = "SELECT CarFeature FROM CarFeature CarFeature WHERE CarFeature.label = :label")})
public class CarFeature implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /** The car feature id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carFeatureID")
    private Integer carFeatureID;
    
    /** The label. */
    @Basic(optional = false)
    @Column(name = "label")
    private String label;
    
    /** The car models list. */
    @JoinTable(name = "CARMODELHASFEATURES", joinColumns = {
        @JoinColumn(name = "carFeature", referencedColumnName = "carFeatureID")}, inverseJoinColumns = {
        @JoinColumn(name = "carModel", referencedColumnName = "carModelID")})
    @ManyToMany
    private List<CarModel> carModelsList;

    /**
     * Instantiates a new car feature.
     */
    public CarFeature() {
    }

    /**
     * Instantiates a new car feature.
     *
     * @param carFeatureID the car feature id
     */
    public CarFeature(Integer carFeatureID) {
        this.carFeatureID = carFeatureID;
    }

    /**
     * Instantiates a new car feature.
     *
     * @param carFeatureID the car feature id
     * @param label the label
     */
    public CarFeature(Integer carFeatureID, String label) {
        this.carFeatureID = carFeatureID;
        this.label = label;
    }

    /**
     * Gets the car feature id.
     *
     * @return the car feature id
     */
    public Integer getCarFeatureID() {
        return carFeatureID;
    }

    /**
     * Sets the car feature id.
     *
     * @param carFeatureID the new car feature id
     */
    public void setCarFeatureID(Integer carFeatureID) {
        this.carFeatureID = carFeatureID;
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
        hash += (carFeatureID != null ? carFeatureID.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarFeature)) {
            return false;
        }
        CarFeature other = (CarFeature) object;
        if ((this.carFeatureID == null && other.carFeatureID != null) || (this.carFeatureID != null && !this.carFeatureID.equals(other.carFeatureID))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "jpa.CarFeature[ carFeatureID=" + carFeatureID + " ]";
    }
    
}
