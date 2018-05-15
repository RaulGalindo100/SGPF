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
import unam.mx.SGPF.model.ModCalidad;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class ModCalidadJpaController implements Serializable {

    public ModCalidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ModCalidad modCalidad) {
        if (modCalidad.getProyectoList() == null) {
            modCalidad.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : modCalidad.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            modCalidad.setProyectoList(attachedProyectoList);
            em.persist(modCalidad);
            for (Proyecto proyectoListProyecto : modCalidad.getProyectoList()) {
                ModCalidad oldIdmodCalidadOfProyectoListProyecto = proyectoListProyecto.getIdmodCalidad();
                proyectoListProyecto.setIdmodCalidad(modCalidad);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdmodCalidadOfProyectoListProyecto != null) {
                    oldIdmodCalidadOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdmodCalidadOfProyectoListProyecto = em.merge(oldIdmodCalidadOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ModCalidad modCalidad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ModCalidad persistentModCalidad = em.find(ModCalidad.class, modCalidad.getIdmodCalidad());
            List<Proyecto> proyectoListOld = persistentModCalidad.getProyectoList();
            List<Proyecto> proyectoListNew = modCalidad.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idmodCalidad field is not nullable.");
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
            modCalidad.setProyectoList(proyectoListNew);
            modCalidad = em.merge(modCalidad);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    ModCalidad oldIdmodCalidadOfProyectoListNewProyecto = proyectoListNewProyecto.getIdmodCalidad();
                    proyectoListNewProyecto.setIdmodCalidad(modCalidad);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdmodCalidadOfProyectoListNewProyecto != null && !oldIdmodCalidadOfProyectoListNewProyecto.equals(modCalidad)) {
                        oldIdmodCalidadOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdmodCalidadOfProyectoListNewProyecto = em.merge(oldIdmodCalidadOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = modCalidad.getIdmodCalidad();
                if (findModCalidad(id) == null) {
                    throw new NonexistentEntityException("The modCalidad with id " + id + " no longer exists.");
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
            ModCalidad modCalidad;
            try {
                modCalidad = em.getReference(ModCalidad.class, id);
                modCalidad.getIdmodCalidad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The modCalidad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = modCalidad.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ModCalidad (" + modCalidad + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idmodCalidad field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(modCalidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ModCalidad> findModCalidadEntities() {
        return findModCalidadEntities(true, -1, -1);
    }

    public List<ModCalidad> findModCalidadEntities(int maxResults, int firstResult) {
        return findModCalidadEntities(false, maxResults, firstResult);
    }

    private List<ModCalidad> findModCalidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ModCalidad.class));
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

    public ModCalidad findModCalidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ModCalidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getModCalidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ModCalidad> rt = cq.from(ModCalidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
