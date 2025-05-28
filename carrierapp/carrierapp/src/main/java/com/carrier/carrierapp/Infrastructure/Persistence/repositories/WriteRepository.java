package com.carrier.carrierapp.Infrastructure.Persistence.repositories;

import com.carrier.carrierapp.application.repositories.IWriteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Transactional
public class WriteRepository<T> implements IWriteRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;
    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }

    public WriteRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public CompletableFuture<Boolean> addAsync(T model) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return transactionTemplate.execute(status -> {
                    entityManager.persist(model);
                    return true;
                });
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });
    }


    @Override
    public CompletableFuture<Boolean> addRangeAsync(List<T> datas) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                for (T data : datas) {
                    entityManager.persist(data);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });
    }

    @Transactional
    public boolean remove(T model) {
        try {
            entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));
            entityManager.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Transactional
    public boolean removeById(int id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            return remove(entity);
        }
        return false;
    }



    @Override
    public boolean removeRange(List<T> datas) {
        try {
            for (T data : datas) {
                remove(data);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean update(T model) {
        try {
            entityManager.merge(model);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CompletableFuture<Integer> saveAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                entityManager.flush();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        });
    }
}
