package com.company.daos.impl;

import com.company.modelos.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoDaoMemoriaImpl {
    private final List<Odontologo> odontologos;

    public OdontologoDaoMemoriaImpl(List<Odontologo> odontologo) {
        this.odontologos = odontologo;
    }

    public Odontologo registrar(Odontologo odontologo) throws SQLException {
        odontologos.add(odontologo);
        return odontologo;
    }

    public Odontologo buscarPorId(int id) {
        Odontologo odontologoBuscado = null;


        for (Odontologo odontologo : odontologos) {
            if (odontologo.getId() == id) {
                odontologoBuscado = odontologo;
                break;
            }
        }
        return odontologoBuscado;
    }

    public void eliminarPorId(int id) {

        Odontologo odontologoAEliminar = buscarPorId(id);
        odontologos.remove(odontologoAEliminar);
    }

    public List<Odontologo> buscarTodos() {
        return odontologos;
    }
}





