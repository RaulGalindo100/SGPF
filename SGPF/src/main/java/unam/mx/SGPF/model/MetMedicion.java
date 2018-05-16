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
 * @author juan
 */
@Entity
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetMedicion.findAll", query = "SELECT m FROM MetMedicion m")
    , @NamedQuery(name = "MetMedicion.findByIdmetMedicion", query = "SELECT m FROM MetMedicion m WHERE m.idmetMedicion = :idmetMedicion")
    , @NamedQuery(name = "MetMedicion.findByMetMedicion", query = "SELECT m FROM MetMedicion m WHERE m.metMedicion = :metMedicion")})
public class MetMedicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idmetMedicion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String metMedicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmetMedicion")
    private List<Proyecto> proyectoList;

    public MetMedicion() {
    }

    public MetMedicion(Integer idmetMedicion) {
        this.idmetMedicion = idmetMedicion;
    }

    public MetMedicion(Integer idmetMedicion, String metMedicion) {
        this.idmetMedicion = idmetMedicion;
        this.metMedicion = metMedicion;
    }

    public Integer getIdmetMedicion() {
        return idmetMedicion;
    }

    public void setIdmetMedicion(Integer idmetMedicion) {
        this.idmetMedicion = idmetMedicion;
    }

    public String getMetMedicion() {
        return metMedicion;
    }

    public void setMetMedicion(String metMedicion) {
        this.metMedicion = metMedicion;
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
        hash += (idmetMedicion != null ? idmetMedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetMedicion)) {
            return false;
        }
        MetMedicion other = (MetMedicion) object;
        if ((this.idmetMedicion == null && other.idmetMedicion != null) || (this.idmetMedicion != null && !this.idmetMedicion.equals(other.idmetMedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.MetMedicion[ idmetMedicion=" + idmetMedicion + " ]";
    }

}
