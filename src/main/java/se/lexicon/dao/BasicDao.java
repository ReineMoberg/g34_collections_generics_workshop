package se.lexicon.dao;

public interface BasicDao<T> {
    // basic CRUD operations

    T create(T t);

    T read(int id);

    boolean delete(T t);

    boolean delete(int id);

}
