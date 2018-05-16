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
import unam.mx.SGPF.model.Escala;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class EscalaJpaController implements Serializable {

    public EscalaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Escala escala) {
        if (escala.getProyectoList() == null) {
            escala.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : escala.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            escala.setProyectoList(attachedProyectoList);
            em.persist(escala);
            for (Proyecto proyectoListProyecto : escala.getProyectoList()) {
                Escala oldIdescalaOfProyectoListProyecto = proyectoListProyecto.getIdescala();
                proyectoListProyecto.setIdescala(escala);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdescalaOfProyectoListProyecto != null) {
                    oldIdescalaOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdescalaOfProyectoListProyecto = em.merge(oldIdescalaOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Escala escala) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Escala persistentEscala = em.find(Escala.class, escala.getIdescala());
            List<Proyecto> proyectoListOld = persistentEscala.getProyectoList();
            List<Proyecto> proyectoListNew = escala.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idescala field is not nullable.");
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
            escala.setProyectoList(proyectoListNew);
            escala = em.merge(escala);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    Escala oldIdescalaOfProyectoListNewProyecto = proyectoListNewProyecto.getIdescala();
                    proyectoListNewProyecto.setIdescala(escala);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdescalaOfProyectoListNewProyecto != null && !oldIdescalaOfProyectoListNewProyecto.equals(escala)) {
                        oldIdescalaOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdescalaOfProyectoListNewProyecto = em.merge(oldIdescalaOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = escala.getIdescala();
                if (findEscala(id) == null) {
                    throw new NonexistentEntityException("The escala with id " + id + " no longer exists.");
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
            Escala escala;
            try {
                escala = em.getReference(Escala.class, id);
                escala.getIdescala();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The escala with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = escala.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Escala (" + escala + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idescala field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(escala);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Escala> findEscalaEntities() {
        return findEscalaEntities(true, -1, -1);
    }

    public List<Escala> findEscalaEntities(int maxResults, int firstResult) {
        return findEscalaEntities(false, maxResults, firstResult);
    }

    private List<Escala> findEscalaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Escala.class));
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

    public Escala findEscala(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Escala.class, id);
        } finally {
            em.close();
        }
    }

    public int getEscalaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Escala> rt = cq.from(Escala.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
