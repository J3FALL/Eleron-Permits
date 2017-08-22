package com.pavel.permits.permits.core.service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */
public interface BaseService<T, E> {

    List<T> findAll();

    T findOne(Integer id);

    T save(E e);

    void delete(Integer id);

}
