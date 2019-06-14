/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oswaldo.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oswal
 */
@Entity
@Table(name = "Days")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Days.findAll", query = "SELECT d FROM Days d")
    , @NamedQuery(name = "Days.findByIdDay", query = "SELECT d FROM Days d WHERE d.idDay = :idDay")
    , @NamedQuery(name = "Days.findByNameDay", query = "SELECT d FROM Days d WHERE d.nameDay = :nameDay")})
public class Days implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDay")
    private Integer idDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nameDay")
    private String nameDay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRestrictionDay")
    private Collection<RestrictionDays> restrictionDaysCollection;

    public Days() {
    }

    public Days(Integer idDay) {
        this.idDay = idDay;
    }

    public Days(Integer idDay, String nameDay) {
        this.idDay = idDay;
        this.nameDay = nameDay;
    }

    public Integer getIdDay() {
        return idDay;
    }

    public void setIdDay(Integer idDay) {
        this.idDay = idDay;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    @XmlTransient
    public Collection<RestrictionDays> getRestrictionDaysCollection() {
        return restrictionDaysCollection;
    }

    public void setRestrictionDaysCollection(Collection<RestrictionDays> restrictionDaysCollection) {
        this.restrictionDaysCollection = restrictionDaysCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDay != null ? idDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Days)) {
            return false;
        }
        Days other = (Days) object;
        if ((this.idDay == null && other.idDay != null) || (this.idDay != null && !this.idDay.equals(other.idDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oswaldo.models.Days[ idDay=" + idDay + " ]";
    }
    
}
