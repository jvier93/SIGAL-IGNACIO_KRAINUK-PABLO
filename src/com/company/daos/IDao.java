package com.company.daos;

import com.company.modelos.Odontologo;

import java.util.List;

public interface IDao<T> {

    public T guardar(T t);
    public void eliminar(Integer id);
    public T buscar(Integer id);
    public void actualizar(T t);
    public List<T> buscarTodos();
}
