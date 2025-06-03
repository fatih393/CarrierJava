package com.carrier.carrierapp.application.repositories;

import com.carrier.carrierapp.domain.entity.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IWriteRepository<T, ID> {
    T save(T entity);                   // veya add / update ayırabilirsin
    void delete(T entity);
    boolean deleteById(ID id);
     boolean update(T entity);
}



