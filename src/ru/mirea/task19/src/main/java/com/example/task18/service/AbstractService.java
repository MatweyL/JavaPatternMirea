package com.example.task18.service;

import java.util.List;

public interface AbstractService<T> {

    void create(T t);
    List<T> readAll();
    T read(long id);
    boolean update(T t, long id);
    boolean delete(long id);

}
