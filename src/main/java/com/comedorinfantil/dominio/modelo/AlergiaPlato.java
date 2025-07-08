package com.comedorinfantil.dominio.modelo;

public class AlergiaPlato {
    private int numMatricula;
    private String nombreNino;
    private int idAlergia;
    private String descripcionAlergia;
    private int idPlato;
    private String nombrePlato;

    // getters y setters
    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombreNino() {
        return nombreNino;
    }

    public void setNombreNino(String nombreNino) {
        this.nombreNino = nombreNino;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getDescripcionAlergia() {
        return descripcionAlergia;
    }

    public void setDescripcionAlergia(String descripcionAlergia) {
        this.descripcionAlergia = descripcionAlergia;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
}
