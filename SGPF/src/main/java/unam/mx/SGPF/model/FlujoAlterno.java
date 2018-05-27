/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "flujoAlterno", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlujoAlterno.findAll", query = "SELECT f FROM FlujoAlterno f")
    , @NamedQuery(name = "FlujoAlterno.findByIdflujoAlterno", query = "SELECT f FROM FlujoAlterno f WHERE f.idflujoAlterno = :idflujoAlterno")
    , @NamedQuery(name = "FlujoAlterno.findByDescripcion", query = "SELECT f FROM FlujoAlterno f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "FlujoAlterno.findByIdSubProceso", query = "SELECT distinct f FROM FlujoAlterno f WHERE f.idsubProceso = :idsubProceso order by f.actividad")
    , @NamedQuery(name = "FlujoAlterno.findByActividad", query = "SELECT f FROM FlujoAlterno f WHERE f.actividad = :actividad")})
public class FlujoAlterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idflujoAlterno;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String actividad;
    @JoinColumn(name = "idaccion", referencedColumnName = "idaccion")
    @ManyToOne
    private Accion idaccion;
    @JoinColumn(name = "idgrupoDato", referencedColumnName = "idgrupoDato")
    @ManyToOne
    private GrupoDato idgrupoDato;
    @JoinColumn(name = "idsubProceso", referencedColumnName = "idsubProceso")
    @ManyToOne
    private SubProceso idsubProceso;
    @JoinColumn(name = "idusuarioFuncional", referencedColumnName = "idusuarioFuncional")
    @ManyToOne
    private UsuarioFuncional idusuarioFuncional;

    public FlujoAlterno() {
    }

    public FlujoAlterno(Integer idflujoAlterno) {
        this.idflujoAlterno = idflujoAlterno;
    }

    public FlujoAlterno(Integer idflujoAlterno, String descripcion, String actividad) {
        this.idflujoAlterno = idflujoAlterno;
        this.descripcion = descripcion;
        this.actividad = actividad;
    }

    public Integer getIdflujoAlterno() {
        return idflujoAlterno;
    }

    public void setIdflujoAlterno(Integer idflujoAlterno) {
        this.idflujoAlterno = idflujoAlterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Accion getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Accion idaccion) {
        this.idaccion = idaccion;
    }

    public GrupoDato getIdgrupoDato() {
        return idgrupoDato;
    }

    public void setIdgrupoDato(GrupoDato idgrupoDato) {
        this.idgrupoDato = idgrupoDato;
    }

    public SubProceso getIdsubProceso() {
        return idsubProceso;
    }

    public void setIdsubProceso(SubProceso idsubProceso) {
        this.idsubProceso = idsubProceso;
    }

    public UsuarioFuncional getIdusuarioFuncional() {
        return idusuarioFuncional;
    }

    public void setIdusuarioFuncional(UsuarioFuncional idusuarioFuncional) {
        this.idusuarioFuncional = idusuarioFuncional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idflujoAlterno != null ? idflujoAlterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlujoAlterno)) {
            return false;
        }
        FlujoAlterno other = (FlujoAlterno) object;
        if ((this.idflujoAlterno == null && other.idflujoAlterno != null) || (this.idflujoAlterno != null && !this.idflujoAlterno.equals(other.idflujoAlterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.FlujoAlterno[ idflujoAlterno=" + idflujoAlterno + " ]";
    }

}
