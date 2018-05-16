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
import unam.mx.SGPF.model.TipodeDesarrollo;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class TipodeDesarrolloJpaController implements Serializable {

    public TipodeDesarrolloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipodeDesarrollo tipodeDesarrollo) {
        if (tipodeDesarrollo.getProyectoList() == null) {
            tipodeDesarrollo.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : tipodeDesarrollo.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            tipodeDesarrollo.setProyectoList(attachedProyectoList);
            em.persist(tipodeDesarrollo);
            for (Proyecto proyectoListProyecto : tipodeDesarrollo.getProyectoList()) {
                TipodeDesarrollo oldIdTipoDesarrolloOfProyectoListProyecto = proyectoListProyecto.getIdTipoDesarrollo();
                proyectoListProyecto.setIdTipoDesarrollo(tipodeDesarrollo);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdTipoDesarrolloOfProyectoListProyecto != null) {
                    oldIdTipoDesarrolloOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdTipoDesarrolloOfProyectoListProyecto = em.merge(oldIdTipoDesarrolloOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipodeDesarrollo tipodeDesarrollo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipodeDesarrollo persistentTipodeDesarrollo = em.find(TipodeDesarrollo.class, tipodeDesarrollo.getIdTipodeDesarrollo());
            List<Proyecto> proyectoListOld = persistentTipodeDesarrollo.getProyectoList();
            List<Proyecto> proyectoListNew = tipodeDesarrollo.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idTipoDesarrollo field is not nullable.");
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
            tipodeDesarrollo.setProyectoList(proyectoListNew);
            tipodeDesarrollo = em.merge(tipodeDesarrollo);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    TipodeDesarrollo oldIdTipoDesarrolloOfProyectoListNewProyecto = proyectoListNewProyecto.getIdTipoDesarrollo();
                    proyectoListNewProyecto.setIdTipoDesarrollo(tipodeDesarrollo);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdTipoDesarrolloOfProyectoListNewProyecto != null && !oldIdTipoDesarrolloOfProyectoListNewProyecto.equals(tipodeDesarrollo)) {
                        oldIdTipoDesarrolloOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdTipoDesarrolloOfProyectoListNewProyecto = em.merge(oldIdTipoDesarrolloOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipodeDesarrollo.getIdTipodeDesarrollo();
                if (findTipodeDesarrollo(id) == null) {
                    throw new NonexistentEntityException("The tipodeDesarrollo with id " + id + " no longer exists.");
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
            TipodeDesarrollo tipodeDesarrollo;
            try {
                tipodeDesarrollo = em.getReference(TipodeDesarrollo.class, id);
                tipodeDesarrollo.getIdTipodeDesarrollo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipodeDesarrollo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = tipodeDesarrollo.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipodeDesarrollo (" + tipodeDesarrollo + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idTipoDesarrollo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipodeDesarrollo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipodeDesarrollo> findTipodeDesarrolloEntities() {
        return findTipodeDesarrolloEntities(true, -1, -1);
    }

    public List<TipodeDesarrollo> findTipodeDesarrolloEntities(int maxResults, int firstResult) {
        return findTipodeDesarrolloEntities(false, maxResults, firstResult);
    }

    private List<TipodeDesarrollo> findTipodeDesarrolloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipodeDesarrollo.class));
            Query q = em.createQuery(cq);
            System.out.print("Haciendo la consulta");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipodeDesarrollo findTipodeDesarrollo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipodeDesarrollo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipodeDesarrolloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipodeDesarrollo> rt = cq.from(TipodeDesarrollo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
