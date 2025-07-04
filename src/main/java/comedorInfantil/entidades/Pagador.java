package comedorInfantil.entidades;

public class Pagador {
    private int dniPagador;
    private String nombreCompleto;
    private String direccion;
    private String telfContacto;
    private String numCuenta;

    // Los getters y setters //

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTelfContacto() {
        return telfContacto;
    }

    public void setTelfContacto(String telfContacto) {
        this.telfContacto = telfContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDniPagador() {
        return dniPagador;
    }

    public void setDniPagador(int dniPagador) {
        this.dniPagador = dniPagador;
    }

}
