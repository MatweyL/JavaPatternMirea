package com.example.task16.driver;

import java.util.List;

public interface Driver<T> {

    void create(T t);

    List<T> readAll();

    T read(Long id);

    boolean update(T t, Long id);

    boolean delete(Long id);
}