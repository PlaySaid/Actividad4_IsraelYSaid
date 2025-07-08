package com.comedorinfantil.dominio.modelo;

public class CostoMensual {
    private int num_matricula;
    private double coste_fijo;
    private double costo_por_dia_comida;
    private int total_dias_consumidos;
    private double costo_total_mensual;

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public double getCoste_fijo() {
        return coste_fijo;
    }

    public void setCoste_fijo(double coste_fijo) {
        this.coste_fijo = coste_fijo;
    }

    public double getCosto_por_dia_comida() {
        return costo_por_dia_comida;
    }

    public void setCosto_por_dia_comida(double costo_por_dia_comida) {
        this.costo_por_dia_comida = costo_por_dia_comida;
    }

    public int getTotal_dias_consumidos() {
        return total_dias_consumidos;
    }

    public void setTotal_dias_consumidos(int total_dias_consumidos) {
        this.total_dias_consumidos = total_dias_consumidos;
    }

    public double getCosto_total_mensual() {
        return costo_total_mensual;
    }

    public void setCosto_total_mensual(double costo_total_mensual) {
        this.costo_total_mensual = costo_total_mensual;
    }
}
