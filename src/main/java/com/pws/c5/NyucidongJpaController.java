/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c5;

import com.pws.c5.exceptions.NonexistentEntityException;
import com.pws.c5.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author IlhamRobbS
 */
public class NyucidongJpaController implements Serializable {

    public NyucidongJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nyucidong nyucidong) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nyucidong);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNyucidong(nyucidong.getIdKendaraan()) != null) {
                throw new PreexistingEntityException("Nyucidong " + nyucidong + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nyucidong nyucidong) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nyucidong = em.merge(nyucidong);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nyucidong.getIdKendaraan();
                if (findNyucidong(id) == null) {
                    throw new NonexistentEntityException("The nyucidong with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nyucidong nyucidong;
            try {
                nyucidong = em.getReference(Nyucidong.class, id);
                nyucidong.getIdKendaraan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nyucidong with id " + id + " no longer exists.", enfe);
            }
            em.remove(nyucidong);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nyucidong> findNyucidongEntities() {
        return findNyucidongEntities(true, -1, -1);
    }

    public List<Nyucidong> findNyucidongEntities(int maxResults, int firstResult) {
        return findNyucidongEntities(false, maxResults, firstResult);
    }

    private List<Nyucidong> findNyucidongEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nyucidong.class));
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

    public Nyucidong findNyucidong(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nyucidong.class, id);
        } finally {
            em.close();
        }
    }

    public int getNyucidongCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nyucidong> rt = cq.from(Nyucidong.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
