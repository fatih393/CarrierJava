package com.carrier.carrierapp.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public interface IReadRepository<T> extends IRepository<T> {


    // Tüm kayıtları getir
    List<T> getAll();

    // Şarta uyan kayıtları getir
    List<T> getWhere(Predicate<T> predicate);

    // Tek kayıt getir (Optional ile sarıyoruz, null önlemek için)
    Optional<T> getSingle(Predicate<T> predicate);

    // Id ile tek kayıt getir
    Optional<T> getById(int id);

    // Async versiyon


}
