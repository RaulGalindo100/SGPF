/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model;

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
 *
 * @author miguel
 */
@Entity
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectorOrganizacion.findAll", query = "SELECT s FROM SectorOrganizacion s")
    , @NamedQuery(name = "SectorOrganizacion.findByIdsectorOrganizacion", query = "SELECT s FROM SectorOrganizacion s WHERE s.idsectorOrganizacion = :idsectorOrganizacion")
    , @NamedQuery(name = "SectorOrganizacion.findBySectorOrganizacion", query = "SELECT s FROM SectorOrganizacion s WHERE s.sectorOrganizacion = :sectorOrganizacion")})
public class SectorOrganizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idsectorOrganizacion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String sectorOrganizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsectorOrganizacion")
    private List<Proyecto> proyectoList;

    public SectorOrganizacion() {
    }

    public SectorOrganizacion(Integer idsectorOrganizacion) {
        this.idsectorOrganizacion = idsectorOrganizacion;
    }

    public SectorOrganizacion(Integer idsectorOrganizacion, String sectorOrganizacion) {
        this.idsectorOrganizacion = idsectorOrganizacion;
        this.sectorOrganizacion = sectorOrganizacion;
    }

    public Integer getIdsectorOrganizacion() {
        return idsectorOrganizacion;
    }

    public void setIdsectorOrganizacion(Integer idsectorOrganizacion) {
        this.idsectorOrganizacion = idsectorOrganizacion;
    }

    public String getSectorOrganizacion() {
        return sectorOrganizacion;
    }

    public void setSectorOrganizacion(String sectorOrganizacion) {
        this.sectorOrganizacion = sectorOrganizacion;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsectorOrganizacion != null ? idsectorOrganizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorOrganizacion)) {
            return false;
        }
        SectorOrganizacion other = (SectorOrganizacion) object;
        if ((this.idsectorOrganizacion == null && other.idsectorOrganizacion != null) || (this.idsectorOrganizacion != null && !this.idsectorOrganizacion.equals(other.idsectorOrganizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.SectorOrganizacion[ idsectorOrganizacion=" + idsectorOrganizacion + " ]";
    }

}
