package comedorInfantil.entidades;

import java.util.Date;

public class RegistroConsumo {
    private int idRegistro;
    private int numDias;
    private int numMenu;       // FK a Menu
    private Date fechaConsumo;
    private int numMatricula;  // FK a Nino

    // Los getters y setters //

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int getNumMenu() {
        return numMenu;
    }

    public void setNumMenu(int numMenu) {
        this.numMenu = numMenu;
    }

    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

}
