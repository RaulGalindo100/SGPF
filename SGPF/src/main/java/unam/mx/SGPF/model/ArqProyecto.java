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
    @NamedQuery(name = "ArqProyecto.findAll", query = "SELECT a FROM ArqProyecto a")
    , @NamedQuery(name = "ArqProyecto.findByIdarqProyecto", query = "SELECT a FROM ArqProyecto a WHERE a.idarqProyecto = :idarqProyecto")
    , @NamedQuery(name = "ArqProyecto.findByArqProyecto", query = "SELECT a FROM ArqProyecto a WHERE a.arqProyecto = :arqProyecto")})
public class ArqProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idarqProyecto;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String arqProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarqProyecto")
    private List<Proyecto> proyectoList;

    public ArqProyecto() {
    }

    public ArqProyecto(Integer idarqProyecto) {
        this.idarqProyecto = idarqProyecto;
    }

    public ArqProyecto(Integer idarqProyecto, String arqProyecto) {
        this.idarqProyecto = idarqProyecto;
        this.arqProyecto = arqProyecto;
    }

    public Integer getIdarqProyecto() {
        return idarqProyecto;
    }

    public void setIdarqProyecto(Integer idarqProyecto) {
        this.idarqProyecto = idarqProyecto;
    }

    public String getArqProyecto() {
        return arqProyecto;
    }

    public void setArqProyecto(String arqProyecto) {
        this.arqProyecto = arqProyecto;
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
        hash += (idarqProyecto != null ? idarqProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArqProyecto)) {
            return false;
        }
        ArqProyecto other = (ArqProyecto) object;
        if ((this.idarqProyecto == null && other.idarqProyecto != null) || (this.idarqProyecto != null && !this.idarqProyecto.equals(other.idarqProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.ArqProyecto[ idarqProyecto=" + idarqProyecto + " ]";
    }

}
