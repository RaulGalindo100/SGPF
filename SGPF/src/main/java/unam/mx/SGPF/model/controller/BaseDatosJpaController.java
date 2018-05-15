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
import unam.mx.SGPF.model.BaseDatos;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class BaseDatosJpaController implements Serializable {

    public BaseDatosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BaseDatos baseDatos) {
        if (baseDatos.getProyectoList() == null) {
            baseDatos.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : baseDatos.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            baseDatos.setProyectoList(attachedProyectoList);
            em.persist(baseDatos);
            for (Proyecto proyectoListProyecto : baseDatos.getProyectoList()) {
                BaseDatos oldIdbaseDatosOfProyectoListProyecto = proyectoListProyecto.getIdbaseDatos();
                proyectoListProyecto.setIdbaseDatos(baseDatos);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdbaseDatosOfProyectoListProyecto != null) {
                    oldIdbaseDatosOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdbaseDatosOfProyectoListProyecto = em.merge(oldIdbaseDatosOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BaseDatos baseDatos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BaseDatos persistentBaseDatos = em.find(BaseDatos.class, baseDatos.getIdbaseDatos());
            List<Proyecto> proyectoListOld = persistentBaseDatos.getProyectoList();
            List<Proyecto> proyectoListNew = baseDatos.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idbaseDatos field is not nullable.");
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
            baseDatos.setProyectoList(proyectoListNew);
            baseDatos = em.merge(baseDatos);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    BaseDatos oldIdbaseDatosOfProyectoListNewProyecto = proyectoListNewProyecto.getIdbaseDatos();
                    proyectoListNewProyecto.setIdbaseDatos(baseDatos);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdbaseDatosOfProyectoListNewProyecto != null && !oldIdbaseDatosOfProyectoListNewProyecto.equals(baseDatos)) {
                        oldIdbaseDatosOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdbaseDatosOfProyectoListNewProyecto = em.merge(oldIdbaseDatosOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = baseDatos.getIdbaseDatos();
                if (findBaseDatos(id) == null) {
                    throw new NonexistentEntityException("The baseDatos with id " + id + " no longer exists.");
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
            BaseDatos baseDatos;
            try {
                baseDatos = em.getReference(BaseDatos.class, id);
                baseDatos.getIdbaseDatos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The baseDatos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = baseDatos.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This BaseDatos (" + baseDatos + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idbaseDatos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(baseDatos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BaseDatos> findBaseDatosEntities() {
        return findBaseDatosEntities(true, -1, -1);
    }

    public List<BaseDatos> findBaseDatosEntities(int maxResults, int firstResult) {
        return findBaseDatosEntities(false, maxResults, firstResult);
    }

    private List<BaseDatos> findBaseDatosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BaseDatos.class));
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

    public BaseDatos findBaseDatos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BaseDatos.class, id);
        } finally {
            em.close();
        }
    }

    public int getBaseDatosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BaseDatos> rt = cq.from(BaseDatos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
