package com.comedorinfantil.conexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class Desconexion {
    public static void DesconectarBD(Connection cb) {
        try {
            cb.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
