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
    @NamedQuery(name = "MarcoPosUsa.findAll", query = "SELECT m FROM MarcoPosUsa m")
    , @NamedQuery(name = "MarcoPosUsa.findByIdmarcoPosUsa", query = "SELECT m FROM MarcoPosUsa m WHERE m.idmarcoPosUsa = :idmarcoPosUsa")
    , @NamedQuery(name = "MarcoPosUsa.findByMarcoPosUsa", query = "SELECT m FROM MarcoPosUsa m WHERE m.marcoPosUsa = :marcoPosUsa")})
public class MarcoPosUsa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idmarcoPosUsa;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String marcoPosUsa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarcoPosUsa")
    private List<Proyecto> proyectoList;

    public MarcoPosUsa() {
    }

    public MarcoPosUsa(Integer idmarcoPosUsa) {
        this.idmarcoPosUsa = idmarcoPosUsa;
    }

    public MarcoPosUsa(Integer idmarcoPosUsa, String marcoPosUsa) {
        this.idmarcoPosUsa = idmarcoPosUsa;
        this.marcoPosUsa = marcoPosUsa;
    }

    public Integer getIdmarcoPosUsa() {
        return idmarcoPosUsa;
    }

    public void setIdmarcoPosUsa(Integer idmarcoPosUsa) {
        this.idmarcoPosUsa = idmarcoPosUsa;
    }

    public String getMarcoPosUsa() {
        return marcoPosUsa;
    }

    public void setMarcoPosUsa(String marcoPosUsa) {
        this.marcoPosUsa = marcoPosUsa;
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
        hash += (idmarcoPosUsa != null ? idmarcoPosUsa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcoPosUsa)) {
            return false;
        }
        MarcoPosUsa other = (MarcoPosUsa) object;
        if ((this.idmarcoPosUsa == null && other.idmarcoPosUsa != null) || (this.idmarcoPosUsa != null && !this.idmarcoPosUsa.equals(other.idmarcoPosUsa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.MarcoPosUsa[ idmarcoPosUsa=" + idmarcoPosUsa + " ]";
    }

}
