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
import unam.mx.SGPF.model.TipoCapDes;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class TipoCapDesJpaController implements Serializable {

    public TipoCapDesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoCapDes tipoCapDes) {
        if (tipoCapDes.getProyectoList() == null) {
            tipoCapDes.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : tipoCapDes.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            tipoCapDes.setProyectoList(attachedProyectoList);
            em.persist(tipoCapDes);
            for (Proyecto proyectoListProyecto : tipoCapDes.getProyectoList()) {
                TipoCapDes oldIdtipoCapDesOfProyectoListProyecto = proyectoListProyecto.getIdtipoCapDes();
                proyectoListProyecto.setIdtipoCapDes(tipoCapDes);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdtipoCapDesOfProyectoListProyecto != null) {
                    oldIdtipoCapDesOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdtipoCapDesOfProyectoListProyecto = em.merge(oldIdtipoCapDesOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoCapDes tipoCapDes) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoCapDes persistentTipoCapDes = em.find(TipoCapDes.class, tipoCapDes.getIdtipoCapDes());
            List<Proyecto> proyectoListOld = persistentTipoCapDes.getProyectoList();
            List<Proyecto> proyectoListNew = tipoCapDes.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idtipoCapDes field is not nullable.");
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
            tipoCapDes.setProyectoList(proyectoListNew);
            tipoCapDes = em.merge(tipoCapDes);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    TipoCapDes oldIdtipoCapDesOfProyectoListNewProyecto = proyectoListNewProyecto.getIdtipoCapDes();
                    proyectoListNewProyecto.setIdtipoCapDes(tipoCapDes);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdtipoCapDesOfProyectoListNewProyecto != null && !oldIdtipoCapDesOfProyectoListNewProyecto.equals(tipoCapDes)) {
                        oldIdtipoCapDesOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdtipoCapDesOfProyectoListNewProyecto = em.merge(oldIdtipoCapDesOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoCapDes.getIdtipoCapDes();
                if (findTipoCapDes(id) == null) {
                    throw new NonexistentEntityException("The tipoCapDes with id " + id + " no longer exists.");
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
            TipoCapDes tipoCapDes;
            try {
                tipoCapDes = em.getReference(TipoCapDes.class, id);
                tipoCapDes.getIdtipoCapDes();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoCapDes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = tipoCapDes.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipoCapDes (" + tipoCapDes + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idtipoCapDes field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipoCapDes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoCapDes> findTipoCapDesEntities() {
        return findTipoCapDesEntities(true, -1, -1);
    }

    public List<TipoCapDes> findTipoCapDesEntities(int maxResults, int firstResult) {
        return findTipoCapDesEntities(false, maxResults, firstResult);
    }

    private List<TipoCapDes> findTipoCapDesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoCapDes.class));
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

    public TipoCapDes findTipoCapDes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoCapDes.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCapDesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoCapDes> rt = cq.from(TipoCapDes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
