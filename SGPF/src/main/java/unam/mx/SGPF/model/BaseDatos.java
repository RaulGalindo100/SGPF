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
@Table(name = "baseDatos", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseDatos.findAll", query = "SELECT b FROM BaseDatos b")
    , @NamedQuery(name = "BaseDatos.findByIdbaseDatos", query = "SELECT b FROM BaseDatos b WHERE b.idbaseDatos = :idbaseDatos")
    , @NamedQuery(name = "BaseDatos.findByBaseDatos", query = "SELECT b FROM BaseDatos b WHERE b.baseDatos = :baseDatos")})
public class BaseDatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idbaseDatos;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String baseDatos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbaseDatos")
    private List<Proyecto> proyectoList;

    public BaseDatos() {
    }

    public BaseDatos(Integer idbaseDatos) {
        this.idbaseDatos = idbaseDatos;
    }

    public BaseDatos(Integer idbaseDatos, String baseDatos) {
        this.idbaseDatos = idbaseDatos;
        this.baseDatos = baseDatos;
    }

    public Integer getIdbaseDatos() {
        return idbaseDatos;
    }

    public void setIdbaseDatos(Integer idbaseDatos) {
        this.idbaseDatos = idbaseDatos;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
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
        hash += (idbaseDatos != null ? idbaseDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseDatos)) {
            return false;
        }
        BaseDatos other = (BaseDatos) object;
        if ((this.idbaseDatos == null && other.idbaseDatos != null) || (this.idbaseDatos != null && !this.idbaseDatos.equals(other.idbaseDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.BaseDatos[ idbaseDatos=" + idbaseDatos + " ]";
    }

}
