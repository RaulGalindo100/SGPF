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
    @NamedQuery(name = "Escala.findAll", query = "SELECT e FROM Escala e")
    , @NamedQuery(name = "Escala.findByIdescala", query = "SELECT e FROM Escala e WHERE e.idescala = :idescala")
    , @NamedQuery(name = "Escala.findByEscala", query = "SELECT e FROM Escala e WHERE e.escala = :escala")})
public class Escala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idescala;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String escala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idescala")
    private List<Proyecto> proyectoList;

    public Escala() {
    }

    public Escala(Integer idescala) {
        this.idescala = idescala;
    }

    public Escala(Integer idescala, String escala) {
        this.idescala = idescala;
        this.escala = escala;
    }

    public Integer getIdescala() {
        return idescala;
    }

    public void setIdescala(Integer idescala) {
        this.idescala = idescala;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
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
        hash += (idescala != null ? idescala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escala)) {
            return false;
        }
        Escala other = (Escala) object;
        if ((this.idescala == null && other.idescala != null) || (this.idescala != null && !this.idescala.equals(other.idescala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Escala[ idescala=" + idescala + " ]";
    }

}
