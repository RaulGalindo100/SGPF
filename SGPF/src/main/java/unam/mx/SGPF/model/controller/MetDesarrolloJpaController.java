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
import unam.mx.SGPF.model.MetDesarrollo;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class MetDesarrolloJpaController implements Serializable {

    public MetDesarrolloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MetDesarrollo metDesarrollo) {
        if (metDesarrollo.getProyectoList() == null) {
            metDesarrollo.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : metDesarrollo.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            metDesarrollo.setProyectoList(attachedProyectoList);
            em.persist(metDesarrollo);
            for (Proyecto proyectoListProyecto : metDesarrollo.getProyectoList()) {
                MetDesarrollo oldIdmetDesarrolloOfProyectoListProyecto = proyectoListProyecto.getIdmetDesarrollo();
                proyectoListProyecto.setIdmetDesarrollo(metDesarrollo);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdmetDesarrolloOfProyectoListProyecto != null) {
                    oldIdmetDesarrolloOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdmetDesarrolloOfProyectoListProyecto = em.merge(oldIdmetDesarrolloOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MetDesarrollo metDesarrollo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MetDesarrollo persistentMetDesarrollo = em.find(MetDesarrollo.class, metDesarrollo.getIdmetDesarrollo());
            List<Proyecto> proyectoListOld = persistentMetDesarrollo.getProyectoList();
            List<Proyecto> proyectoListNew = metDesarrollo.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idmetDesarrollo field is not nullable.");
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
            metDesarrollo.setProyectoList(proyectoListNew);
            metDesarrollo = em.merge(metDesarrollo);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    MetDesarrollo oldIdmetDesarrolloOfProyectoListNewProyecto = proyectoListNewProyecto.getIdmetDesarrollo();
                    proyectoListNewProyecto.setIdmetDesarrollo(metDesarrollo);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdmetDesarrolloOfProyectoListNewProyecto != null && !oldIdmetDesarrolloOfProyectoListNewProyecto.equals(metDesarrollo)) {
                        oldIdmetDesarrolloOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdmetDesarrolloOfProyectoListNewProyecto = em.merge(oldIdmetDesarrolloOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = metDesarrollo.getIdmetDesarrollo();
                if (findMetDesarrollo(id) == null) {
                    throw new NonexistentEntityException("The metDesarrollo with id " + id + " no longer exists.");
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
            MetDesarrollo metDesarrollo;
            try {
                metDesarrollo = em.getReference(MetDesarrollo.class, id);
                metDesarrollo.getIdmetDesarrollo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The metDesarrollo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = metDesarrollo.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MetDesarrollo (" + metDesarrollo + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idmetDesarrollo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(metDesarrollo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MetDesarrollo> findMetDesarrolloEntities() {
        return findMetDesarrolloEntities(true, -1, -1);
    }

    public List<MetDesarrollo> findMetDesarrolloEntities(int maxResults, int firstResult) {
        return findMetDesarrolloEntities(false, maxResults, firstResult);
    }

    private List<MetDesarrollo> findMetDesarrolloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MetDesarrollo.class));
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

    public MetDesarrollo findMetDesarrollo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MetDesarrollo.class, id);
        } finally {
            em.close();
        }
    }

    public int getMetDesarrolloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MetDesarrollo> rt = cq.from(MetDesarrollo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
