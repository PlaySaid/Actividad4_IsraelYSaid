package com.comedorinfantil.dominio.modelo;

public class Pagador {
    private int dni_pagador;
    private String nombre_completo;
    private String direccion;
    private String telf_contacto;
    private String num_cuenta;
    private int num_matricula;
    private String nombre_nino;

    // Getters y setters
    public int getDni_pagador() {
        return dni_pagador;
    }

    public void setDni_pagador(int dni_pagador) {
        this.dni_pagador = dni_pagador;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelf_contacto() {
        return telf_contacto;
    }

    public void setTelf_contacto(String telf_contacto) {
        this.telf_contacto = telf_contacto;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

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
}
