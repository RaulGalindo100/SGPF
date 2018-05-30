package unam.mx.SGPF.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "historico", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h")
    , @NamedQuery(name = "Historico.findByIdhistorico", query = "SELECT h FROM Historico h WHERE h.idhistorico = :idhistorico")
    , @NamedQuery(name = "Historico.findByIdProy", query = "SELECT h FROM Historico h WHERE h.idProy = :idProy")
    , @NamedQuery(name = "Historico.findByNombreProy", query = "SELECT h FROM Historico h WHERE h.nombreProy = :nombreProy")
    , @NamedQuery(name = "Historico.findByAlcanceProy", query = "SELECT h FROM Historico h WHERE h.alcanceProy = :alcanceProy")
    , @NamedQuery(name = "Historico.findByNombrePF", query = "SELECT h FROM Historico h WHERE h.nombrePF = :nombrePF")
    , @NamedQuery(name = "Historico.findHistoricoByIdProyecto", query = "SELECT h FROM Historico h WHERE h.idProy = :idPF group by h.fecha order by h.fecha asc")
    , @NamedQuery(name = "Historico.findHistoricoByIdProyectoFecha", query = "SELECT h FROM Historico h WHERE h.idProy = :idPF and h.fecha = :fecha")
    , @NamedQuery(name = "Historico.findByDescripcionPF", query = "SELECT h FROM Historico h WHERE h.descripcionPF = :descripcionPF")
    , @NamedQuery(name = "Historico.findByTamanioPF", query = "SELECT h FROM Historico h WHERE h.tamanio = :tamanio")
    , @NamedQuery(name = "Historico.findByEventoDesPF", query = "SELECT h FROM Historico h WHERE h.eventoDesPF = :eventoDesPF")
    , @NamedQuery(name = "Historico.findByDescripcionSP", query = "SELECT h FROM Historico h WHERE h.descripcionSP = :descripcionSP")
    , @NamedQuery(name = "Historico.findByFecha", query = "SELECT h FROM Historico h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "Historico.findByNombreGD", query = "SELECT h FROM Historico h WHERE h.nombreGD = :nombreGD")
    , @NamedQuery(name = "Historico.findByDescripcionGD", query = "SELECT h FROM Historico h WHERE h.descripcionGD = :descripcionGD")
    , @NamedQuery(name = "Historico.findByNombreUF", query = "SELECT h FROM Historico h WHERE h.nombreUF = :nombreUF")
    , @NamedQuery(name = "Historico.findByDescripcionUF", query = "SELECT h FROM Historico h WHERE h.descripcionUF = :descripcionUF")
    , @NamedQuery(name = "Historico.findByUsuarioSistemaUF", query = "SELECT h FROM Historico h WHERE h.usuarioSistemaUF = :usuarioSistemaUF")
    , @NamedQuery(name = "Historico.findByNombreAccion", query = "SELECT h FROM Historico h WHERE h.nombreAccion = :nombreAccion")
    , @NamedQuery(name = "Historico.findByMovDatos", query = "SELECT h FROM Historico h WHERE h.movDatos = :movDatos")})
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idhistorico;
    @Basic(optional = false)
    @Column(nullable = false)
    private int idProy;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String nombreProy;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String alcanceProy;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String nombrePF;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcionPF;
    @Basic(optional = false)
    @Column(nullable = false)
    private int tamanio;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String eventoDesPF;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcionSP;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String nombreGD;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcionGD;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String nombreUF;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcionUF;
    @Basic(optional = false)
    @Column(nullable = false)
    private Short usuarioSistemaUF;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String nombreAccion;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String movDatos;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String proposito;

    public Historico() {
    }

    public Historico(Integer idhistorico) {
        this.idhistorico = idhistorico;
    }

   
    public Integer getIdhistorico() {
        return idhistorico;
    }

    public void setIdhistorico(Integer idhistorico) {
        this.idhistorico = idhistorico;
    }

    public int getIdProy() {
        return idProy;
    }

    public void setIdProy(int idProy) {
        this.idProy = idProy;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getAlcanceProy() {
        return alcanceProy;
    }

    public void setAlcanceProy(String alcanceProy) {
        this.alcanceProy = alcanceProy;
    }

    public String getNombrePF() {
        return nombrePF;
    }

    public void setNombrePF(String nombrePF) {
        this.nombrePF = nombrePF;
    }

    public String getDescripcionPF() {
        return descripcionPF;
    }

    public void setDescripcionPF(String descripcionPF) {
        this.descripcionPF = descripcionPF;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanioPF) {
        this.tamanio = tamanioPF;
    }

    public String getEventoDesPF() {
        return eventoDesPF;
    }

    public void setEventoDesPF(String eventoDesPF) {
        this.eventoDesPF = eventoDesPF;
    }

    public String getDescripcionSP() {
        return descripcionSP;
    }

    public void setDescripcionSP(String descripcionSP) {
        this.descripcionSP = descripcionSP;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreGD() {
        return nombreGD;
    }

    public void setNombreGD(String nombreGD) {
        this.nombreGD = nombreGD;
    }

    public String getDescripcionGD() {
        return descripcionGD;
    }

    public void setDescripcionGD(String descripcionGD) {
        this.descripcionGD = descripcionGD;
    }

    public String getNombreUF() {
        return nombreUF;
    }

    public void setNombreUF(String nombreUF) {
        this.nombreUF = nombreUF;
    }

    public String getDescripcionUF() {
        return descripcionUF;
    }

    public void setDescripcionUF(String descripcionUF) {
        this.descripcionUF = descripcionUF;
    }

    public Short getUsuarioSistemaUF() {
        return usuarioSistemaUF;
    }

    public void setUsuarioSistemaUF(Short usuarioSistemaUF) {
        this.usuarioSistemaUF = usuarioSistemaUF;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }

    public String getMovDatos() {
        return movDatos;
    }

    public void setMovDatos(String movDatos) {
        this.movDatos = movDatos;
    }
    
    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistorico != null ? idhistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.idhistorico == null && other.idhistorico != null) || (this.idhistorico != null && !this.idhistorico.equals(other.idhistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Historico[ idhistorico=" + idhistorico + " ]";
    }

}
