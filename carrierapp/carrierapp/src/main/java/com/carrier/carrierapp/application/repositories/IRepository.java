package com.carrier.carrierapp.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<T> {
    Class<T> getEntityClass();
}
