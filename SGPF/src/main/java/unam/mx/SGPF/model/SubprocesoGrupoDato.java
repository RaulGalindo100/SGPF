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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "subprocesoGrupoDato", catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubprocesoGrupoDato.findAll", query = "SELECT s FROM SubprocesoGrupoDato s")
    , @NamedQuery(name = "SubprocesoGrupoDato.findByIdsubprocesoGrupoDato", query = "SELECT s FROM SubprocesoGrupoDato s WHERE s.idsubprocesoGrupoDato = :idsubprocesoGrupoDato")})
public class SubprocesoGrupoDato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idsubprocesoGrupoDato;
    @JoinColumn(name = "idGrupoDato", referencedColumnName = "idgrupoDato", nullable = false)
    @ManyToOne(optional = false)
    private GrupoDato idGrupoDato;
    @JoinColumn(name = "idSubProceso", referencedColumnName = "idsubProceso", nullable = false)
    @ManyToOne(optional = false)
    private SubProceso idSubProceso;

    public SubprocesoGrupoDato() {
    }

    public SubprocesoGrupoDato(Integer idsubprocesoGrupoDato) {
        this.idsubprocesoGrupoDato = idsubprocesoGrupoDato;
    }

    public Integer getIdsubprocesoGrupoDato() {
        return idsubprocesoGrupoDato;
    }

    public void setIdsubprocesoGrupoDato(Integer idsubprocesoGrupoDato) {
        this.idsubprocesoGrupoDato = idsubprocesoGrupoDato;
    }

    public GrupoDato getIdGrupoDato() {
        return idGrupoDato;
    }

    public void setIdGrupoDato(GrupoDato idGrupoDato) {
        this.idGrupoDato = idGrupoDato;
    }

    public SubProceso getIdSubProceso() {
        return idSubProceso;
    }

    public void setIdSubProceso(SubProceso idSubProceso) {
        this.idSubProceso = idSubProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubprocesoGrupoDato != null ? idsubprocesoGrupoDato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubprocesoGrupoDato)) {
            return false;
        }
        SubprocesoGrupoDato other = (SubprocesoGrupoDato) object;
        if ((this.idsubprocesoGrupoDato == null && other.idsubprocesoGrupoDato != null) || (this.idsubprocesoGrupoDato != null && !this.idsubprocesoGrupoDato.equals(other.idsubprocesoGrupoDato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.SubprocesoGrupoDato[ idsubprocesoGrupoDato=" + idsubprocesoGrupoDato + " ]";
    }

}
