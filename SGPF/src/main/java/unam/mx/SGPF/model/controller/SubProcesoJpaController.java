/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.SubprocesoGrupoDato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author jlope
 */
public class SubProcesoJpaController implements Serializable {

    public SubProcesoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SubProceso subProceso) {
        if (subProceso.getSubprocesoGrupoDatoList() == null) {
            subProceso.setSubprocesoGrupoDatoList(new ArrayList<SubprocesoGrupoDato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accion idaccion = subProceso.getIdaccion();
            if (idaccion != null) {
                idaccion = em.getReference(idaccion.getClass(), idaccion.getIdaccion());
                subProceso.setIdaccion(idaccion);
            }
            GrupoDato idgrupoDato = subProceso.getIdgrupoDato();
            if (idgrupoDato != null) {
                idgrupoDato = em.getReference(idgrupoDato.getClass(), idgrupoDato.getIdgrupoDato());
                subProceso.setIdgrupoDato(idgrupoDato);
            }
            ProcesoFuncional idprocesoFuncional = subProceso.getIdprocesoFuncional();
            if (idprocesoFuncional != null) {
                idprocesoFuncional = em.getReference(idprocesoFuncional.getClass(), idprocesoFuncional.getIdprocesoFuncional());
                subProceso.setIdprocesoFuncional(idprocesoFuncional);
            }
            UsuarioFuncional idusuarioFuncional = subProceso.getIdusuarioFuncional();
            if (idusuarioFuncional != null) {
                idusuarioFuncional = em.getReference(idusuarioFuncional.getClass(), idusuarioFuncional.getIdusuarioFuncional());
                subProceso.setIdusuarioFuncional(idusuarioFuncional);
            }
            List<SubprocesoGrupoDato> attachedSubprocesoGrupoDatoList = new ArrayList<SubprocesoGrupoDato>();
            for (SubprocesoGrupoDato subprocesoGrupoDatoListSubprocesoGrupoDatoToAttach : subProceso.getSubprocesoGrupoDatoList()) {
                subprocesoGrupoDatoListSubprocesoGrupoDatoToAttach = em.getReference(subprocesoGrupoDatoListSubprocesoGrupoDatoToAttach.getClass(), subprocesoGrupoDatoListSubprocesoGrupoDatoToAttach.getIdsubprocesoGrupoDato());
                attachedSubprocesoGrupoDatoList.add(subprocesoGrupoDatoListSubprocesoGrupoDatoToAttach);
            }
            subProceso.setSubprocesoGrupoDatoList(attachedSubprocesoGrupoDatoList);
            em.persist(subProceso);
            if (idaccion != null) {
                idaccion.getSubProcesoList().add(subProceso);
                idaccion = em.merge(idaccion);
            }
            if (idgrupoDato != null) {
                idgrupoDato.getSubProcesoList().add(subProceso);
                idgrupoDato = em.merge(idgrupoDato);
            }
            if (idprocesoFuncional != null) {
                idprocesoFuncional.getSubProcesoList().add(subProceso);
                idprocesoFuncional = em.merge(idprocesoFuncional);
            }
            if (idusuarioFuncional != null) {
                idusuarioFuncional.getSubProcesoList().add(subProceso);
                idusuarioFuncional = em.merge(idusuarioFuncional);
            }
            for (SubprocesoGrupoDato subprocesoGrupoDatoListSubprocesoGrupoDato : subProceso.getSubprocesoGrupoDatoList()) {
                SubProceso oldIdSubProcesoOfSubprocesoGrupoDatoListSubprocesoGrupoDato = subprocesoGrupoDatoListSubprocesoGrupoDato.getIdSubProceso();
                subprocesoGrupoDatoListSubprocesoGrupoDato.setIdSubProceso(subProceso);
                subprocesoGrupoDatoListSubprocesoGrupoDato = em.merge(subprocesoGrupoDatoListSubprocesoGrupoDato);
                if (oldIdSubProcesoOfSubprocesoGrupoDatoListSubprocesoGrupoDato != null) {
                    oldIdSubProcesoOfSubprocesoGrupoDatoListSubprocesoGrupoDato.getSubprocesoGrupoDatoList().remove(subprocesoGrupoDatoListSubprocesoGrupoDato);
                    oldIdSubProcesoOfSubprocesoGrupoDatoListSubprocesoGrupoDato = em.merge(oldIdSubProcesoOfSubprocesoGrupoDatoListSubprocesoGrupoDato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SubProceso subProceso) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SubProceso persistentSubProceso = em.find(SubProceso.class, subProceso.getIdsubProceso());
            Accion idaccionOld = persistentSubProceso.getIdaccion();
            Accion idaccionNew = subProceso.getIdaccion();
            GrupoDato idgrupoDatoOld = persistentSubProceso.getIdgrupoDato();
            GrupoDato idgrupoDatoNew = subProceso.getIdgrupoDato();
            ProcesoFuncional idprocesoFuncionalOld = persistentSubProceso.getIdprocesoFuncional();
            ProcesoFuncional idprocesoFuncionalNew = subProceso.getIdprocesoFuncional();
            UsuarioFuncional idusuarioFuncionalOld = persistentSubProceso.getIdusuarioFuncional();
            UsuarioFuncional idusuarioFuncionalNew = subProceso.getIdusuarioFuncional();
            List<SubprocesoGrupoDato> subprocesoGrupoDatoListOld = persistentSubProceso.getSubprocesoGrupoDatoList();
            List<SubprocesoGrupoDato> subprocesoGrupoDatoListNew = subProceso.getSubprocesoGrupoDatoList();
            List<String> illegalOrphanMessages = null;
            for (SubprocesoGrupoDato subprocesoGrupoDatoListOldSubprocesoGrupoDato : subprocesoGrupoDatoListOld) {
                if (!subprocesoGrupoDatoListNew.contains(subprocesoGrupoDatoListOldSubprocesoGrupoDato)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SubprocesoGrupoDato " + subprocesoGrupoDatoListOldSubprocesoGrupoDato + " since its idSubProceso field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idaccionNew != null) {
                idaccionNew = em.getReference(idaccionNew.getClass(), idaccionNew.getIdaccion());
                subProceso.setIdaccion(idaccionNew);
            }
            if (idgrupoDatoNew != null) {
                idgrupoDatoNew = em.getReference(idgrupoDatoNew.getClass(), idgrupoDatoNew.getIdgrupoDato());
                subProceso.setIdgrupoDato(idgrupoDatoNew);
            }
            if (idprocesoFuncionalNew != null) {
                idprocesoFuncionalNew = em.getReference(idprocesoFuncionalNew.getClass(), idprocesoFuncionalNew.getIdprocesoFuncional());
                subProceso.setIdprocesoFuncional(idprocesoFuncionalNew);
            }
            if (idusuarioFuncionalNew != null) {
                idusuarioFuncionalNew = em.getReference(idusuarioFuncionalNew.getClass(), idusuarioFuncionalNew.getIdusuarioFuncional());
                subProceso.setIdusuarioFuncional(idusuarioFuncionalNew);
            }
            List<SubprocesoGrupoDato> attachedSubprocesoGrupoDatoListNew = new ArrayList<SubprocesoGrupoDato>();
            for (SubprocesoGrupoDato subprocesoGrupoDatoListNewSubprocesoGrupoDatoToAttach : subprocesoGrupoDatoListNew) {
                subprocesoGrupoDatoListNewSubprocesoGrupoDatoToAttach = em.getReference(subprocesoGrupoDatoListNewSubprocesoGrupoDatoToAttach.getClass(), subprocesoGrupoDatoListNewSubprocesoGrupoDatoToAttach.getIdsubprocesoGrupoDato());
                attachedSubprocesoGrupoDatoListNew.add(subprocesoGrupoDatoListNewSubprocesoGrupoDatoToAttach);
            }
            subprocesoGrupoDatoListNew = attachedSubprocesoGrupoDatoListNew;
            subProceso.setSubprocesoGrupoDatoList(subprocesoGrupoDatoListNew);
            subProceso = em.merge(subProceso);
            if (idaccionOld != null && !idaccionOld.equals(idaccionNew)) {
                idaccionOld.getSubProcesoList().remove(subProceso);
                idaccionOld = em.merge(idaccionOld);
            }
            if (idaccionNew != null && !idaccionNew.equals(idaccionOld)) {
                idaccionNew.getSubProcesoList().add(subProceso);
                idaccionNew = em.merge(idaccionNew);
            }
            if (idgrupoDatoOld != null && !idgrupoDatoOld.equals(idgrupoDatoNew)) {
                idgrupoDatoOld.getSubProcesoList().remove(subProceso);
                idgrupoDatoOld = em.merge(idgrupoDatoOld);
            }
            if (idgrupoDatoNew != null && !idgrupoDatoNew.equals(idgrupoDatoOld)) {
                idgrupoDatoNew.getSubProcesoList().add(subProceso);
                idgrupoDatoNew = em.merge(idgrupoDatoNew);
            }
            if (idprocesoFuncionalOld != null && !idprocesoFuncionalOld.equals(idprocesoFuncionalNew)) {
                idprocesoFuncionalOld.getSubProcesoList().remove(subProceso);
                idprocesoFuncionalOld = em.merge(idprocesoFuncionalOld);
            }
            if (idprocesoFuncionalNew != null && !idprocesoFuncionalNew.equals(idprocesoFuncionalOld)) {
                idprocesoFuncionalNew.getSubProcesoList().add(subProceso);
                idprocesoFuncionalNew = em.merge(idprocesoFuncionalNew);
            }
            if (idusuarioFuncionalOld != null && !idusuarioFuncionalOld.equals(idusuarioFuncionalNew)) {
                idusuarioFuncionalOld.getSubProcesoList().remove(subProceso);
                idusuarioFuncionalOld = em.merge(idusuarioFuncionalOld);
            }
            if (idusuarioFuncionalNew != null && !idusuarioFuncionalNew.equals(idusuarioFuncionalOld)) {
                idusuarioFuncionalNew.getSubProcesoList().add(subProceso);
                idusuarioFuncionalNew = em.merge(idusuarioFuncionalNew);
            }
            for (SubprocesoGrupoDato subprocesoGrupoDatoListNewSubprocesoGrupoDato : subprocesoGrupoDatoListNew) {
                if (!subprocesoGrupoDatoListOld.contains(subprocesoGrupoDatoListNewSubprocesoGrupoDato)) {
                    SubProceso oldIdSubProcesoOfSubprocesoGrupoDatoListNewSubprocesoGrupoDato = subprocesoGrupoDatoListNewSubprocesoGrupoDato.getIdSubProceso();
                    subprocesoGrupoDatoListNewSubprocesoGrupoDato.setIdSubProceso(subProceso);
                    subprocesoGrupoDatoListNewSubprocesoGrupoDato = em.merge(subprocesoGrupoDatoListNewSubprocesoGrupoDato);
                    if (oldIdSubProcesoOfSubprocesoGrupoDatoListNewSubprocesoGrupoDato != null && !oldIdSubProcesoOfSubprocesoGrupoDatoListNewSubprocesoGrupoDato.equals(subProceso)) {
                        oldIdSubProcesoOfSubprocesoGrupoDatoListNewSubprocesoGrupoDato.getSubprocesoGrupoDatoList().remove(subprocesoGrupoDatoListNewSubprocesoGrupoDato);
                        oldIdSubProcesoOfSubprocesoGrupoDatoListNewSubprocesoGrupoDato = em.merge(oldIdSubProcesoOfSubprocesoGrupoDatoListNewSubprocesoGrupoDato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = subProceso.getIdsubProceso();
                if (findSubProceso(id) == null) {
                    throw new NonexistentEntityException("The subProceso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SubProceso subProceso;
            try {
                subProceso = em.getReference(SubProceso.class, id);
                subProceso.getIdsubProceso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The subProceso with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SubprocesoGrupoDato> subprocesoGrupoDatoListOrphanCheck = subProceso.getSubprocesoGrupoDatoList();
            for (SubprocesoGrupoDato subprocesoGrupoDatoListOrphanCheckSubprocesoGrupoDato : subprocesoGrupoDatoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SubProceso (" + subProceso + ") cannot be destroyed since the SubprocesoGrupoDato " + subprocesoGrupoDatoListOrphanCheckSubprocesoGrupoDato + " in its subprocesoGrupoDatoList field has a non-nullable idSubProceso field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Accion idaccion = subProceso.getIdaccion();
            if (idaccion != null) {
                idaccion.getSubProcesoList().remove(subProceso);
                idaccion = em.merge(idaccion);
            }
            GrupoDato idgrupoDato = subProceso.getIdgrupoDato();
            if (idgrupoDato != null) {
                idgrupoDato.getSubProcesoList().remove(subProceso);
                idgrupoDato = em.merge(idgrupoDato);
            }
            ProcesoFuncional idprocesoFuncional = subProceso.getIdprocesoFuncional();
            if (idprocesoFuncional != null) {
                idprocesoFuncional.getSubProcesoList().remove(subProceso);
                idprocesoFuncional = em.merge(idprocesoFuncional);
            }
            UsuarioFuncional idusuarioFuncional = subProceso.getIdusuarioFuncional();
            if (idusuarioFuncional != null) {
                idusuarioFuncional.getSubProcesoList().remove(subProceso);
                idusuarioFuncional = em.merge(idusuarioFuncional);
            }
            em.remove(subProceso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SubProceso> findSubProcesoEntities() {
        return findSubProcesoEntities(true, -1, -1);
    }

    public List<SubProceso> findSubProcesoEntities(int maxResults, int firstResult) {
        return findSubProcesoEntities(false, maxResults, firstResult);
    }

    private List<SubProceso> findSubProcesoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SubProceso.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public SubProceso findSubProceso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SubProceso.class, id);
        } finally {
            em.close();
        }
    }

    public int getSubProcesoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SubProceso> rt = cq.from(SubProceso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<SubProceso> findSPByIdProcesoFuncional(Integer idPF){
    	EntityManager em = getEntityManager();
    	ProcesoFuncional pf = new ProcesoFuncional(idPF);
    	Query q = em.createNamedQuery("SubProceso.findSPByIdProcesoFuncional")
    			.setParameter("idPF", pf);
    	return q.getResultList();
    }
    
    public List<SubProceso> findSPByActividadyIdPF(String NombreActividad, Integer PF){
    	EntityManager em = getEntityManager();
    	ProcesoFuncional pf = new ProcesoFuncional(PF);
    	Query q = em.createNamedQuery("SubProceso.findSPByActividadyIdPF")
    			.setParameter("idprocesoFuncional", pf).setParameter("actividad", NombreActividad);
    	return q.getResultList();
    }
    
    public List<SubProceso> findSPByActividadyPF(String NombreActividad, ProcesoFuncional PF){
    	EntityManager em = getEntityManager();
    	Query q = em.createNamedQuery("SubProceso.findSPByActividadyPF")
    			.setParameter("procesoFuncional", PF).setParameter("actividad", NombreActividad);
    	return q.getResultList();
    }
    
    public List<SubProceso> findSPByActividadMayorAIndice(int indice, ProcesoFuncional idPF, String actividad){
    	EntityManager em = getEntityManager();
        //System.out.println("Parametros recibidos son INDICE >> "+indice+" ACTIVIDAD >> "+actividad+" PF >> "+idPF.toString()
        //);
    	Query q = em.createNamedQuery("SubProceso.findSPByActividadMayorAIndice")
    			.setParameter("indice",indice)
    			.setParameter("actividad",actividad)
                        .setParameter("idPF", idPF);
    	return q.getResultList();
    }
    
    public List<SubProceso> findSPByActividad_PF(ProcesoFuncional PF){
    	EntityManager em = getEntityManager();
        int indice = 1;
    	Query q = em.createNamedQuery("SubProceso.findSPByActividad_PF")
    			.setParameter("procesoFuncional", PF)
                        .setParameter("indice", indice);
    	return q.getResultList();
    }
    
    
    public List<SubProceso> findSPByActividad(String actividad){
    	EntityManager em = getEntityManager();
    	SubProceso subProceso = new SubProceso();
        subProceso.setActividad(actividad);
    	Query q = em.createNamedQuery("SubProceso.findSPByActividad")
                .setParameter("actividad", actividad);
    	return q.getResultList();
    }
    
    public List<SubProceso> findSPByIDPForder(Integer idPF){
    	EntityManager em = getEntityManager();
    	ProcesoFuncional pf = new ProcesoFuncional(idPF);
    	Query q = em.createNamedQuery("SubProceso.findSPByIDPForder")
    			.setParameter("idPF", pf);
    	return q.getResultList();
    }
    
    public List<SubProceso> findSPByIDPForderFlujoAl(Integer idPF){
    	EntityManager em = getEntityManager();
    	ProcesoFuncional pf = new ProcesoFuncional(idPF);
        Short flujo = 1;
    	Query q = em.createNamedQuery("SubProceso.findSPByIDPForderFlujoAl")
    			.setParameter("idPF", pf)
    			.setParameter("flujoAl", flujo);
    	return q.getResultList();
    }
    
     public List<SubProceso> findSPByIdProcesoFuncionalR(Integer idPF){
   	EntityManager em = getEntityManager();
   	ProcesoFuncional pf = new ProcesoFuncional(idPF);
   	Query q = em.createNamedQuery("SubProceso.findSPByIdProcesoFuncional")
   	.setParameter("idPF", pf);
   	return q.getResultList();
   }    
     public List<SubProceso> findAddUp(Integer idPF,String Actividad, Integer indice){
   	EntityManager em = getEntityManager();
   	ProcesoFuncional pf = new ProcesoFuncional(idPF);
   	Query q = em.createNamedQuery("SubProceso.findAddUp")
   	.setParameter("idPF", pf)
        .setParameter("act", Actividad)
        .setParameter("ind", indice);
   	return q.getResultList();
   }    
    public List<SubProceso> findAddDown(Integer idPF,String Actividad, Integer indice){
   	EntityManager em = getEntityManager();
   	ProcesoFuncional pf = new ProcesoFuncional(idPF);
   	Query q = em.createNamedQuery("SubProceso.findAddDown")
   	.setParameter("idPF", pf)
        .setParameter("act", Actividad)
        .setParameter("ind", indice);
   	return q.getResultList();
   }    
}
