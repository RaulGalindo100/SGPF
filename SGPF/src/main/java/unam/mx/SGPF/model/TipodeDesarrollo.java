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
@Table(name = "TipodeDesarrollo", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipodeDesarrollo.findAll", query = "SELECT t FROM TipodeDesarrollo t")
    , @NamedQuery(name = "TipodeDesarrollo.findByIdTipodeDesarrollo", query = "SELECT t FROM TipodeDesarrollo t WHERE t.idTipodeDesarrollo = :idTipodeDesarrollo")
    , @NamedQuery(name = "TipodeDesarrollo.findByTipodeDesarrollo", query = "SELECT t FROM TipodeDesarrollo t WHERE t.tipodeDesarrollo = :tipodeDesarrollo")})
public class TipodeDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idTipodeDesarrollo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipodeDesarrollo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDesarrollo")
    private List<Proyecto> proyectoList;

    public TipodeDesarrollo() {
    }

    public TipodeDesarrollo(Integer idTipodeDesarrollo) {
        this.idTipodeDesarrollo = idTipodeDesarrollo;
    }

    public TipodeDesarrollo(Integer idTipodeDesarrollo, String tipodeDesarrollo) {
        this.idTipodeDesarrollo = idTipodeDesarrollo;
        this.tipodeDesarrollo = tipodeDesarrollo;
    }

    public Integer getIdTipodeDesarrollo() {
        return idTipodeDesarrollo;
    }

    public void setIdTipodeDesarrollo(Integer idTipodeDesarrollo) {
        this.idTipodeDesarrollo = idTipodeDesarrollo;
    }

    public String getTipodeDesarrollo() {
        return tipodeDesarrollo;
    }

    public void setTipodeDesarrollo(String tipodeDesarrollo) {
        this.tipodeDesarrollo = tipodeDesarrollo;
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
        hash += (idTipodeDesarrollo != null ? idTipodeDesarrollo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipodeDesarrollo)) {
            return false;
        }
        TipodeDesarrollo other = (TipodeDesarrollo) object;
        if ((this.idTipodeDesarrollo == null && other.idTipodeDesarrollo != null) || (this.idTipodeDesarrollo != null && !this.idTipodeDesarrollo.equals(other.idTipodeDesarrollo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.TipodeDesarrollo[ idTipodeDesarrollo=" + idTipodeDesarrollo + " ]";
    }

}
