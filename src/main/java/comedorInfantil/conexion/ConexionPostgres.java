package comedorInfantil.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgres {

    public static Connection conectarBD(String bd) {
        Connection conexion;
        String url = "jdbc:postgresql://localhost/";
        String user = "root";
        String password = "";

        System.out.println("Conectando a la base de datos...");

        try {
            conexion = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Conexion exitosa!");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;

    }

    public static void desconectarBD(Connection cb) {
        try {
            cb.close();
            System.out.println("Se ha desconectado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}