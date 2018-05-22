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
@Table(name = "accion", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accion.findAll", query = "SELECT a FROM Accion a")
    , @NamedQuery(name = "Accion.findByIdaccion", query = "SELECT a FROM Accion a WHERE a.idaccion = :idaccion")
    , @NamedQuery(name = "Accion.findByNomAccion", query = "SELECT a FROM Accion a WHERE a.nomAccion = :nomAccion")
    , @NamedQuery(name = "Accion.findByMovDatos", query = "SELECT a FROM Accion a WHERE a.movDatos = :movDatos")
    , @NamedQuery(name = "Accion.findByDescripcion", query = "SELECT a FROM Accion a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Accion.findByActivo", query = "SELECT a FROM Accion a WHERE a.activo = :activo")})
public class Accion implements Serializable {

    @OneToMany(mappedBy = "idaccion")
    private List<FlujoAlterno> flujoAlternoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idaccion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomAccion;
    @Basic(optional = false)
    @Column(nullable = false)
    private Character movDatos;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false)
    private short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaccion")
    private List<SubProceso> subprocesoList;

    public Accion() {
    }

    public Accion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public Accion(Integer idaccion, String nomAccion, Character movDatos, String descripcion, short activo) {
        this.idaccion = idaccion;
        this.nomAccion = nomAccion;
        this.movDatos = movDatos;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public String getNomAccion() {
        return nomAccion;
    }

    public void setNomAccion(String nomAccion) {
        this.nomAccion = nomAccion;
    }

    public Character getMovDatos() {
        return movDatos;
    }

    public void setMovDatos(Character movDatos) {
        this.movDatos = movDatos;
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

    @XmlTransient
    public List<SubProceso> getSubProcesoList() {
        return subprocesoList;
    }

    public void setSubProcesoList(List<SubProceso> subprocesoList) {
        this.subprocesoList = subprocesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccion != null ? idaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accion)) {
            return false;
        }
        Accion other = (Accion) object;
        if ((this.idaccion == null && other.idaccion != null) || (this.idaccion != null && !this.idaccion.equals(other.idaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Accion[ idaccion=" + idaccion + " ]";
    }

    @XmlTransient
    public List<FlujoAlterno> getFlujoAlternoList() {
        return flujoAlternoList;
    }

    public void setFlujoAlternoList(List<FlujoAlterno> flujoAlternoList) {
        this.flujoAlternoList = flujoAlternoList;
    }

}
