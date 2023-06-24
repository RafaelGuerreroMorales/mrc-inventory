package com.micro.spv.inventory.repositories;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BaseRepository {
    @PersistenceContext
    EntityManager entityManager;

    public <T> void saveEntity(T entityClass){
        entityManager.persist(entityClass);
    }

    public <T> void updateEntity(T entityClass){
        entityManager.merge(entityClass);
    }
}
