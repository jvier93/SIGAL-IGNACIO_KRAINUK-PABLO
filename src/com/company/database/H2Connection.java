package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Connection {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:./Database/Clinica";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS Odontologos;\n" +
            "CREATE TABLE Odontologo (\n" +
            "     id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    numero_matricula INT,\n" +
            "    nombre VARCHAR(255),\n" +
            "    apellido VARCHAR(255)\n" +
            ");\n";



    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


    }

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }



}
