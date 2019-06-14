/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oswaldo.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oswal
 */
@Entity
@Table(name = "RestrictionDays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestrictionDays.findAll", query = "SELECT r FROM RestrictionDays r")
    , @NamedQuery(name = "RestrictionDays.findByIdRestriction", query = "SELECT r FROM RestrictionDays r WHERE r.idRestriction = :idRestriction")
    , @NamedQuery(name = "RestrictionDays.findByLastnumberPlate", query = "SELECT r FROM RestrictionDays r WHERE r.lastnumberPlate = :lastnumberPlate")})
public class RestrictionDays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRestriction")
    private Integer idRestriction;
    @Column(name = "lastnumberPlate")
    private Integer lastnumberPlate;
    @JoinColumn(name = "idRestrictionDay", referencedColumnName = "idDay")
    @ManyToOne(optional = false)
    private Days idRestrictionDay;

    public RestrictionDays() {
    }

    public RestrictionDays(Integer idRestriction) {
        this.idRestriction = idRestriction;
    }

    public Integer getIdRestriction() {
        return idRestriction;
    }

    public void setIdRestriction(Integer idRestriction) {
        this.idRestriction = idRestriction;
    }

    public Integer getLastnumberPlate() {
        return lastnumberPlate;
    }

    public void setLastnumberPlate(Integer lastnumberPlate) {
        this.lastnumberPlate = lastnumberPlate;
    }

    public Days getIdRestrictionDay() {
        return idRestrictionDay;
    }

    public void setIdRestrictionDay(Days idRestrictionDay) {
        this.idRestrictionDay = idRestrictionDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRestriction != null ? idRestriction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestrictionDays)) {
            return false;
        }
        RestrictionDays other = (RestrictionDays) object;
        if ((this.idRestriction == null && other.idRestriction != null) || (this.idRestriction != null && !this.idRestriction.equals(other.idRestriction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oswaldo.models.RestrictionDays[ idRestriction=" + idRestriction + " ]";
    }
    
}
