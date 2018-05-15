/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdproyecto", query = "SELECT p FROM Proyecto p WHERE p.idproyecto = :idproyecto and p.estatus=0")
    , @NamedQuery(name = "Proyecto.findByNomProy", query = "SELECT p FROM Proyecto p WHERE p.nomProy = :nomProy")
    , @NamedQuery(name = "Proyecto.findByAnioProy", query = "SELECT p FROM Proyecto p WHERE p.anioProy = :anioProy")
    , @NamedQuery(name = "Proyecto.findByOperProy", query = "SELECT p FROM Proyecto p WHERE p.operProy = :operProy")
    , @NamedQuery(name = "Proyecto.findByDuraProy", query = "SELECT p FROM Proyecto p WHERE p.duraProy = :duraProy")
    , @NamedQuery(name = "Proyecto.findByEsfuTotProy", query = "SELECT p FROM Proyecto p WHERE p.esfuTotProy = :esfuTotProy")
    , @NamedQuery(name = "Proyecto.findByEsfuPlaneProy", query = "SELECT p FROM Proyecto p WHERE p.esfuPlaneProy = :esfuPlaneProy")
    , @NamedQuery(name = "Proyecto.findByEsfuEsReqProy", query = "SELECT p FROM Proyecto p WHERE p.esfuEsReqProy = :esfuEsReqProy")
    , @NamedQuery(name = "Proyecto.findByEsfuAnaDisProy", query = "SELECT p FROM Proyecto p WHERE p.esfuAnaDisProy = :esfuAnaDisProy")
    , @NamedQuery(name = "Proyecto.findByEsfuConstProy", query = "SELECT p FROM Proyecto p WHERE p.esfuConstProy = :esfuConstProy")
    , @NamedQuery(name = "Proyecto.findByEsfuPrueProy", query = "SELECT p FROM Proyecto p WHERE p.esfuPrueProy = :esfuPrueProy")
    , @NamedQuery(name = "Proyecto.findByEsfuImpleDesProy", query = "SELECT p FROM Proyecto p WHERE p.esfuImpleDesProy = :esfuImpleDesProy")
    , @NamedQuery(name = "Proyecto.findByCostTotProy", query = "SELECT p FROM Proyecto p WHERE p.costTotProy = :costTotProy")
    , @NamedQuery(name = "Proyecto.findByCostEsReqProy", query = "SELECT p FROM Proyecto p WHERE p.costEsReqProy = :costEsReqProy")
    , @NamedQuery(name = "Proyecto.findByCostAnaDisProy", query = "SELECT p FROM Proyecto p WHERE p.costAnaDisProy = :costAnaDisProy")
    , @NamedQuery(name = "Proyecto.findByCostConstProy", query = "SELECT p FROM Proyecto p WHERE p.costConstProy = :costConstProy")
    , @NamedQuery(name = "Proyecto.findByCostPrueProy", query = "SELECT p FROM Proyecto p WHERE p.costPrueProy = :costPrueProy")
    , @NamedQuery(name = "Proyecto.findByCostImpleDesProy", query = "SELECT p FROM Proyecto p WHERE p.costImpleDesProy = :costImpleDesProy")
    , @NamedQuery(name = "Proyecto.findByTamFunProy", query = "SELECT p FROM Proyecto p WHERE p.tamFunProy = :tamFunProy")
    , @NamedQuery(name = "Proyecto.findByFpAjusProy", query = "SELECT p FROM Proyecto p WHERE p.fpAjusProy = :fpAjusProy")
    , @NamedQuery(name = "Proyecto.findByMedidorCertProy", query = "SELECT p FROM Proyecto p WHERE p.medidorCertProy = :medidorCertProy")
    , @NamedQuery(name = "Proyecto.findByExpeMedMetProy", query = "SELECT p FROM Proyecto p WHERE p.expeMedMetProy = :expeMedMetProy")
    , @NamedQuery(name = "Proyecto.findByUsoCase", query = "SELECT p FROM Proyecto p WHERE p.usoCase = :usoCase")
    , @NamedQuery(name = "Proyecto.findByCertModelo", query = "SELECT p FROM Proyecto p WHERE p.certModelo = :certModelo")
    , @NamedQuery(name = "Proyecto.findByComCertModelo", query = "SELECT p FROM Proyecto p WHERE p.comCertModelo = :comCertModelo")
    , @NamedQuery(name = "Proyecto.findByCostPlanProy", query = "SELECT p FROM Proyecto p WHERE p.costPlanProy = :costPlanProy")
    , @NamedQuery(name = "Proyecto.findByEstatus", query = "SELECT p FROM Proyecto p WHERE p.estatus = :estatus")
    , @NamedQuery(name = "Proyecto.findByTamOrgUsa", query = "SELECT p FROM Proyecto p WHERE p.tamOrgUsa = :tamOrgUsa")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idproyecto;

    @Column(nullable = false, length = 60)
    private String nomProy;
    @Column(nullable = false, length = 4)
    private String anioProy;
    @Column(nullable = false)
    private short operProy;
    @Column(nullable = false)
    private BigDecimal duraProy;
    @Column(nullable = false)
    private BigDecimal esfuTotProy;
    @Column(nullable = false)
    private BigDecimal esfuPlaneProy;
    @Column(nullable = false)
    private BigDecimal esfuEsReqProy;
    @Column(nullable = false)
    private BigDecimal esfuAnaDisProy;
    @Column(nullable = false)
    private BigDecimal esfuConstProy;
    @Column(nullable = false)
    private BigDecimal esfuPrueProy;
    @Column(nullable = false)
    private BigDecimal esfuImpleDesProy;
    @Column(nullable = false)
    private BigDecimal costTotProy;
    @Column(nullable = false)
    private BigDecimal costEsReqProy;
    @Column(nullable = false)
    private BigDecimal costAnaDisProy;
    @Column(nullable = false)
    private BigDecimal costConstProy;
    @Column(nullable = false)
    private BigDecimal costPrueProy;
    @Column(nullable = false)
    private BigDecimal costImpleDesProy;
    @Column(nullable = false)
    private BigDecimal tamFunProy;
    @Column(nullable = false)
    private BigDecimal fpAjusProy;
    @Column(nullable = false)
    private short medidorCertProy;
    @Column(nullable = false)
    private int expeMedMetProy;
    @Column(nullable = false)
    private short usoCase;
    @Column(nullable = false)
    private short certModelo;
    @Column(nullable = false, length = 250)
    private String comCertModelo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(nullable = false, precision = 11, scale = 2)
    private BigDecimal costPlanProy;
    @Column(nullable = false)
    private short estatus;
    @Column(nullable = false, length = 250)
    private String proposito;
    @Column(nullable = false, length = 250)
    private String alcance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<InterUP> interUPList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<ProcesoFuncional> procesoFuncionalList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<ProcesoFuncional> procesofuncionalList;
    @JoinColumn(name = "idmarcoPosUsa", referencedColumnName = "idmarcoPosUsa", nullable = false)
    @ManyToOne(optional = false)
    private MarcoPosUsa idmarcoPosUsa;
    @JoinColumn(name = "idTipoDesarrollo", referencedColumnName = "idTipodeDesarrollo", nullable = false)
    @ManyToOne(optional = false)
    private TipodeDesarrollo idTipoDesarrollo;
    @JoinColumn(name = "idtipoCapDes", referencedColumnName = "idtipoCapDes", nullable = false)
    @ManyToOne(optional = false)
    private TipoCapDes idtipoCapDes;
    @JoinColumn(name = "idarqProyecto", referencedColumnName = "idarqProyecto", nullable = false)
    @ManyToOne(optional = false)
    private ArqProyecto idarqProyecto;
    @JoinColumn(name = "idbaseDatos", referencedColumnName = "idbaseDatos", nullable = false)
    @ManyToOne(optional = false)
    private BaseDatos idbaseDatos;
    @JoinColumn(name = "idconfInfo", referencedColumnName = "idconfInfo", nullable = false)
    @ManyToOne(optional = false)
    private ConfInfo idconfInfo;
    @JoinColumn(name = "idescala", referencedColumnName = "idescala", nullable = false)
    @ManyToOne(optional = false)
    private Escala idescala;
    @JoinColumn(name = "idlenguaje", referencedColumnName = "idlenguaje", nullable = false)
    @ManyToOne(optional = false)
    private Lenguaje idlenguaje;
    @JoinColumn(name = "tamOrgUsa", referencedColumnName = "idtamOrgDes", nullable = false)
    @ManyToOne(optional = false)
    private TamOrg tamOrgUsa;
    @JoinColumn(name = "idmetDesarrollo", referencedColumnName = "idmetDesarrollo", nullable = false)
    @ManyToOne(optional = false)
    private MetDesarrollo idmetDesarrollo;
    @JoinColumn(name = "idmetMedicion", referencedColumnName = "idmetMedicion", nullable = false)
    @ManyToOne(optional = false)
    private MetMedicion idmetMedicion;
    @JoinColumn(name = "idtamOrgDes", referencedColumnName = "idtamOrgDes", nullable = false)
    @ManyToOne(optional = false)
    private TamOrg idtamOrgDes;
    @JoinColumn(name = "idmodCalidad", referencedColumnName = "idmodCalidad", nullable = false)
    @ManyToOne(optional = false)
    private ModCalidad idmodCalidad;
    @JoinColumn(name = "idsectoorOrganizacion", referencedColumnName = "idsectorOrganizacion", nullable = false)
    @ManyToOne(optional = false)
    private SectorOrganizacion idsectorOrganizacion;
    @JoinColumn(name = "idtipoOrganizacion", referencedColumnName = "idtipoOrganizacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoOrganizacion idtipoOrganizacion;
    @JoinColumn(name = "idsisOpe", referencedColumnName = "idsisOpe", nullable = false)
    @ManyToOne(optional = false)
    private SisOpe idsisOpe;

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNomProy() {
        return nomProy;
    }

    public void setNomProy(String nomProy) {
        this.nomProy = nomProy;
    }

    public String getAnioProy() {
        return anioProy;
    }

    public void setAnioProy(String anioProy) {
        this.anioProy = anioProy;
    }

    public short getOperProy() {
        return operProy;
    }

    public void setOperProy(short operProy) {
        this.operProy = operProy;
    }

    public BigDecimal getDuraProy() {
        return duraProy;
    }

    public void setDuraProy(BigDecimal duraProy) {
        this.duraProy = duraProy;
    }

    public BigDecimal getEsfuTotProy() {
        return esfuTotProy;
    }

    public void setEsfuTotProy(BigDecimal esfuTotProy) {
        this.esfuTotProy = esfuTotProy;
    }

    public BigDecimal getEsfuPlaneProy() {
        return esfuPlaneProy;
    }

    public void setEsfuPlaneProy(BigDecimal esfuPlaneProy) {
        this.esfuPlaneProy = esfuPlaneProy;
    }

    public BigDecimal getEsfuEsReqProy() {
        return esfuEsReqProy;
    }

    public void setEsfuEsReqProy(BigDecimal esfuEsReqProy) {
        this.esfuEsReqProy = esfuEsReqProy;
    }

    public BigDecimal getEsfuAnaDisProy() {
        return esfuAnaDisProy;
    }

    public void setEsfuAnaDisProy(BigDecimal esfuAnaDisProy) {
        this.esfuAnaDisProy = esfuAnaDisProy;
    }

    public BigDecimal getEsfuConstProy() {
        return esfuConstProy;
    }

    public void setEsfuConstProy(BigDecimal esfuConstProy) {
        this.esfuConstProy = esfuConstProy;
    }

    public BigDecimal getEsfuPrueProy() {
        return esfuPrueProy;
    }

    public void setEsfuPrueProy(BigDecimal esfuPrueProy) {
        this.esfuPrueProy = esfuPrueProy;
    }

    public BigDecimal getEsfuImpleDesProy() {
        return esfuImpleDesProy;
    }

    public void setEsfuImpleDesProy(BigDecimal esfuImpleDesProy) {
        this.esfuImpleDesProy = esfuImpleDesProy;
    }

    public BigDecimal getCostTotProy() {
        return costTotProy;
    }

    public void setCostTotProy(BigDecimal costTotProy) {
        this.costTotProy = costTotProy;
    }

    public BigDecimal getCostEsReqProy() {
        return costEsReqProy;
    }

    public void setCostEsReqProy(BigDecimal costEsReqProy) {
        this.costEsReqProy = costEsReqProy;
    }

    public BigDecimal getCostAnaDisProy() {
        return costAnaDisProy;
    }

    public void setCostAnaDisProy(BigDecimal costAnaDisProy) {
        this.costAnaDisProy = costAnaDisProy;
    }

    public BigDecimal getCostConstProy() {
        return costConstProy;
    }

    public void setCostConstProy(BigDecimal costConstProy) {
        this.costConstProy = costConstProy;
    }

    public BigDecimal getCostPrueProy() {
        return costPrueProy;
    }

    public void setCostPrueProy(BigDecimal costPrueProy) {
        this.costPrueProy = costPrueProy;
    }

    public BigDecimal getCostImpleDesProy() {
        return costImpleDesProy;
    }

    public void setCostImpleDesProy(BigDecimal costImpleDesProy) {
        this.costImpleDesProy = costImpleDesProy;
    }

    public BigDecimal getTamFunProy() {
        return tamFunProy;
    }

    public void setTamFunProy(BigDecimal tamFunProy) {
        this.tamFunProy = tamFunProy;
    }

    public BigDecimal getFpAjusProy() {
        return fpAjusProy;
    }

    public void setFpAjusProy(BigDecimal fpAjusProy) {
        this.fpAjusProy = fpAjusProy;
    }

    public short getMedidorCertProy() {
        return medidorCertProy;
    }

    public void setMedidorCertProy(short medidorCertProy) {
        this.medidorCertProy = medidorCertProy;
    }

    public int getExpeMedMetProy() {
        return expeMedMetProy;
    }

    public void setExpeMedMetProy(int expeMedMetProy) {
        this.expeMedMetProy = expeMedMetProy;
    }

    public short getUsoCase() {
        return usoCase;
    }

    public void setUsoCase(short usoCase) {
        this.usoCase = usoCase;
    }

    public short getCertModelo() {
        return certModelo;
    }

    public void setCertModelo(short certModelo) {
        this.certModelo = certModelo;
    }

    public String getComCertModelo() {
        return comCertModelo;
    }

    public void setComCertModelo(String comCertModelo) {
        this.comCertModelo = comCertModelo;
    }

    public BigDecimal getCostPlanProy() {
        return costPlanProy;
    }

    public void setCostPlanProy(BigDecimal costPlanProy) {
        this.costPlanProy = costPlanProy;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @XmlTransient
    public List<InterUP> getInterUPList() {
        return interUPList;
    }

    public void setInterUPList(List<InterUP> interUPList) {
        this.interUPList = interUPList;
    }

    @XmlTransient
    public List<ProcesoFuncional> getProcesoFuncionalList() {
        return procesoFuncionalList;
    }

    public void setProcesoFuncionalList(List<ProcesoFuncional> procesoFuncionalList) {
        this.procesoFuncionalList = procesoFuncionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproyecto != null ? idproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idproyecto == null && other.idproyecto != null) || (this.idproyecto != null && !this.idproyecto.equals(other.idproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Proyecto[ idproyecto=" + idproyecto + " ]";
    }

    public MarcoPosUsa getIdmarcoPosUsa() {
        return idmarcoPosUsa;
    }

    public void setIdmarcoPosUsa(MarcoPosUsa idmarcoPosUsa) {
        this.idmarcoPosUsa = idmarcoPosUsa;
    }

    public TipodeDesarrollo getIdTipoDesarrollo() {
        return idTipoDesarrollo;
    }

    public void setIdTipoDesarrollo(TipodeDesarrollo idTipoDesarrollo) {
        this.idTipoDesarrollo = idTipoDesarrollo;
    }

    public TipoCapDes getIdtipoCapDes() {
        return idtipoCapDes;
    }

    public void setIdtipoCapDes(TipoCapDes idtipoCapDes) {
        this.idtipoCapDes = idtipoCapDes;
    }

    public ArqProyecto getIdarqProyecto() {
        return idarqProyecto;
    }

    public void setIdarqProyecto(ArqProyecto idarqProyecto) {
        this.idarqProyecto = idarqProyecto;
    }

    public BaseDatos getIdbaseDatos() {
        return idbaseDatos;
    }

    public void setIdbaseDatos(BaseDatos idbaseDatos) {
        this.idbaseDatos = idbaseDatos;
    }

    public ConfInfo getIdconfInfo() {
        return idconfInfo;
    }

    public void setIdconfInfo(ConfInfo idconfInfo) {
        this.idconfInfo = idconfInfo;
    }

    public Escala getIdescala() {
        return idescala;
    }

    public void setIdescala(Escala idescala) {
        this.idescala = idescala;
    }

    public Lenguaje getIdlenguaje() {
        return idlenguaje;
    }

    public void setIdlenguaje(Lenguaje idlenguaje) {
        this.idlenguaje = idlenguaje;
    }

    public TamOrg getTamOrgUsa() {
        return tamOrgUsa;
    }

    public void setTamOrgUsa(TamOrg tamOrgUsa) {
        this.tamOrgUsa = tamOrgUsa;
    }

    public MetDesarrollo getIdmetDesarrollo() {
        return idmetDesarrollo;
    }

    public void setIdmetDesarrollo(MetDesarrollo idmetDesarrollo) {
        this.idmetDesarrollo = idmetDesarrollo;
    }

    public MetMedicion getIdmetMedicion() {
        return idmetMedicion;
    }

    public void setIdmetMedicion(MetMedicion idmetMedicion) {
        this.idmetMedicion = idmetMedicion;
    }

    public TamOrg getIdtamOrgDes() {
        return idtamOrgDes;
    }

    public void setIdtamOrgDes(TamOrg idtamOrgDes) {
        this.idtamOrgDes = idtamOrgDes;
    }

    public ModCalidad getIdmodCalidad() {
        return idmodCalidad;
    }

    public void setIdmodCalidad(ModCalidad idmodCalidad) {
        this.idmodCalidad = idmodCalidad;
    }

    public SectorOrganizacion getIdsectorOrganizacion() {
        return idsectorOrganizacion;
    }

    public void setIdsectorOrganizacion(SectorOrganizacion idsectorOrganizacion) {
        this.idsectorOrganizacion = idsectorOrganizacion;
    }

    public TipoOrganizacion getIdtipoOrganizacion() {
        return idtipoOrganizacion;
    }

    public void setIdtipoOrganizacion(TipoOrganizacion idtipoOrganizacion) {
        this.idtipoOrganizacion = idtipoOrganizacion;
    }

    public SisOpe getIdsisOpe() {
        return idsisOpe;
    }

    public void setIdsisOpe(SisOpe idsisOpe) {
        this.idsisOpe = idsisOpe;
    }

}
