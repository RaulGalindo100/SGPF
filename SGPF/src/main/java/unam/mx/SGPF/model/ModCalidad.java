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
@Table(name = "modCalidad", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModCalidad.findAll", query = "SELECT m FROM ModCalidad m")
    , @NamedQuery(name = "ModCalidad.findByIdmodCalidad", query = "SELECT m FROM ModCalidad m WHERE m.idmodCalidad = :idmodCalidad")
    , @NamedQuery(name = "ModCalidad.findByModCalidad", query = "SELECT m FROM ModCalidad m WHERE m.modCalidad = :modCalidad")})
public class ModCalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idmodCalidad;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String modCalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmodCalidad")
    private List<Proyecto> proyectoList;

    public ModCalidad() {
    }

    public ModCalidad(Integer idmodCalidad) {
        this.idmodCalidad = idmodCalidad;
    }

    public ModCalidad(Integer idmodCalidad, String modCalidad) {
        this.idmodCalidad = idmodCalidad;
        this.modCalidad = modCalidad;
    }

    public Integer getIdmodCalidad() {
        return idmodCalidad;
    }

    public void setIdmodCalidad(Integer idmodCalidad) {
        this.idmodCalidad = idmodCalidad;
    }

    public String getModCalidad() {
        return modCalidad;
    }

    public void setModCalidad(String modCalidad) {
        this.modCalidad = modCalidad;
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
        hash += (idmodCalidad != null ? idmodCalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModCalidad)) {
            return false;
        }
        ModCalidad other = (ModCalidad) object;
        if ((this.idmodCalidad == null && other.idmodCalidad != null) || (this.idmodCalidad != null && !this.idmodCalidad.equals(other.idmodCalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.ModCalidad[ idmodCalidad=" + idmodCalidad + " ]";
    }

}
