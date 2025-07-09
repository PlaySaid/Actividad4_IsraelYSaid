package com.comedorinfantil.dominio.modelo;

import java.util.List;

public class MenuPlato {
    private int num_menu;
    private String nombre_menu;
    private List<Integer> platos; // solo los IDs de los platos

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

    public List<Integer> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Integer> platos) {
        this.platos = platos;
    }
}
