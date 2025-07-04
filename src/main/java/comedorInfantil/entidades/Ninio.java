package comedorInfantil.entidades;

import java.util.Date;

public class Ninio {
    private int numMatricula;
    private String nombreCompleto;
    private Date fechaNac;
    private Date fechaIngreso;
    private Date fechaBaja; // puede ser null
    private int dniPagador; // FK a Pagador


    // Los getters y setters //

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getDniPagador() {
        return dniPagador;
    }

    public void setDniPagador(int dniPagador) {
        this.dniPagador = dniPagador;
    }
}
