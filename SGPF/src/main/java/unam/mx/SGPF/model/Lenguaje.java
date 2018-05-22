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
@Table(name = "lenguaje", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lenguaje.findAll", query = "SELECT l FROM Lenguaje l")
    , @NamedQuery(name = "Lenguaje.findByIdlenguaje", query = "SELECT l FROM Lenguaje l WHERE l.idlenguaje = :idlenguaje")
    , @NamedQuery(name = "Lenguaje.findByLenguaje", query = "SELECT l FROM Lenguaje l WHERE l.lenguaje = :lenguaje")})
public class Lenguaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idlenguaje;
    @Column(length = 45)
    private String lenguaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlenguaje")
    private List<Proyecto> proyectoList;

    public Lenguaje() {
    }

    public Lenguaje(Integer idlenguaje) {
        this.idlenguaje = idlenguaje;
    }

    public Integer getIdlenguaje() {
        return idlenguaje;
    }

    public void setIdlenguaje(Integer idlenguaje) {
        this.idlenguaje = idlenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
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
        hash += (idlenguaje != null ? idlenguaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lenguaje)) {
            return false;
        }
        Lenguaje other = (Lenguaje) object;
        if ((this.idlenguaje == null && other.idlenguaje != null) || (this.idlenguaje != null && !this.idlenguaje.equals(other.idlenguaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Lenguaje[ idlenguaje=" + idlenguaje + " ]";
    }

}
