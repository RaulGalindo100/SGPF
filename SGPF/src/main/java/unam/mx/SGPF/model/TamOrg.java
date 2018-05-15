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
    @NamedQuery(name = "TamOrg.findAll", query = "SELECT t FROM TamOrg t")
    , @NamedQuery(name = "TamOrg.findByIdtamOrgDes", query = "SELECT t FROM TamOrg t WHERE t.idtamOrgDes = :idtamOrgDes")
    , @NamedQuery(name = "TamOrg.findByTamOrgDes", query = "SELECT t FROM TamOrg t WHERE t.tamOrgDes = :tamOrgDes")})
public class TamOrg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idtamOrgDes;
    @Column(length = 45)
    private String tamOrgDes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tamOrgUsa")
    private List<Proyecto> proyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtamOrgDes")
    private List<Proyecto> proyectoList1;

    public TamOrg() {
    }

    public TamOrg(Integer idtamOrgDes) {
        this.idtamOrgDes = idtamOrgDes;
    }

    public Integer getIdtamOrgDes() {
        return idtamOrgDes;
    }

    public void setIdtamOrgDes(Integer idtamOrgDes) {
        this.idtamOrgDes = idtamOrgDes;
    }

    public String getTamOrgDes() {
        return tamOrgDes;
    }

    public void setTamOrgDes(String tamOrgDes) {
        this.tamOrgDes = tamOrgDes;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList1() {
        return proyectoList1;
    }

    public void setProyectoList1(List<Proyecto> proyectoList1) {
        this.proyectoList1 = proyectoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtamOrgDes != null ? idtamOrgDes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TamOrg)) {
            return false;
        }
        TamOrg other = (TamOrg) object;
        if ((this.idtamOrgDes == null && other.idtamOrgDes != null) || (this.idtamOrgDes != null && !this.idtamOrgDes.equals(other.idtamOrgDes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.TamOrg[ idtamOrgDes=" + idtamOrgDes + " ]";
    }

}
