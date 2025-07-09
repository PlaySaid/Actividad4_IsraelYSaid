package com.comedorinfantil.dominio.modelo;

public class NinoAlergia {
    private int num_matricula;
    private String nombre_nino;
    private int id_ingrediente;
    private String nombre_ingrediente;

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public String getNombre_nino() {
        return nombre_nino;
    }

    public void setNombre_nino(String nombre_nino) {
        this.nombre_nino = nombre_nino;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }
}
