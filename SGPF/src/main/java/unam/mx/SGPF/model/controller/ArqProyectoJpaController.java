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
import unam.mx.SGPF.model.ArqProyecto;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class ArqProyectoJpaController implements Serializable {

    public ArqProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArqProyecto arqProyecto) {
        if (arqProyecto.getProyectoList() == null) {
            arqProyecto.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : arqProyecto.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            arqProyecto.setProyectoList(attachedProyectoList);
            em.persist(arqProyecto);
            for (Proyecto proyectoListProyecto : arqProyecto.getProyectoList()) {
                ArqProyecto oldIdarqProyectoOfProyectoListProyecto = proyectoListProyecto.getIdarqProyecto();
                proyectoListProyecto.setIdarqProyecto(arqProyecto);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdarqProyectoOfProyectoListProyecto != null) {
                    oldIdarqProyectoOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdarqProyectoOfProyectoListProyecto = em.merge(oldIdarqProyectoOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArqProyecto arqProyecto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArqProyecto persistentArqProyecto = em.find(ArqProyecto.class, arqProyecto.getIdarqProyecto());
            List<Proyecto> proyectoListOld = persistentArqProyecto.getProyectoList();
            List<Proyecto> proyectoListNew = arqProyecto.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idarqProyecto field is not nullable.");
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
            arqProyecto.setProyectoList(proyectoListNew);
            arqProyecto = em.merge(arqProyecto);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    ArqProyecto oldIdarqProyectoOfProyectoListNewProyecto = proyectoListNewProyecto.getIdarqProyecto();
                    proyectoListNewProyecto.setIdarqProyecto(arqProyecto);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdarqProyectoOfProyectoListNewProyecto != null && !oldIdarqProyectoOfProyectoListNewProyecto.equals(arqProyecto)) {
                        oldIdarqProyectoOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdarqProyectoOfProyectoListNewProyecto = em.merge(oldIdarqProyectoOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = arqProyecto.getIdarqProyecto();
                if (findArqProyecto(id) == null) {
                    throw new NonexistentEntityException("The arqProyecto with id " + id + " no longer exists.");
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
            ArqProyecto arqProyecto;
            try {
                arqProyecto = em.getReference(ArqProyecto.class, id);
                arqProyecto.getIdarqProyecto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The arqProyecto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = arqProyecto.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ArqProyecto (" + arqProyecto + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idarqProyecto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(arqProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArqProyecto> findArqProyectoEntities() {
        return findArqProyectoEntities(true, -1, -1);
    }

    public List<ArqProyecto> findArqProyectoEntities(int maxResults, int firstResult) {
        return findArqProyectoEntities(false, maxResults, firstResult);
    }

    private List<ArqProyecto> findArqProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArqProyecto.class));
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

    public ArqProyecto findArqProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArqProyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getArqProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArqProyecto> rt = cq.from(ArqProyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
