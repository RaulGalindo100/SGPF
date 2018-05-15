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
import unam.mx.SGPF.model.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import unam.mx.SGPF.model.SisOpe;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class SisOpeJpaController implements Serializable {

    public SisOpeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SisOpe sisOpe) {
        if (sisOpe.getProyectoList() == null) {
            sisOpe.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : sisOpe.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            sisOpe.setProyectoList(attachedProyectoList);
            em.persist(sisOpe);
            for (Proyecto proyectoListProyecto : sisOpe.getProyectoList()) {
                SisOpe oldIdsisOpeOfProyectoListProyecto = proyectoListProyecto.getIdsisOpe();
                proyectoListProyecto.setIdsisOpe(sisOpe);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdsisOpeOfProyectoListProyecto != null) {
                    oldIdsisOpeOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdsisOpeOfProyectoListProyecto = em.merge(oldIdsisOpeOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SisOpe sisOpe) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SisOpe persistentSisOpe = em.find(SisOpe.class, sisOpe.getIdsisOpe());
            List<Proyecto> proyectoListOld = persistentSisOpe.getProyectoList();
            List<Proyecto> proyectoListNew = sisOpe.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idsisOpe field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Proyecto> attachedProyectoListNew = new ArrayList<Proyecto>();
            for (Proyecto proyectoListNewProyectoToAttach : proyectoListNew) {
                proyectoListNewProyectoToAttach = em.getReference(proyectoListNewProyectoToAttach.getClass(), proyectoListNewProyectoToAttach.getIdproyecto());
                attachedProyectoListNew.add(proyectoListNewProyectoToAttach);
            }
            proyectoListNew = attachedProyectoListNew;
            sisOpe.setProyectoList(proyectoListNew);
            sisOpe = em.merge(sisOpe);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    SisOpe oldIdsisOpeOfProyectoListNewProyecto = proyectoListNewProyecto.getIdsisOpe();
                    proyectoListNewProyecto.setIdsisOpe(sisOpe);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdsisOpeOfProyectoListNewProyecto != null && !oldIdsisOpeOfProyectoListNewProyecto.equals(sisOpe)) {
                        oldIdsisOpeOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdsisOpeOfProyectoListNewProyecto = em.merge(oldIdsisOpeOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sisOpe.getIdsisOpe();
                if (findSisOpe(id) == null) {
                    throw new NonexistentEntityException("The sisOpe with id " + id + " no longer exists.");
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
            SisOpe sisOpe;
            try {
                sisOpe = em.getReference(SisOpe.class, id);
                sisOpe.getIdsisOpe();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sisOpe with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = sisOpe.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SisOpe (" + sisOpe + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idsisOpe field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(sisOpe);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SisOpe> findSisOpeEntities() {
        return findSisOpeEntities(true, -1, -1);
    }

    public List<SisOpe> findSisOpeEntities(int maxResults, int firstResult) {
        return findSisOpeEntities(false, maxResults, firstResult);
    }

    private List<SisOpe> findSisOpeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SisOpe.class));
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

    public SisOpe findSisOpe(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SisOpe.class, id);
        } finally {
            em.close();
        }
    }

    public int getSisOpeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SisOpe> rt = cq.from(SisOpe.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
