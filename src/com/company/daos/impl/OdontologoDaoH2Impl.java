package com.company.daos.impl;

import com.company.daos.IDao;
import com.company.database.H2Connection;
import com.company.modelos.Odontologo;

import java.sql.*;
import java.util.List;

public class OdontologoDaoH2Impl implements IDao<Odontologo> {

    private final static String SQL_INSERT_ODONTOLOGO ="INSERT INTO Odontologo (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
    private final static String SQL_SELECT_ODONTOLOGO_BY_ID = "SELECT id, numero_matricula, nombre, apellido FROM Odontologo WHERE id = ?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection conn = null;
        Odontologo odontologoCreado = null;


        try{
            conn = H2Connection.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNumMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next())
            {
                odontologoCreado = new Odontologo(resultSet.getInt(1), odontologo.getNumMatricula(), odontologo.getNombre(), odontologo.getApellido());
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                    //LOGGER.error(e.getMessage());
                }
        }
        return odontologoCreado;
    }

    @Override
    public void eliminar(Integer id) {


    }

    @Override
    public Odontologo buscar(Integer id) {
            Connection conn = null;
            Odontologo odontologoBuscado = null;

            try{
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ODONTOLOGO_BY_ID);
                preparedStatement.setInt(1,id);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    odontologoBuscado = new Odontologo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
                }


            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    //LOGGER.error(e.getMessage());
                }
              return odontologoBuscado;
            }



    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }
}
