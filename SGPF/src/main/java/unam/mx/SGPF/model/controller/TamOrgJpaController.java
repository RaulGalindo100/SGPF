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
import unam.mx.SGPF.model.TamOrg;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class TamOrgJpaController implements Serializable {

    public TamOrgJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TamOrg tamOrg) {
        if (tamOrg.getProyectoList() == null) {
            tamOrg.setProyectoList(new ArrayList<Proyecto>());
        }
        if (tamOrg.getProyectoList1() == null) {
            tamOrg.setProyectoList1(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : tamOrg.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            tamOrg.setProyectoList(attachedProyectoList);
            List<Proyecto> attachedProyectoList1 = new ArrayList<Proyecto>();
            for (Proyecto proyectoList1ProyectoToAttach : tamOrg.getProyectoList1()) {
                proyectoList1ProyectoToAttach = em.getReference(proyectoList1ProyectoToAttach.getClass(), proyectoList1ProyectoToAttach.getIdproyecto());
                attachedProyectoList1.add(proyectoList1ProyectoToAttach);
            }
            tamOrg.setProyectoList1(attachedProyectoList1);
            em.persist(tamOrg);
            for (Proyecto proyectoListProyecto : tamOrg.getProyectoList()) {
                TamOrg oldTamOrgUsaOfProyectoListProyecto = proyectoListProyecto.getTamOrgUsa();
                proyectoListProyecto.setTamOrgUsa(tamOrg);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldTamOrgUsaOfProyectoListProyecto != null) {
                    oldTamOrgUsaOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldTamOrgUsaOfProyectoListProyecto = em.merge(oldTamOrgUsaOfProyectoListProyecto);
                }
            }
            for (Proyecto proyectoList1Proyecto : tamOrg.getProyectoList1()) {
                TamOrg oldIdtamOrgDesOfProyectoList1Proyecto = proyectoList1Proyecto.getIdtamOrgDes();
                proyectoList1Proyecto.setIdtamOrgDes(tamOrg);
                proyectoList1Proyecto = em.merge(proyectoList1Proyecto);
                if (oldIdtamOrgDesOfProyectoList1Proyecto != null) {
                    oldIdtamOrgDesOfProyectoList1Proyecto.getProyectoList1().remove(proyectoList1Proyecto);
                    oldIdtamOrgDesOfProyectoList1Proyecto = em.merge(oldIdtamOrgDesOfProyectoList1Proyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TamOrg tamOrg) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TamOrg persistentTamOrg = em.find(TamOrg.class, tamOrg.getIdtamOrgDes());
            List<Proyecto> proyectoListOld = persistentTamOrg.getProyectoList();
            List<Proyecto> proyectoListNew = tamOrg.getProyectoList();
            List<Proyecto> proyectoList1Old = persistentTamOrg.getProyectoList1();
            List<Proyecto> proyectoList1New = tamOrg.getProyectoList1();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its tamOrgUsa field is not nullable.");
                }
            }
            for (Proyecto proyectoList1OldProyecto : proyectoList1Old) {
                if (!proyectoList1New.contains(proyectoList1OldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoList1OldProyecto + " since its idtamOrgDes field is not nullable.");
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
            tamOrg.setProyectoList(proyectoListNew);
            List<Proyecto> attachedProyectoList1New = new ArrayList<Proyecto>();
            for (Proyecto proyectoList1NewProyectoToAttach : proyectoList1New) {
                proyectoList1NewProyectoToAttach = em.getReference(proyectoList1NewProyectoToAttach.getClass(), proyectoList1NewProyectoToAttach.getIdproyecto());
                attachedProyectoList1New.add(proyectoList1NewProyectoToAttach);
            }
            proyectoList1New = attachedProyectoList1New;
            tamOrg.setProyectoList1(proyectoList1New);
            tamOrg = em.merge(tamOrg);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    TamOrg oldTamOrgUsaOfProyectoListNewProyecto = proyectoListNewProyecto.getTamOrgUsa();
                    proyectoListNewProyecto.setTamOrgUsa(tamOrg);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldTamOrgUsaOfProyectoListNewProyecto != null && !oldTamOrgUsaOfProyectoListNewProyecto.equals(tamOrg)) {
                        oldTamOrgUsaOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldTamOrgUsaOfProyectoListNewProyecto = em.merge(oldTamOrgUsaOfProyectoListNewProyecto);
                    }
                }
            }
            for (Proyecto proyectoList1NewProyecto : proyectoList1New) {
                if (!proyectoList1Old.contains(proyectoList1NewProyecto)) {
                    TamOrg oldIdtamOrgDesOfProyectoList1NewProyecto = proyectoList1NewProyecto.getIdtamOrgDes();
                    proyectoList1NewProyecto.setIdtamOrgDes(tamOrg);
                    proyectoList1NewProyecto = em.merge(proyectoList1NewProyecto);
                    if (oldIdtamOrgDesOfProyectoList1NewProyecto != null && !oldIdtamOrgDesOfProyectoList1NewProyecto.equals(tamOrg)) {
                        oldIdtamOrgDesOfProyectoList1NewProyecto.getProyectoList1().remove(proyectoList1NewProyecto);
                        oldIdtamOrgDesOfProyectoList1NewProyecto = em.merge(oldIdtamOrgDesOfProyectoList1NewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tamOrg.getIdtamOrgDes();
                if (findTamOrg(id) == null) {
                    throw new NonexistentEntityException("The tamOrg with id " + id + " no longer exists.");
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
            TamOrg tamOrg;
            try {
                tamOrg = em.getReference(TamOrg.class, id);
                tamOrg.getIdtamOrgDes();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tamOrg with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = tamOrg.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TamOrg (" + tamOrg + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable tamOrgUsa field.");
            }
            List<Proyecto> proyectoList1OrphanCheck = tamOrg.getProyectoList1();
            for (Proyecto proyectoList1OrphanCheckProyecto : proyectoList1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TamOrg (" + tamOrg + ") cannot be destroyed since the Proyecto " + proyectoList1OrphanCheckProyecto + " in its proyectoList1 field has a non-nullable idtamOrgDes field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tamOrg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TamOrg> findTamOrgEntities() {
        return findTamOrgEntities(true, -1, -1);
    }

    public List<TamOrg> findTamOrgEntities(int maxResults, int firstResult) {
        return findTamOrgEntities(false, maxResults, firstResult);
    }

    private List<TamOrg> findTamOrgEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TamOrg.class));
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

    public TamOrg findTamOrg(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TamOrg.class, id);
        } finally {
            em.close();
        }
    }

    public int getTamOrgCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TamOrg> rt = cq.from(TamOrg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
