package com.comedorinfantil.adapters.out;


import com.comedorinfantil.dominio.modelo.Nino;
import com.comedorinfantil.dominio.ports.out.NinoRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NinoRepositoryAdapter implements NinoRepositoryPort {

    private final Connection conexion;

    public NinoRepositoryAdapter(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Nino> findAll() {
        String sql = "SELECT num_matricula, nombre_completo, fecha_nac, fecha_baja FROM nino";
        Statement stmt;
        ResultSet rs;
        int num_matricula;
        String nombre_completo;
        Date fecha_nac;
        Date fecha_baja;
        List<Nino> ninos = new ArrayList<>();

        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                num_matricula = rs.getInt("num_matricula");
                nombre_completo = rs.getString("nombre_completo");
                fecha_nac = rs.getDate("fecha_nac");
                fecha_baja = rs.getDate("fecha_baja");

                String estado;
                if(fecha_baja == null){
                    estado = "ACTIVO";
                } else{
                    estado = "BAJA";
                }
                Nino nino = new Nino();
                nino.setNum_matricula(num_matricula);
                nino.setNombre_completo(nombre_completo);
                nino.setFecha_nac(fecha_nac);
                nino.setFecha_baja(fecha_baja);
                nino.setEstado(estado);

                ninos.add(nino);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return ninos;

        }

        @Override
        public List<Nino> findAllBaja(){
        String sql = "SELECT nombre_completo, fecha_baja FROM nino WHERE fecha_baja IS NOT NULL";
        Statement stmt;
        ResultSet rs;
        String nombre_completo;
        Date fecha_baja;
        List<Nino> ninos = new ArrayList<>();

        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nombre_completo = rs.getString("nombre_completo");
                fecha_baja = rs.getDate("fecha_baja");

                Nino nino = new Nino();
                nino.setNombre_completo(nombre_completo);
                nino.setFecha_baja(fecha_baja);
                nino.setEstado("BAJA");

                ninos.add(nino);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return ninos;
    }
}

