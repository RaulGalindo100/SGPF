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
@Table(name = "confInfo", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfInfo.findAll", query = "SELECT c FROM ConfInfo c")
    , @NamedQuery(name = "ConfInfo.findByIdconfInfo", query = "SELECT c FROM ConfInfo c WHERE c.idconfInfo = :idconfInfo")
    , @NamedQuery(name = "ConfInfo.findByConfInfo", query = "SELECT c FROM ConfInfo c WHERE c.confInfo = :confInfo")})
public class ConfInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idconfInfo;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String confInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconfInfo")
    private List<Proyecto> proyectoList;

    public ConfInfo() {
    }

    public ConfInfo(Integer idconfInfo) {
        this.idconfInfo = idconfInfo;
    }

    public ConfInfo(Integer idconfInfo, String confInfo) {
        this.idconfInfo = idconfInfo;
        this.confInfo = confInfo;
    }

    public Integer getIdconfInfo() {
        return idconfInfo;
    }

    public void setIdconfInfo(Integer idconfInfo) {
        this.idconfInfo = idconfInfo;
    }

    public String getConfInfo() {
        return confInfo;
    }

    public void setConfInfo(String confInfo) {
        this.confInfo = confInfo;
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
        hash += (idconfInfo != null ? idconfInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfInfo)) {
            return false;
        }
        ConfInfo other = (ConfInfo) object;
        if ((this.idconfInfo == null && other.idconfInfo != null) || (this.idconfInfo != null && !this.idconfInfo.equals(other.idconfInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.ConfInfo[ idconfInfo=" + idconfInfo + " ]";
    }

}
