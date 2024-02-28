package com.company.daos;

import java.util.List;

public interface IDao<T> {

    public T guardar(T t);
    public void eliminar(Integer id);
    public T buscar(Integer id);
    public List<T> buscarTodos();
}
