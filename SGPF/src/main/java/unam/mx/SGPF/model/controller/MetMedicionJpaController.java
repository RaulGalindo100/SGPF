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
import unam.mx.SGPF.model.MetMedicion;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class MetMedicionJpaController implements Serializable {

    public MetMedicionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MetMedicion metMedicion) {
        if (metMedicion.getProyectoList() == null) {
            metMedicion.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : metMedicion.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            metMedicion.setProyectoList(attachedProyectoList);
            em.persist(metMedicion);
            for (Proyecto proyectoListProyecto : metMedicion.getProyectoList()) {
                MetMedicion oldIdmetMedicionOfProyectoListProyecto = proyectoListProyecto.getIdmetMedicion();
                proyectoListProyecto.setIdmetMedicion(metMedicion);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdmetMedicionOfProyectoListProyecto != null) {
                    oldIdmetMedicionOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdmetMedicionOfProyectoListProyecto = em.merge(oldIdmetMedicionOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MetMedicion metMedicion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MetMedicion persistentMetMedicion = em.find(MetMedicion.class, metMedicion.getIdmetMedicion());
            List<Proyecto> proyectoListOld = persistentMetMedicion.getProyectoList();
            List<Proyecto> proyectoListNew = metMedicion.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idmetMedicion field is not nullable.");
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
            metMedicion.setProyectoList(proyectoListNew);
            metMedicion = em.merge(metMedicion);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    MetMedicion oldIdmetMedicionOfProyectoListNewProyecto = proyectoListNewProyecto.getIdmetMedicion();
                    proyectoListNewProyecto.setIdmetMedicion(metMedicion);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdmetMedicionOfProyectoListNewProyecto != null && !oldIdmetMedicionOfProyectoListNewProyecto.equals(metMedicion)) {
                        oldIdmetMedicionOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdmetMedicionOfProyectoListNewProyecto = em.merge(oldIdmetMedicionOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = metMedicion.getIdmetMedicion();
                if (findMetMedicion(id) == null) {
                    throw new NonexistentEntityException("The metMedicion with id " + id + " no longer exists.");
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
            MetMedicion metMedicion;
            try {
                metMedicion = em.getReference(MetMedicion.class, id);
                metMedicion.getIdmetMedicion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The metMedicion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = metMedicion.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MetMedicion (" + metMedicion + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idmetMedicion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(metMedicion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MetMedicion> findMetMedicionEntities() {
        return findMetMedicionEntities(true, -1, -1);
    }

    public List<MetMedicion> findMetMedicionEntities(int maxResults, int firstResult) {
        return findMetMedicionEntities(false, maxResults, firstResult);
    }

    private List<MetMedicion> findMetMedicionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MetMedicion.class));
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

    public MetMedicion findMetMedicion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MetMedicion.class, id);
        } finally {
            em.close();
        }
    }

    public int getMetMedicionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MetMedicion> rt = cq.from(MetMedicion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
