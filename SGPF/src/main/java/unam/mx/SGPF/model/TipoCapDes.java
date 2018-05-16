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
    @NamedQuery(name = "TipoCapDes.findAll", query = "SELECT t FROM TipoCapDes t")
    , @NamedQuery(name = "TipoCapDes.findByIdtipoCapDes", query = "SELECT t FROM TipoCapDes t WHERE t.idtipoCapDes = :idtipoCapDes")
    , @NamedQuery(name = "TipoCapDes.findByTipoCapDes", query = "SELECT t FROM TipoCapDes t WHERE t.tipoCapDes = :tipoCapDes")})
public class TipoCapDes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idtipoCapDes;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String tipoCapDes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoCapDes")
    private List<Proyecto> proyectoList;

    public TipoCapDes() {
    }

    public TipoCapDes(Integer idtipoCapDes) {
        this.idtipoCapDes = idtipoCapDes;
    }

    public TipoCapDes(Integer idtipoCapDes, String tipoCapDes) {
        this.idtipoCapDes = idtipoCapDes;
        this.tipoCapDes = tipoCapDes;
    }

    public Integer getIdtipoCapDes() {
        return idtipoCapDes;
    }

    public void setIdtipoCapDes(Integer idtipoCapDes) {
        this.idtipoCapDes = idtipoCapDes;
    }

    public String getTipoCapDes() {
        return tipoCapDes;
    }

    public void setTipoCapDes(String tipoCapDes) {
        this.tipoCapDes = tipoCapDes;
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
        hash += (idtipoCapDes != null ? idtipoCapDes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCapDes)) {
            return false;
        }
        TipoCapDes other = (TipoCapDes) object;
        if ((this.idtipoCapDes == null && other.idtipoCapDes != null) || (this.idtipoCapDes != null && !this.idtipoCapDes.equals(other.idtipoCapDes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.TipoCapDes[ idtipoCapDes=" + idtipoCapDes + " ]";
    }

}
