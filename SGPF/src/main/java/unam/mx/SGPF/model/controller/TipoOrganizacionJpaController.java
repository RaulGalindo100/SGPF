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
import unam.mx.SGPF.model.TipoOrganizacion;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class TipoOrganizacionJpaController implements Serializable {

    public TipoOrganizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoOrganizacion tipoOrganizacion) {
        if (tipoOrganizacion.getProyectoList() == null) {
            tipoOrganizacion.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : tipoOrganizacion.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            tipoOrganizacion.setProyectoList(attachedProyectoList);
            em.persist(tipoOrganizacion);
            for (Proyecto proyectoListProyecto : tipoOrganizacion.getProyectoList()) {
                TipoOrganizacion oldIdtipoOrganizacionOfProyectoListProyecto = proyectoListProyecto.getIdtipoOrganizacion();
                proyectoListProyecto.setIdtipoOrganizacion(tipoOrganizacion);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdtipoOrganizacionOfProyectoListProyecto != null) {
                    oldIdtipoOrganizacionOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdtipoOrganizacionOfProyectoListProyecto = em.merge(oldIdtipoOrganizacionOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoOrganizacion tipoOrganizacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoOrganizacion persistentTipoOrganizacion = em.find(TipoOrganizacion.class, tipoOrganizacion.getIdtipoOrganizacion());
            List<Proyecto> proyectoListOld = persistentTipoOrganizacion.getProyectoList();
            List<Proyecto> proyectoListNew = tipoOrganizacion.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idtipoOrganizacion field is not nullable.");
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
            tipoOrganizacion.setProyectoList(proyectoListNew);
            tipoOrganizacion = em.merge(tipoOrganizacion);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    TipoOrganizacion oldIdtipoOrganizacionOfProyectoListNewProyecto = proyectoListNewProyecto.getIdtipoOrganizacion();
                    proyectoListNewProyecto.setIdtipoOrganizacion(tipoOrganizacion);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdtipoOrganizacionOfProyectoListNewProyecto != null && !oldIdtipoOrganizacionOfProyectoListNewProyecto.equals(tipoOrganizacion)) {
                        oldIdtipoOrganizacionOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdtipoOrganizacionOfProyectoListNewProyecto = em.merge(oldIdtipoOrganizacionOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoOrganizacion.getIdtipoOrganizacion();
                if (findTipoOrganizacion(id) == null) {
                    throw new NonexistentEntityException("The tipoOrganizacion with id " + id + " no longer exists.");
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
            TipoOrganizacion tipoOrganizacion;
            try {
                tipoOrganizacion = em.getReference(TipoOrganizacion.class, id);
                tipoOrganizacion.getIdtipoOrganizacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoOrganizacion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = tipoOrganizacion.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipoOrganizacion (" + tipoOrganizacion + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idtipoOrganizacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipoOrganizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoOrganizacion> findTipoOrganizacionEntities() {
        return findTipoOrganizacionEntities(true, -1, -1);
    }

    public List<TipoOrganizacion> findTipoOrganizacionEntities(int maxResults, int firstResult) {
        return findTipoOrganizacionEntities(false, maxResults, firstResult);
    }

    private List<TipoOrganizacion> findTipoOrganizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoOrganizacion.class));
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

    public TipoOrganizacion findTipoOrganizacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoOrganizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoOrganizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoOrganizacion> rt = cq.from(TipoOrganizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
