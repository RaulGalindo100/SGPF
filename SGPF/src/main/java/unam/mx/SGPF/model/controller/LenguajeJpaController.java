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
import unam.mx.SGPF.model.Lenguaje;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author juan
 */
public class LenguajeJpaController implements Serializable {

    public LenguajeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lenguaje lenguaje) {
        if (lenguaje.getProyectoList() == null) {
            lenguaje.setProyectoList(new ArrayList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proyecto> attachedProyectoList = new ArrayList<Proyecto>();
            for (Proyecto proyectoListProyectoToAttach : lenguaje.getProyectoList()) {
                proyectoListProyectoToAttach = em.getReference(proyectoListProyectoToAttach.getClass(), proyectoListProyectoToAttach.getIdproyecto());
                attachedProyectoList.add(proyectoListProyectoToAttach);
            }
            lenguaje.setProyectoList(attachedProyectoList);
            em.persist(lenguaje);
            for (Proyecto proyectoListProyecto : lenguaje.getProyectoList()) {
                Lenguaje oldIdlenguajeOfProyectoListProyecto = proyectoListProyecto.getIdlenguaje();
                proyectoListProyecto.setIdlenguaje(lenguaje);
                proyectoListProyecto = em.merge(proyectoListProyecto);
                if (oldIdlenguajeOfProyectoListProyecto != null) {
                    oldIdlenguajeOfProyectoListProyecto.getProyectoList().remove(proyectoListProyecto);
                    oldIdlenguajeOfProyectoListProyecto = em.merge(oldIdlenguajeOfProyectoListProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lenguaje lenguaje) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lenguaje persistentLenguaje = em.find(Lenguaje.class, lenguaje.getIdlenguaje());
            List<Proyecto> proyectoListOld = persistentLenguaje.getProyectoList();
            List<Proyecto> proyectoListNew = lenguaje.getProyectoList();
            List<String> illegalOrphanMessages = null;
            for (Proyecto proyectoListOldProyecto : proyectoListOld) {
                if (!proyectoListNew.contains(proyectoListOldProyecto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proyecto " + proyectoListOldProyecto + " since its idlenguaje field is not nullable.");
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
            lenguaje.setProyectoList(proyectoListNew);
            lenguaje = em.merge(lenguaje);
            for (Proyecto proyectoListNewProyecto : proyectoListNew) {
                if (!proyectoListOld.contains(proyectoListNewProyecto)) {
                    Lenguaje oldIdlenguajeOfProyectoListNewProyecto = proyectoListNewProyecto.getIdlenguaje();
                    proyectoListNewProyecto.setIdlenguaje(lenguaje);
                    proyectoListNewProyecto = em.merge(proyectoListNewProyecto);
                    if (oldIdlenguajeOfProyectoListNewProyecto != null && !oldIdlenguajeOfProyectoListNewProyecto.equals(lenguaje)) {
                        oldIdlenguajeOfProyectoListNewProyecto.getProyectoList().remove(proyectoListNewProyecto);
                        oldIdlenguajeOfProyectoListNewProyecto = em.merge(oldIdlenguajeOfProyectoListNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lenguaje.getIdlenguaje();
                if (findLenguaje(id) == null) {
                    throw new NonexistentEntityException("The lenguaje with id " + id + " no longer exists.");
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
            Lenguaje lenguaje;
            try {
                lenguaje = em.getReference(Lenguaje.class, id);
                lenguaje.getIdlenguaje();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lenguaje with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proyecto> proyectoListOrphanCheck = lenguaje.getProyectoList();
            for (Proyecto proyectoListOrphanCheckProyecto : proyectoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Lenguaje (" + lenguaje + ") cannot be destroyed since the Proyecto " + proyectoListOrphanCheckProyecto + " in its proyectoList field has a non-nullable idlenguaje field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(lenguaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lenguaje> findLenguajeEntities() {
        return findLenguajeEntities(true, -1, -1);
    }

    public List<Lenguaje> findLenguajeEntities(int maxResults, int firstResult) {
        return findLenguajeEntities(false, maxResults, firstResult);
    }

    private List<Lenguaje> findLenguajeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lenguaje.class));
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

    public Lenguaje findLenguaje(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lenguaje.class, id);
        } finally {
            em.close();
        }
    }

    public int getLenguajeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lenguaje> rt = cq.from(Lenguaje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
