package com.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDao<T> {

    private static final Logger LOGGER =
            Logger.getLogger(GenericDao.class.getName());

    private final Class<T> entityClass;
    protected EntityManager em;

    public GenericDao(Class<T> entityClass, EntityManager em) {
        this.entityClass = entityClass;
        this.em = em;
    }

    public void create(T entity) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erreur lors de la création de l'entité", e);
            throw e;
        }
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public T update(T entity) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T merged = em.merge(entity);
            tx.commit();
            return merged;
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erreur lors de la mise à jour de l'entité", e);
            throw e;
        }
    }

    public void delete(T entity) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erreur lors de la suppression de l'entité", e);
            throw e;
        }
    }

    public List<T> findAll() {
        return em.createQuery(
                "SELECT e FROM " + entityClass.getSimpleName() + " e",
                entityClass
        ).getResultList();
    }
}