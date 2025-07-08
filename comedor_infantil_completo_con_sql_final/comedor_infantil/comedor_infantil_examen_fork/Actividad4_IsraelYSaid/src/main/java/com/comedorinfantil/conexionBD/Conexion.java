package com.comedorinfantil.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection ConectarBD() {
        Connection conexion;

        // URL de conexión (nombre real de la base de datos)
        String host = "jdbc:postgresql://localhost:5432/comedor_db";

        // Usuario y contraseña según la imagen que me enviaste
        String user = "comedor_infantil_examen";
        String password = "2424";

        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host, user, password);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }
}
