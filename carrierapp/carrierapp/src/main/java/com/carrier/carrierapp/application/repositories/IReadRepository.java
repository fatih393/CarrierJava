package com.carrier.carrierapp.application.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public interface IReadRepository<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    // JPA Specification tabanlı sorgular
    List<T> findWhere(Specification<T> specification);

    Optional<T> findSingle(Specification<T> specification);
}




