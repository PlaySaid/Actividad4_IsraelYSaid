package com.comedorinfantil.dominio.modelo;

public class PersonaAutorizada {
    private String dni_autorizado;
    private String nombre_completo;
    private String direccion;
    private String telf_contacto;
    private String relac_con_nino;

    public String getDni_autorizado() {
        return dni_autorizado;
    }

    public void setDni_autorizado(String dni_autorizado) {
        this.dni_autorizado = dni_autorizado;
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

    public String getRelac_con_nino() {
        return relac_con_nino;
    }

    public void setRelac_con_nino(String relac_con_nino) {
        this.relac_con_nino = relac_con_nino;
    }
}
