package comedorInfantil;

import comedorInfantil.conexion.ConexionPostgres;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection bd = ConexionPostgres.conectarBD("actividad4"); // Pon el nombre de la BD Postgres aqui

        ConexionPostgres.desconectarBD(bd); // Para desconectar de la bd
    }
}