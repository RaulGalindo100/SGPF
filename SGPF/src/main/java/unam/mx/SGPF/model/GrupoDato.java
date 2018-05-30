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

@Entity
@Table(name = "grupodato", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoDato.findAll", query = "SELECT g FROM GrupoDato g")
    , @NamedQuery(name = "GrupoDato.findByIdgrupoDato", query = "SELECT g FROM GrupoDato g WHERE g.idgrupoDato = :idgrupoDato")
    , @NamedQuery(name = "GrupoDato.findGrupoDatoOrdered", query = "SELECT g FROM GrupoDato g order by g.nomGD asc")
    , @NamedQuery(name = "GrupoDato.findByNomGD", query = "SELECT g FROM GrupoDato g WHERE g.nomGD = :nomGD")})
public class GrupoDato implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoDato")
    private List<SubprocesoGrupoDato> subprocesoGrupoDatoList;
    @OneToMany(mappedBy = "idgrupoDato")
    private List<FlujoAlterno> flujoAlternoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idgrupoDato;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomGD;
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Column(nullable = false)
    private short activo;
    @Basic(optional = false)
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private Integer idproyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupoDato")
    private List<SubProceso> subProcesoList;

    public GrupoDato(Integer idgrupoDato, String nomGD, String descripcion, short activo,
                     List<SubProceso> subProcesoList) {
        this.idgrupoDato = idgrupoDato;
        this.nomGD = nomGD;
        this.descripcion = descripcion;
        this.activo = activo;
        this.subProcesoList = subProcesoList;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public GrupoDato() {
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public GrupoDato(Integer idgrupoDato) {
        this.idgrupoDato = idgrupoDato;
    }

    public GrupoDato(Integer idgrupoDato, String nomGD) {
        this.idgrupoDato = idgrupoDato;
        this.nomGD = nomGD;
    }

    public Integer getIdgrupoDato() {
        return idgrupoDato;
    }

    public void setIdgrupoDato(Integer idgrupoDato) {
        this.idgrupoDato = idgrupoDato;
    }

    public String getNomGD() {
        return nomGD;
    }

    public void setNomGD(String nomGD) {
        this.nomGD = nomGD;
    }

    @XmlTransient
    public List<SubProceso> getSubProcesoList() {
        return subProcesoList;
    }

    public void setSubProcesoList(List<SubProceso> subProcesoList) {
        this.subProcesoList = subProcesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoDato != null ? idgrupoDato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDato)) {
            return false;
        }
        GrupoDato other = (GrupoDato) object;
        if ((this.idgrupoDato == null && other.idgrupoDato != null) || (this.idgrupoDato != null && !this.idgrupoDato.equals(other.idgrupoDato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.GrupoDato[ idgrupoDato=" + idgrupoDato + " ]";
    }

    @XmlTransient
    public List<SubprocesoGrupoDato> getSubprocesoGrupoDatoList() {
        return subprocesoGrupoDatoList;
    }

    public void setSubprocesoGrupoDatoList(List<SubprocesoGrupoDato> subprocesoGrupoDatoList) {
        this.subprocesoGrupoDatoList = subprocesoGrupoDatoList;
    }

    @XmlTransient
    public List<FlujoAlterno> getFlujoAlternoList() {
        return flujoAlternoList;
    }

    public void setFlujoAlternoList(List<FlujoAlterno> flujoAlternoList) {
        this.flujoAlternoList = flujoAlternoList;
    }

}
