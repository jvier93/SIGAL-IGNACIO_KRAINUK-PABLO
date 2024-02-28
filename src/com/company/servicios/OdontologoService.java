package com.company.servicios;

import com.company.daos.IDao;
import com.company.modelos.Odontologo;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return  odontologoIDao.guardar(odontologo);
    }

    public Odontologo buscarOdontologoPorId(Integer id){
        return  odontologoIDao.buscar(id);
    }
}
