package unam.mx.SGPF.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubProceso.findAll", query = "SELECT s FROM SubProceso s")
    , @NamedQuery(name = "SubProceso.findByIdsubProceso", query = "SELECT s FROM SubProceso s WHERE s.idsubProceso = :idsubProceso")
    , @NamedQuery(name = "SubProceso.findSPByActividadyPF", query="SELECT s FROM SubProceso s WHERE s.idprocesoFuncional = :procesoFuncional and s.actividad = :actividad")    
    , @NamedQuery(name = "SubProces.findByFlujoAl", query = "SELECT s FROM SubProceso s WHERE s.flujoAl = :flujoAl")
    , @NamedQuery(name = "SubProceso.findSPByIDPForder",query="select s from SubProceso s where s.idprocesoFuncional=:idPF group by s.actividad,s.indice,s.idusuarioFuncional,s.idaccion,s.idgrupoDato,s.descripcion,s.idsubProceso,s.flujoAl order by s.actividad,s.indice")
    , @NamedQuery(name = "SubProceso.findSPByActividadyIdPF", query="SELECT s FROM SubProceso s WHERE s.idprocesoFuncional = :idprocesoFuncional AND s.actividad = :actividad")
    , @NamedQuery(name = "SubProceso.findSPByActividad", query="SELECT s FROM SubProceso s where s.actividad = :actividad")
    , @NamedQuery(name = "SubProceso.findByDescripcion", query = "SELECT s FROM SubProceso s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SubProceso.findByActividad", query = "SELECT s FROM SubProceso s WHERE s.actividad = :actividad")
    , @NamedQuery(name = "SubProceso.findByIndice", query = "SELECT s FROM SubProceso s WHERE s.indice = :indice")})
public class SubProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idsubProceso;
    private Short flujoAl;
    @Column(length = 250)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String actividad;
    @Basic(optional = false)
    @Column(nullable = false)
    private int indice;
    @JoinColumn(name = "idaccion", referencedColumnName = "idaccion", nullable = false)
    @ManyToOne(optional = false)
    private Accion idaccion;
    @JoinColumn(name = "idgrupoDato", referencedColumnName = "idgrupoDato", nullable = false)
    @ManyToOne(optional = false)
    private GrupoDato idgrupoDato;
    @JoinColumn(name = "idprocesoFuncional", referencedColumnName = "idprocesoFuncional", nullable = false)
    @ManyToOne(optional = false)
    private ProcesoFuncional idprocesoFuncional;
    @JoinColumn(name = "idusuarioFuncional", referencedColumnName = "idusuarioFuncional", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioFuncional idusuarioFuncional;

    public SubProceso() {
    }

    public SubProceso(Integer idsubProceso) {
        this.idsubProceso = idsubProceso;
    }

    public SubProceso(Integer idsubProceso, String actividad, int indice) {
        this.idsubProceso = idsubProceso;
        this.actividad = actividad;
        this.indice = indice;
    }

    public Integer getIdsubProceso() {
        return idsubProceso;
    }

    public void setIdsubProceso(Integer idsubProceso) {
        this.idsubProceso = idsubProceso;
    }

    public Short getFlujoAl() {
        return flujoAl;
    }

    public void setFlujoAl(Short flujoAl) {
        this.flujoAl = flujoAl;
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

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
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

    public ProcesoFuncional getIdprocesoFuncional() {
        return idprocesoFuncional;
    }

    public void setIdprocesoFuncional(ProcesoFuncional idprocesoFuncional) {
        this.idprocesoFuncional = idprocesoFuncional;
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
        hash += (idsubProceso != null ? idsubProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubProceso)) {
            return false;
        }
        SubProceso other = (SubProceso) object;
        if ((this.idsubProceso == null && other.idsubProceso != null) || (this.idsubProceso != null && !this.idsubProceso.equals(other.idsubProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.SubProceso[ idsubProceso=" + idsubProceso + " ]";
    }

}
