package com.carrier.carrierapp.Infrastructure.Persistence.repositories;

import com.carrier.carrierapp.application.repositories.IReadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ReadRepository<T> implements IReadRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public ReadRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {
        String query = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(query, entityClass).getResultList();
    }

    @Override
    public List<T> getWhere(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Optional<T> getSingle(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).findFirst();
    }

    @Override
    public Optional<T> getById(int id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }
}
