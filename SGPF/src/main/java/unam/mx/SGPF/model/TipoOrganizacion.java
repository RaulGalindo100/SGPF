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
@Table(name = "tipoOrganizacion", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOrganizacion.findAll", query = "SELECT t FROM TipoOrganizacion t")
    , @NamedQuery(name = "TipoOrganizacion.findByIdtipoOrganizacion", query = "SELECT t FROM TipoOrganizacion t WHERE t.idtipoOrganizacion = :idtipoOrganizacion")
    , @NamedQuery(name = "TipoOrganizacion.findByTipoOrganizacion", query = "SELECT t FROM TipoOrganizacion t WHERE t.tipoOrganizacion = :tipoOrganizacion")})
public class TipoOrganizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idtipoOrganizacion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipoOrganizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoOrganizacion")
    private List<Proyecto> proyectoList;

    public TipoOrganizacion() {
    }

    public TipoOrganizacion(Integer idtipoOrganizacion) {
        this.idtipoOrganizacion = idtipoOrganizacion;
    }

    public TipoOrganizacion(Integer idtipoOrganizacion, String tipoOrganizacion) {
        this.idtipoOrganizacion = idtipoOrganizacion;
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public Integer getIdtipoOrganizacion() {
        return idtipoOrganizacion;
    }

    public void setIdtipoOrganizacion(Integer idtipoOrganizacion) {
        this.idtipoOrganizacion = idtipoOrganizacion;
    }

    public String getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(String tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
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
        hash += (idtipoOrganizacion != null ? idtipoOrganizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOrganizacion)) {
            return false;
        }
        TipoOrganizacion other = (TipoOrganizacion) object;
        if ((this.idtipoOrganizacion == null && other.idtipoOrganizacion != null) || (this.idtipoOrganizacion != null && !this.idtipoOrganizacion.equals(other.idtipoOrganizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.TipoOrganizacion[ idtipoOrganizacion=" + idtipoOrganizacion + " ]";
    }

}
