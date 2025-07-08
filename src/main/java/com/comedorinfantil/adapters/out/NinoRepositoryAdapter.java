package com.comedorinfantil.adapters.out;


import com.comedorinfantil.dominio.modelo.*;
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
    @Override
    public List<PersonaAutorizada> findPersonasAutorizadasByNino(int numMatricula) {
        String sql = "SELECT pa.dni_autorizado, pa.nombre_completo, pa.direccion, " +
                "pa.telf_contacto, pa.relac_con_nino " +
                "FROM personas_autorizadas pa " +
                "JOIN nino_persona_autorizada npa ON pa.dni_autorizado = npa.dni_autorizado " +
                "WHERE npa.num_matricula = ?";
        PreparedStatement stmt;
        ResultSet rs;
        List<PersonaAutorizada> personas = new ArrayList<>();

        try {
            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, numMatricula);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PersonaAutorizada persona = new PersonaAutorizada();
                persona.setDni_autorizado(rs.getString("dni_autorizado"));
                persona.setNombre_completo(rs.getString("nombre_completo"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelf_contacto(rs.getString("telf_contacto"));
                persona.setRelac_con_nino(rs.getString("relac_con_nino"));

                personas.add(persona);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return personas;
    }

    @Override
    public List<Pagador> findAllPagadoresConNinos() {
        String sql = "SELECT " +
                "p.dni_pagador, p.nombre_completo AS nombre_pagador, p.direccion, " +
                "p.telf_contacto, p.num_cuenta, " +
                "n.num_matricula, n.nombre_completo AS nombre_nino " +
                "FROM pagador p " +
                "JOIN nino n ON p.dni_pagador = n.dni_pagador";

        List<Pagador> pagadores = new ArrayList<>();
        Statement stmt;
        ResultSet rs;

        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pagador pagador = new Pagador();
                pagador.setDni_pagador(rs.getInt("dni_pagador"));
                pagador.setNombre_completo(rs.getString("nombre_pagador"));
                pagador.setDireccion(rs.getString("direccion"));
                pagador.setTelf_contacto(rs.getString("telf_contacto"));
                pagador.setNum_cuenta(rs.getString("num_cuenta"));
                pagador.setNum_matricula(rs.getInt("num_matricula"));
                pagador.setNombre_nino(rs.getString("nombre_nino"));

                pagadores.add(pagador);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return pagadores;
    }

    @Override
    public List<CostoMensual> obtenerCostosMensuales() {
        String sql = "SELECT " +
                "c.num_matricula, " +
                "c.coste_fijo, " +
                "c.costo_por_dia_comida, " +
                "COALESCE(SUM(r.num_dias), 0) AS total_dias_consumidos, " +
                "(c.coste_fijo + COALESCE(SUM(r.num_dias), 0) * c.costo_por_dia_comida) AS costo_total_mensual " +
                "FROM costo_mensual c " +
                "LEFT JOIN registro_consumo r " +
                "ON c.num_matricula = r.num_matricula " +
                "AND r.fecha_consumo BETWEEN c.fecha_vigencia_inicio AND c.fecha_vigencia_fin " +
                "GROUP BY c.num_matricula, c.coste_fijo, c.costo_por_dia_comida";

        Statement stmt;
        ResultSet rs;
        List<CostoMensual> costos = new ArrayList<>();

        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int num_matricula = rs.getInt("num_matricula");
                double coste_fijo = rs.getDouble("coste_fijo");
                double costo_por_dia_comida = rs.getDouble("costo_por_dia_comida");
                int total_dias = rs.getInt("total_dias_consumidos");
                double costo_total = rs.getDouble("costo_total_mensual");

                CostoMensual costoDTO = new CostoMensual();
                costoDTO.setNum_matricula(num_matricula);
                costoDTO.setCoste_fijo(coste_fijo);
                costoDTO.setCosto_por_dia_comida(costo_por_dia_comida);
                costoDTO.setTotal_dias_consumidos(total_dias);
                costoDTO.setCosto_total_mensual(costo_total);

                costos.add(costoDTO);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return costos;
    }

    @Override
    public List<MenuPlato> obtenerMenusConPlatos() {
        String sqlMenus = "SELECT num_menu, nombre_menu FROM menu";
        String sqlPlatos = "SELECT id_plato, num_menu FROM plato";

        Statement stmtMenus;
        Statement stmtPlatos;
        ResultSet rsMenus;
        ResultSet rsPlatos;

        List<MenuPlato> listaMenus = new ArrayList<>();
        try {
            stmtMenus = conexion.createStatement();
            rsMenus = stmtMenus.executeQuery(sqlMenus);

            while (rsMenus.next()) {
                int num_menu = rsMenus.getInt("num_menu");
                String nombre_menu = rsMenus.getString("nombre_menu");

                MenuPlato menuDTO = new MenuPlato();
                menuDTO.setNum_menu(num_menu);
                menuDTO.setNombre_menu(nombre_menu);
                menuDTO.setPlatos(new ArrayList<>());

                listaMenus.add(menuDTO);
            }

            stmtPlatos = conexion.createStatement();
            rsPlatos = stmtPlatos.executeQuery(sqlPlatos);

            while (rsPlatos.next()) {
                int id_plato = rsPlatos.getInt("id_plato");
                int num_menu = rsPlatos.getInt("num_menu");

                for (MenuPlato menu : listaMenus) {
                    if (menu.getNum_menu() == num_menu) {
                        menu.getPlatos().add(id_plato);
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaMenus;
    }

    @Override
    public List<NinoAlergia> obtenerNinosConAlergias() {
        String sql = "SELECT n.num_matricula, n.nombre_completo, " +
                "i.id_ingrediente, i.nombre_ingrediente " +
                "FROM alergia a " +
                "JOIN nino n ON a.num_matricula = n.num_matricula " +
                "JOIN ingrediente i ON a.id_ingrediente = i.id_ingrediente " +
                "ORDER BY n.num_matricula";

        Statement stmt;
        ResultSet rs;
        int num_matricula;
        String nombre_nino;
        int id_ingrediente;
        String nombre_ingrediente;

        List<NinoAlergia> lista = new ArrayList<>();

        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                num_matricula = rs.getInt("num_matricula");
                nombre_nino = rs.getString("nombre_completo");
                id_ingrediente = rs.getInt("id_ingrediente");
                nombre_ingrediente = rs.getString("nombre_ingrediente");

                NinoAlergia dto = new NinoAlergia();
                dto.setNum_matricula(num_matricula);
                dto.setNombre_nino(nombre_nino);
                dto.setId_ingrediente(id_ingrediente);
                dto.setNombre_ingrediente(nombre_ingrediente);

                lista.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return lista;
    }


}
