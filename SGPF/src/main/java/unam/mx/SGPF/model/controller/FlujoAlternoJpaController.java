/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author jlope
 */
public class FlujoAlternoJpaController implements Serializable {

    public FlujoAlternoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FlujoAlterno flujoAlterno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accion idaccion = flujoAlterno.getIdaccion();
            if (idaccion != null) {
                idaccion = em.getReference(idaccion.getClass(), idaccion.getIdaccion());
                flujoAlterno.setIdaccion(idaccion);
            }
            GrupoDato idgrupoDato = flujoAlterno.getIdgrupoDato();
            if (idgrupoDato != null) {
                idgrupoDato = em.getReference(idgrupoDato.getClass(), idgrupoDato.getIdgrupoDato());
                flujoAlterno.setIdgrupoDato(idgrupoDato);
            }
            UsuarioFuncional idusuarioFuncional = flujoAlterno.getIdusuarioFuncional();
            if (idusuarioFuncional != null) {
                idusuarioFuncional = em.getReference(idusuarioFuncional.getClass(), idusuarioFuncional.getIdusuarioFuncional());
                flujoAlterno.setIdusuarioFuncional(idusuarioFuncional);
            }
            em.persist(flujoAlterno);
            if (idaccion != null) {
                idaccion.getFlujoAlternoList().add(flujoAlterno);
                idaccion = em.merge(idaccion);
            }
            if (idgrupoDato != null) {
                idgrupoDato.getFlujoAlternoList().add(flujoAlterno);
                idgrupoDato = em.merge(idgrupoDato);
            }
            if (idusuarioFuncional != null) {
                idusuarioFuncional.getFlujoAlternoList().add(flujoAlterno);
                idusuarioFuncional = em.merge(idusuarioFuncional);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FlujoAlterno flujoAlterno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FlujoAlterno persistentFlujoAlterno = em.find(FlujoAlterno.class, flujoAlterno.getIdflujoAlterno());
            Accion idaccionOld = persistentFlujoAlterno.getIdaccion();
            Accion idaccionNew = flujoAlterno.getIdaccion();
            GrupoDato idgrupoDatoOld = persistentFlujoAlterno.getIdgrupoDato();
            GrupoDato idgrupoDatoNew = flujoAlterno.getIdgrupoDato();
            UsuarioFuncional idusuarioFuncionalOld = persistentFlujoAlterno.getIdusuarioFuncional();
            UsuarioFuncional idusuarioFuncionalNew = flujoAlterno.getIdusuarioFuncional();
            if (idaccionNew != null) {
                idaccionNew = em.getReference(idaccionNew.getClass(), idaccionNew.getIdaccion());
                flujoAlterno.setIdaccion(idaccionNew);
            }
            if (idgrupoDatoNew != null) {
                idgrupoDatoNew = em.getReference(idgrupoDatoNew.getClass(), idgrupoDatoNew.getIdgrupoDato());
                flujoAlterno.setIdgrupoDato(idgrupoDatoNew);
            }
            if (idusuarioFuncionalNew != null) {
                idusuarioFuncionalNew = em.getReference(idusuarioFuncionalNew.getClass(), idusuarioFuncionalNew.getIdusuarioFuncional());
                flujoAlterno.setIdusuarioFuncional(idusuarioFuncionalNew);
            }
            flujoAlterno = em.merge(flujoAlterno);
            if (idaccionOld != null && !idaccionOld.equals(idaccionNew)) {
                idaccionOld.getFlujoAlternoList().remove(flujoAlterno);
                idaccionOld = em.merge(idaccionOld);
            }
            if (idaccionNew != null && !idaccionNew.equals(idaccionOld)) {
                idaccionNew.getFlujoAlternoList().add(flujoAlterno);
                idaccionNew = em.merge(idaccionNew);
            }
            if (idgrupoDatoOld != null && !idgrupoDatoOld.equals(idgrupoDatoNew)) {
                idgrupoDatoOld.getFlujoAlternoList().remove(flujoAlterno);
                idgrupoDatoOld = em.merge(idgrupoDatoOld);
            }
            if (idgrupoDatoNew != null && !idgrupoDatoNew.equals(idgrupoDatoOld)) {
                idgrupoDatoNew.getFlujoAlternoList().add(flujoAlterno);
                idgrupoDatoNew = em.merge(idgrupoDatoNew);
            }
            if (idusuarioFuncionalOld != null && !idusuarioFuncionalOld.equals(idusuarioFuncionalNew)) {
                idusuarioFuncionalOld.getFlujoAlternoList().remove(flujoAlterno);
                idusuarioFuncionalOld = em.merge(idusuarioFuncionalOld);
            }
            if (idusuarioFuncionalNew != null && !idusuarioFuncionalNew.equals(idusuarioFuncionalOld)) {
                idusuarioFuncionalNew.getFlujoAlternoList().add(flujoAlterno);
                idusuarioFuncionalNew = em.merge(idusuarioFuncionalNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = flujoAlterno.getIdflujoAlterno();
                if (findFlujoAlterno(id) == null) {
                    throw new NonexistentEntityException("The flujoAlterno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FlujoAlterno flujoAlterno;
            try {
                flujoAlterno = em.getReference(FlujoAlterno.class, id);
                flujoAlterno.getIdflujoAlterno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The flujoAlterno with id " + id + " no longer exists.", enfe);
            }
            Accion idaccion = flujoAlterno.getIdaccion();
            if (idaccion != null) {
                idaccion.getFlujoAlternoList().remove(flujoAlterno);
                idaccion = em.merge(idaccion);
            }
            GrupoDato idgrupoDato = flujoAlterno.getIdgrupoDato();
            if (idgrupoDato != null) {
                idgrupoDato.getFlujoAlternoList().remove(flujoAlterno);
                idgrupoDato = em.merge(idgrupoDato);
            }
            UsuarioFuncional idusuarioFuncional = flujoAlterno.getIdusuarioFuncional();
            if (idusuarioFuncional != null) {
                idusuarioFuncional.getFlujoAlternoList().remove(flujoAlterno);
                idusuarioFuncional = em.merge(idusuarioFuncional);
            }
            em.remove(flujoAlterno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FlujoAlterno> findFlujoAlternoEntities() {
        return findFlujoAlternoEntities(true, -1, -1);
    }

    public List<FlujoAlterno> findFlujoAlternoEntities(int maxResults, int firstResult) {
        return findFlujoAlternoEntities(false, maxResults, firstResult);
    }

    private List<FlujoAlterno> findFlujoAlternoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FlujoAlterno.class));
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

    public FlujoAlterno findFlujoAlterno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FlujoAlterno.class, id);
        } finally {
            em.close();
        }
    }

    public int getFlujoAlternoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FlujoAlterno> rt = cq.from(FlujoAlterno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    public List<FlujoAlterno> findByIdSubProceso(SubProceso idsubProceso) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("FlujoAlterno.findByIdSubProceso")
                .setParameter("idsubProceso", idsubProceso);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (List<FlujoAlterno>) q.getResultList();
    }

    public void destroy(FlujoAlterno iter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
