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
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.SubprocesoGrupoDato;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author jlope
 */
public class SubprocesoGrupoDatoJpaController implements Serializable {

    public SubprocesoGrupoDatoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SubprocesoGrupoDato subprocesoGrupoDato) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GrupoDato idGrupoDato = subprocesoGrupoDato.getIdGrupoDato();
            if (idGrupoDato != null) {
                idGrupoDato = em.getReference(idGrupoDato.getClass(), idGrupoDato.getIdgrupoDato());
                subprocesoGrupoDato.setIdGrupoDato(idGrupoDato);
            }
            SubProceso idSubProceso = subprocesoGrupoDato.getIdSubProceso();
            if (idSubProceso != null) {
                idSubProceso = em.getReference(idSubProceso.getClass(), idSubProceso.getIdsubProceso());
                subprocesoGrupoDato.setIdSubProceso(idSubProceso);
            }
            em.persist(subprocesoGrupoDato);
            if (idGrupoDato != null) {
                idGrupoDato.getSubprocesoGrupoDatoList().add(subprocesoGrupoDato);
                idGrupoDato = em.merge(idGrupoDato);
            }
            if (idSubProceso != null) {
                idSubProceso.getSubprocesoGrupoDatoList().add(subprocesoGrupoDato);
                idSubProceso = em.merge(idSubProceso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SubprocesoGrupoDato subprocesoGrupoDato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SubprocesoGrupoDato persistentSubprocesoGrupoDato = em.find(SubprocesoGrupoDato.class, subprocesoGrupoDato.getIdsubprocesoGrupoDato());
            GrupoDato idGrupoDatoOld = persistentSubprocesoGrupoDato.getIdGrupoDato();
            GrupoDato idGrupoDatoNew = subprocesoGrupoDato.getIdGrupoDato();
            SubProceso idSubProcesoOld = persistentSubprocesoGrupoDato.getIdSubProceso();
            SubProceso idSubProcesoNew = subprocesoGrupoDato.getIdSubProceso();
            if (idGrupoDatoNew != null) {
                idGrupoDatoNew = em.getReference(idGrupoDatoNew.getClass(), idGrupoDatoNew.getIdgrupoDato());
                subprocesoGrupoDato.setIdGrupoDato(idGrupoDatoNew);
            }
            if (idSubProcesoNew != null) {
                idSubProcesoNew = em.getReference(idSubProcesoNew.getClass(), idSubProcesoNew.getIdsubProceso());
                subprocesoGrupoDato.setIdSubProceso(idSubProcesoNew);
            }
            subprocesoGrupoDato = em.merge(subprocesoGrupoDato);
            if (idGrupoDatoOld != null && !idGrupoDatoOld.equals(idGrupoDatoNew)) {
                idGrupoDatoOld.getSubprocesoGrupoDatoList().remove(subprocesoGrupoDato);
                idGrupoDatoOld = em.merge(idGrupoDatoOld);
            }
            if (idGrupoDatoNew != null && !idGrupoDatoNew.equals(idGrupoDatoOld)) {
                idGrupoDatoNew.getSubprocesoGrupoDatoList().add(subprocesoGrupoDato);
                idGrupoDatoNew = em.merge(idGrupoDatoNew);
            }
            if (idSubProcesoOld != null && !idSubProcesoOld.equals(idSubProcesoNew)) {
                idSubProcesoOld.getSubprocesoGrupoDatoList().remove(subprocesoGrupoDato);
                idSubProcesoOld = em.merge(idSubProcesoOld);
            }
            if (idSubProcesoNew != null && !idSubProcesoNew.equals(idSubProcesoOld)) {
                idSubProcesoNew.getSubprocesoGrupoDatoList().add(subprocesoGrupoDato);
                idSubProcesoNew = em.merge(idSubProcesoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = subprocesoGrupoDato.getIdsubprocesoGrupoDato();
                if (findSubprocesoGrupoDato(id) == null) {
                    throw new NonexistentEntityException("The subprocesoGrupoDato with id " + id + " no longer exists.");
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
            SubprocesoGrupoDato subprocesoGrupoDato;
            try {
                subprocesoGrupoDato = em.getReference(SubprocesoGrupoDato.class, id);
                subprocesoGrupoDato.getIdsubprocesoGrupoDato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The subprocesoGrupoDato with id " + id + " no longer exists.", enfe);
            }
            GrupoDato idGrupoDato = subprocesoGrupoDato.getIdGrupoDato();
            if (idGrupoDato != null) {
                idGrupoDato.getSubprocesoGrupoDatoList().remove(subprocesoGrupoDato);
                idGrupoDato = em.merge(idGrupoDato);
            }
            SubProceso idSubProceso = subprocesoGrupoDato.getIdSubProceso();
            if (idSubProceso != null) {
                idSubProceso.getSubprocesoGrupoDatoList().remove(subprocesoGrupoDato);
                idSubProceso = em.merge(idSubProceso);
            }
            em.remove(subprocesoGrupoDato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SubprocesoGrupoDato> findSubprocesoGrupoDatoEntities() {
        return findSubprocesoGrupoDatoEntities(true, -1, -1);
    }

    public List<SubprocesoGrupoDato> findSubprocesoGrupoDatoEntities(int maxResults, int firstResult) {
        return findSubprocesoGrupoDatoEntities(false, maxResults, firstResult);
    }

    private List<SubprocesoGrupoDato> findSubprocesoGrupoDatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SubprocesoGrupoDato.class));
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

    public SubprocesoGrupoDato findSubprocesoGrupoDato(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SubprocesoGrupoDato.class, id);
        } finally {
            em.close();
        }
    }

    public int getSubprocesoGrupoDatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SubprocesoGrupoDato> rt = cq.from(SubprocesoGrupoDato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
