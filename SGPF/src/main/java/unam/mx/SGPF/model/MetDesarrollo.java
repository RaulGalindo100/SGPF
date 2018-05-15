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
    @NamedQuery(name = "MetDesarrollo.findAll", query = "SELECT m FROM MetDesarrollo m")
    , @NamedQuery(name = "MetDesarrollo.findByIdmetDesarrollo", query = "SELECT m FROM MetDesarrollo m WHERE m.idmetDesarrollo = :idmetDesarrollo")
    , @NamedQuery(name = "MetDesarrollo.findByMetDesarrollo", query = "SELECT m FROM MetDesarrollo m WHERE m.metDesarrollo = :metDesarrollo")})
public class MetDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idmetDesarrollo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String metDesarrollo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmetDesarrollo")
    private List<Proyecto> proyectoList;

    public MetDesarrollo() {
    }

    public MetDesarrollo(Integer idmetDesarrollo) {
        this.idmetDesarrollo = idmetDesarrollo;
    }

    public MetDesarrollo(Integer idmetDesarrollo, String metDesarrollo) {
        this.idmetDesarrollo = idmetDesarrollo;
        this.metDesarrollo = metDesarrollo;
    }

    public Integer getIdmetDesarrollo() {
        return idmetDesarrollo;
    }

    public void setIdmetDesarrollo(Integer idmetDesarrollo) {
        this.idmetDesarrollo = idmetDesarrollo;
    }

    public String getMetDesarrollo() {
        return metDesarrollo;
    }

    public void setMetDesarrollo(String metDesarrollo) {
        this.metDesarrollo = metDesarrollo;
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
        hash += (idmetDesarrollo != null ? idmetDesarrollo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetDesarrollo)) {
            return false;
        }
        MetDesarrollo other = (MetDesarrollo) object;
        if ((this.idmetDesarrollo == null && other.idmetDesarrollo != null) || (this.idmetDesarrollo != null && !this.idmetDesarrollo.equals(other.idmetDesarrollo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.MetDesarrollo[ idmetDesarrollo=" + idmetDesarrollo + " ]";
    }

}
