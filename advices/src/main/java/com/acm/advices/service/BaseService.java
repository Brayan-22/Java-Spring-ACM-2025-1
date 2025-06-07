package com.acm.advices.service;

import java.util.List;

public interface BaseService <T>{
    T save(T entity);
    T update(T entity);
    void delete(String id);
    T findById(String id);
    List<T> findAll();
}
