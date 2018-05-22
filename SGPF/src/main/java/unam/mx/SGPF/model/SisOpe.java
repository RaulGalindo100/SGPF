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
@Table(name = "sisOpe", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisOpe.findAll", query = "SELECT s FROM SisOpe s")
    , @NamedQuery(name = "SisOpe.findByIdsisOpe", query = "SELECT s FROM SisOpe s WHERE s.idsisOpe = :idsisOpe")
    , @NamedQuery(name = "SisOpe.findBySisOpe", query = "SELECT s FROM SisOpe s WHERE s.sisOpe = :sisOpe")})
public class SisOpe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idsisOpe;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String sisOpe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsisOpe")
    private List<Proyecto> proyectoList;

    public SisOpe() {
    }

    public SisOpe(Integer idsisOpe) {
        this.idsisOpe = idsisOpe;
    }

    public SisOpe(Integer idsisOpe, String sisOpe) {
        this.idsisOpe = idsisOpe;
        this.sisOpe = sisOpe;
    }

    public Integer getIdsisOpe() {
        return idsisOpe;
    }

    public void setIdsisOpe(Integer idsisOpe) {
        this.idsisOpe = idsisOpe;
    }

    public String getSisOpe() {
        return sisOpe;
    }

    public void setSisOpe(String sisOpe) {
        this.sisOpe = sisOpe;
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
        hash += (idsisOpe != null ? idsisOpe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisOpe)) {
            return false;
        }
        SisOpe other = (SisOpe) object;
        if ((this.idsisOpe == null && other.idsisOpe != null) || (this.idsisOpe != null && !this.idsisOpe.equals(other.idsisOpe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.SisOpe[ idsisOpe=" + idsisOpe + " ]";
    }

}
