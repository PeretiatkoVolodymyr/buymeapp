package dao;

import java.util.List;

public interface Dao<T,ID> {

    T create(T entity);
    List<T> findAll();
    List<T> findAll(int offset, int length);
    T find(ID id);
    T remove(ID id);
    T update(T entity);
}