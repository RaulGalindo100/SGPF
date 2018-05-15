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
import unam.mx.SGPF.model.MarcoPosUsa;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class MarcoPosUsaJpaController implements Serializable {

    public MarcoPosUsaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MarcoPosUsa marcoPosUsa) {
        if (marcoPosUsa.getProyectoList() == null) {
            marcoPosUsa.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : marcoPosUsa.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            marcoPosUsa.setProyectoList(attachedProyectoList);
            em.persist(marcoPosUsa);
            for (Proyecto proyectoListProyecto : marcoPosUsa.getProyectoList()) {
                MarcoPosUsa oldIdmarcoPosUsaOfProyectoListProyecto = proyectoListProyecto.getIdmarcoPosUsa();
                proyectoListProyecto.setIdmarcoPosUsa(marcoPosUsa);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdmarcoPosUsaOfProyectoListProyecto != null) {
                    oldIdmarcoPosUsaOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdmarcoPosUsaOfProyectoListProyecto = em.merge(oldIdmarcoPosUsaOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MarcoPosUsa marcoPosUsa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MarcoPosUsa persistentMarcoPosUsa = em.find(MarcoPosUsa.class, marcoPosUsa.getIdmarcoPosUsa());
            List<Proyecto> proyectoListOld = persistentMarcoPosUsa.getProyectoList();
            List<Proyecto> proyectoListNew = marcoPosUsa.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idmarcoPosUsa field is not nullable.");
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
            marcoPosUsa.setProyectoList(proyectoListNew);
            marcoPosUsa = em.merge(marcoPosUsa);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    MarcoPosUsa oldIdmarcoPosUsaOfProyectoListNewProyecto = proyectoListNewProyecto.getIdmarcoPosUsa();
                    proyectoListNewProyecto.setIdmarcoPosUsa(marcoPosUsa);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdmarcoPosUsaOfProyectoListNewProyecto != null && !oldIdmarcoPosUsaOfProyectoListNewProyecto.equals(marcoPosUsa)) {
                        oldIdmarcoPosUsaOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdmarcoPosUsaOfProyectoListNewProyecto = em.merge(oldIdmarcoPosUsaOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = marcoPosUsa.getIdmarcoPosUsa();
                if (findMarcoPosUsa(id) == null) {
                    throw new NonexistentEntityException("The marcoPosUsa with id " + id + " no longer exists.");
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
            MarcoPosUsa marcoPosUsa;
            try {
                marcoPosUsa = em.getReference(MarcoPosUsa.class, id);
                marcoPosUsa.getIdmarcoPosUsa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The marcoPosUsa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = marcoPosUsa.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MarcoPosUsa (" + marcoPosUsa + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idmarcoPosUsa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(marcoPosUsa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MarcoPosUsa> findMarcoPosUsaEntities() {
        return findMarcoPosUsaEntities(true, -1, -1);
    }

    public List<MarcoPosUsa> findMarcoPosUsaEntities(int maxResults, int firstResult) {
        return findMarcoPosUsaEntities(false, maxResults, firstResult);
    }

    private List<MarcoPosUsa> findMarcoPosUsaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MarcoPosUsa.class));
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

    public MarcoPosUsa findMarcoPosUsa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MarcoPosUsa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMarcoPosUsaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MarcoPosUsa> rt = cq.from(MarcoPosUsa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
