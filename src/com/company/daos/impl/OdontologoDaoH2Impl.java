package com.company.daos.impl;

import com.company.daos.IDao;
import com.company.database.H2Connection;
import com.company.modelos.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2Impl implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2Impl.class);

    private final static String SQL_INSERT_ODONTOLOGO ="INSERT INTO Odontologo (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
    private final static String SQL_SELECT_ODONTOLOGO_BY_ID = "SELECT id, numero_matricula, nombre, apellido FROM Odontologo WHERE id = ?";
    private final static String SQL_SELECT_TODOS = "SELECT * FROM Odontologo";
    private final static String SQL_DELETE_ODONTOLOGO_BY_ID = "DELETE FROM Odontologo WHERE id = ?";
    private final  static  String SQL_UPDATE_ODONTOLOGO =  "UPDATE Odontologo SET numero_matricula = ?, nombre = ?, apellido = ? WHERE id = ?";


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

            LOGGER.info("Se creó un nuevo odontólogo: " + odontologoCreado);


        }
        catch (Exception e){
            LOGGER.error("Error al crear nuevo odontólogo: " + e.getMessage());

        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar la conexion: " + e.getMessage());
                }

                }
        }
        return odontologoCreado;
    }

    @Override
    public void eliminar(Integer id) {
        Connection conn = null;
        try{
            conn = H2Connection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE_ODONTOLOGO_BY_ID);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            LOGGER.info("Se eliminio un odontologo ");


        }
        catch (Exception e){
            LOGGER.error("Error al eliminar odontólogo: " + e.getMessage());
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar la conexion: " + e.getMessage());
                }

            }
        }

    }

    @Override
    public Odontologo buscar(Integer id) {
            Connection conn = null;
            Odontologo odontologoBuscado = null;

            try{
                conn = H2Connection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ODONTOLOGO_BY_ID);
                preparedStatement.setInt(1,id);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    odontologoBuscado = new Odontologo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
                }

                LOGGER.info("Se busco un odontologo " + odontologoBuscado);


            }
            catch (Exception e){
                LOGGER.error("Error al buscar ondontologo " + e.getMessage());
            }
            finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        LOGGER.error("Error al cerrar la conexion: " + e.getMessage());
                    }

                }
              return odontologoBuscado;
            }



    }

    @Override
    public void actualizar(Odontologo odontologo) {
        Connection conn = null;


        try{

            conn = H2Connection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE_ODONTOLOGO);
            preparedStatement.setInt(1, odontologo.getNumMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setInt(4, odontologo.getId());

            preparedStatement.execute();
            LOGGER.info("Se actualizo un Odontologo " + odontologo);

        }
        catch (Exception e){
           LOGGER.error("Error al actualizar Odontologo " + e.getMessage());
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("Error al cerrar la conexion: " + e.getMessage());
                }

            }
        }

    }


    @Override
    public List<Odontologo> buscarTodos() {
        Connection conn = null;
        List<Odontologo> odontologosEncontrados = new ArrayList<>();

        try{
            conn = H2Connection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_TODOS);

            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next())
            {
               Odontologo odontologo = new Odontologo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
                odontologosEncontrados.add(odontologo);
            }

            LOGGER.info("Se buscaron todos los odontologos, cantidad de resultados: " + odontologosEncontrados.size());

        }
        catch (Exception e){
            LOGGER.error("Error al buscar todos los Odontologos " + e.getMessage());
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                   LOGGER.error("Error al cerrar la conexion " + e.getMessage());
                }

            }
        }
        return  odontologosEncontrados;
    }
}
