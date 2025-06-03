package com.carrier.carrierapp.Infrastructure.Persistence.repositories;

import com.carrier.carrierapp.application.repositories.IWriteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Transactional
public abstract class WriteRepository<T, ID> implements IWriteRepository<T, ID> {

    private final JpaRepository<T, ID> jpaRepository;
    private final EntityManager entityManager;

    public WriteRepository(EntityManager entityManager, Class<T> domainClass) {
        this.entityManager = entityManager;
        this.jpaRepository = new SimpleJpaRepository<>(domainClass, entityManager);
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        jpaRepository.delete(entity);
    }
    public boolean update(T entity) {
        try {
            jpaRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteById(ID id) {
        if (jpaRepository.existsById(id)) {
            jpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}



