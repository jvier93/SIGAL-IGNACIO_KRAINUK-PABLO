package com.company.daos.impl;

import com.company.modelos.Odontologo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class OdontologoDaoMemoriaImpl {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2Impl.class);
    private final List<Odontologo> odontologos;

    public OdontologoDaoMemoriaImpl(List<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }


    public Odontologo registrar(Odontologo odontologo) throws SQLException {
        odontologos.add(odontologo);
        LOGGER.info("Se registró un odontólogo: " + odontologo.toString());
        return odontologo;
    }

    public Odontologo buscarPorId(int id) {
        Odontologo odontologoBuscado = null;


        for (Odontologo odontologo : odontologos) {
            if (odontologo.getId() == id) {
                odontologoBuscado = odontologo;
                LOGGER.info("Se buscó un odontólogo por ID: " + id);
                break;
            }
        }
        return odontologoBuscado;
    }

    public void eliminarPorId(int id) {

        Odontologo odontologoAEliminar = buscarPorId(id);
        odontologos.remove(odontologoAEliminar);
        LOGGER.info("Se eliminó un odontólogo por ID: " + id);
    }

    public List<Odontologo> buscarTodos() {
        LOGGER.info("Se buscaron todos los odontólogos.");
        return odontologos;
    }


}





