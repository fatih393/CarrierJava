package com.carrier.carrierapp.Infrastructure.Persistence.repositories;

import com.carrier.carrierapp.application.repositories.IReadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Transactional(readOnly = true)
public abstract class ReadRepository<T, ID> implements IReadRepository<T, ID> {

    private final JpaRepository<T, ID> jpaRepository;
    private final JpaSpecificationExecutor<T> specificationExecutor;

    public ReadRepository(EntityManager entityManager, Class<T> domainClass) {
        this.jpaRepository = new SimpleJpaRepository<>(domainClass, entityManager);
        this.specificationExecutor = new SimpleJpaRepository<>(domainClass, entityManager); // cast edilir
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    // Specification kullanan versiyonlar
    public List<T> findWhere(Specification<T> spec) {
        return specificationExecutor.findAll(spec);
    }

    public Optional<T> findSingle(Specification<T> spec) {
        return specificationExecutor.findOne(spec);
    }
}




