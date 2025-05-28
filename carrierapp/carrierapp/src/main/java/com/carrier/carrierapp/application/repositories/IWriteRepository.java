package com.carrier.carrierapp.application.repositories;

import com.carrier.carrierapp.domain.entity.BaseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IWriteRepository<T> extends IRepository<T>{

    CompletableFuture<Boolean> addAsync(T model);

    CompletableFuture<Boolean> addRangeAsync(List<T> datas);

    boolean remove(T model);

    boolean removeRange(List<T> datas);

    public boolean removeById(int id);

    boolean update(T model);

    CompletableFuture<Integer> saveAsync();
}
