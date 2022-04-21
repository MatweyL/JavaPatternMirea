package com.example.task16;

import java.util.List;

public interface Driver<T> {

    List<T> readAll();

    T read(long id);

}