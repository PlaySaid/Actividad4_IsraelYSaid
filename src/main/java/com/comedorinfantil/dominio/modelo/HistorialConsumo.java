package com.comedorinfantil.dominio.modelo;

import java.util.Date;

public class HistorialConsumo {
    private int id_registro;
    private int num_dias;
    private int num_menu;
    private String nombre_menu;
    private Date fecha_consumo;

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getNum_dias() {
        return num_dias;
    }

    public void setNum_dias(int num_dias) {
        this.num_dias = num_dias;
    }

    public int getNum_menu() {
        return num_menu;
    }

    public void setNum_menu(int num_menu) {
        this.num_menu = num_menu;
    }

    public String getNombre_menu() {
        return nombre_menu;
    }

    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }

    public Date getFecha_consumo() {
        return fecha_consumo;
    }

    public void setFecha_consumo(Date fecha_consumo) {
        this.fecha_consumo = fecha_consumo;
    }
}
