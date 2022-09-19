package org.example.repositories;


import java.util.List;

public interface IRepository<T>{
    void addFirstData();
    List<T> getData();
}
