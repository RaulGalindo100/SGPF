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
import unam.mx.SGPF.model.SectorOrganizacion;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class SectorOrganizacionJpaController implements Serializable {

    public SectorOrganizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SectorOrganizacion sectorOrganizacion) {
        if (sectorOrganizacion.getProyectoList() == null) {
            sectorOrganizacion.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : sectorOrganizacion.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            sectorOrganizacion.setProyectoList(attachedProyectoList);
            em.persist(sectorOrganizacion);
            for (Proyecto proyectoListProyecto : sectorOrganizacion.getProyectoList()) {
                SectorOrganizacion oldIdsectorOrganizacionOfProyectoListProyecto = proyectoListProyecto.getIdsectorOrganizacion();
                proyectoListProyecto.setIdsectorOrganizacion(sectorOrganizacion);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdsectorOrganizacionOfProyectoListProyecto != null) {
                    oldIdsectorOrganizacionOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdsectorOrganizacionOfProyectoListProyecto = em.merge(oldIdsectorOrganizacionOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SectorOrganizacion sectorOrganizacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SectorOrganizacion persistentSectorOrganizacion = em.find(SectorOrganizacion.class, sectorOrganizacion.getIdsectorOrganizacion());
            List<Proyecto> proyectoListOld = persistentSectorOrganizacion.getProyectoList();
            List<Proyecto> proyectoListNew = sectorOrganizacion.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idsectorOrganizacion field is not nullable.");
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
            sectorOrganizacion.setProyectoList(proyectoListNew);
            sectorOrganizacion = em.merge(sectorOrganizacion);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    SectorOrganizacion oldIdsectorOrganizacionOfProyectoListNewProyecto = proyectoListNewProyecto.getIdsectorOrganizacion();
                    proyectoListNewProyecto.setIdsectorOrganizacion(sectorOrganizacion);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdsectorOrganizacionOfProyectoListNewProyecto != null && !oldIdsectorOrganizacionOfProyectoListNewProyecto.equals(sectorOrganizacion)) {
                        oldIdsectorOrganizacionOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdsectorOrganizacionOfProyectoListNewProyecto = em.merge(oldIdsectorOrganizacionOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sectorOrganizacion.getIdsectorOrganizacion();
                if (findSectorOrganizacion(id) == null) {
                    throw new NonexistentEntityException("The sectorOrganizacion with id " + id + " no longer exists.");
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
            SectorOrganizacion sectorOrganizacion;
            try {
                sectorOrganizacion = em.getReference(SectorOrganizacion.class, id);
                sectorOrganizacion.getIdsectorOrganizacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sectorOrganizacion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = sectorOrganizacion.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SectorOrganizacion (" + sectorOrganizacion + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idsectorOrganizacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(sectorOrganizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SectorOrganizacion> findSectorOrganizacionEntities() {
        return findSectorOrganizacionEntities(true, -1, -1);
    }

    public List<SectorOrganizacion> findSectorOrganizacionEntities(int maxResults, int firstResult) {
        return findSectorOrganizacionEntities(false, maxResults, firstResult);
    }

    private List<SectorOrganizacion> findSectorOrganizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SectorOrganizacion.class));
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

    public SectorOrganizacion findSectorOrganizacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SectorOrganizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getSectorOrganizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SectorOrganizacion> rt = cq.from(SectorOrganizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
