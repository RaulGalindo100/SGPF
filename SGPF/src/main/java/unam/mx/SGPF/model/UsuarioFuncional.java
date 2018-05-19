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
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioFuncional.findAll", query = "SELECT u FROM UsuarioFuncional u")
    , @NamedQuery(name = "UsuarioFuncional.findByIdusuarioFuncional", query = "SELECT u FROM UsuarioFuncional u WHERE u.idusuarioFuncional = :idusuarioFuncional")
    , @NamedQuery(name = "UsuarioFuncional.findByNomUF", query = "SELECT u FROM UsuarioFuncional u WHERE u.nomUF = :nomUF")
    , @NamedQuery(name = "UsuarioFuncional.findByDescripcion", query = "SELECT u FROM UsuarioFuncional u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "UsuarioFuncional.findByActivo", query = "SELECT u FROM UsuarioFuncional u WHERE u.activo = :activo")})
public class UsuarioFuncional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idusuarioFuncional;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomUF;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false)
    private short activo;
    @Basic(optional = false)
    @Column(nullable = false)
    private short usuarioSistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioFuncional")
    private List<SubProceso> subprocesoList;

    public UsuarioFuncional() {
    }

    public UsuarioFuncional(Integer idusuarioFuncional) {
        this.idusuarioFuncional = idusuarioFuncional;
    }

    public UsuarioFuncional(Integer idusuarioFuncional, String nomUF, String descripcion, short activo) {
        this.idusuarioFuncional = idusuarioFuncional;
        this.nomUF = nomUF;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdusuarioFuncional() {
        return idusuarioFuncional;
    }

    public void setIdusuarioFuncional(Integer idusuarioFuncional) {
        this.idusuarioFuncional = idusuarioFuncional;
    }
    
    
    public short getUsuarioSistema() {
        return usuarioSistema;
    }
    
    
    public void setUsuarioSistema(short usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getNomUF() {
        return nomUF;
    }

    public void setNomUF(String nomUF) {
        this.nomUF = nomUF;
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
        hash += (idusuarioFuncional != null ? idusuarioFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioFuncional)) {
            return false;
        }
        UsuarioFuncional other = (UsuarioFuncional) object;
        if ((this.idusuarioFuncional == null && other.idusuarioFuncional != null) || (this.idusuarioFuncional != null && !this.idusuarioFuncional.equals(other.idusuarioFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.UsuarioFuncional[ idusuarioFuncional=" + idusuarioFuncional + " ]";
    }

}
