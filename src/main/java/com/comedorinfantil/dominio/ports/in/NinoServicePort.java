package com.comedorinfantil.dominio.ports.in;

import com.comedorinfantil.dominio.modelo.*;

import java.sql.Date;
import java.util.List;

public interface NinoServicePort {
    List<Nino> obtenerTodosLosNinos();
    List<Nino> obtenerNinosDadosDeBaja();
    List<PersonaAutorizada> obtenerPersonasAutorizadasDeNino(int numMatricula);
    List<Pagador> obtenerPagadoresConNinos();
    List<CostoMensual> obtenerCostosMensuales();
    List<MenuPlato> obtenerMenusConPlatos();
    List<NinoAlergia> obtenerNinosConAlergias();
    List<HistorialConsumo> obtenerHistorialConsumo(int numMatricula, Date fechaInicio, Date fechaFin);
    List<AlergiaPlato> obtenerAlergiasPlatosPorNino();
    List<AsesorAreaDTO> obtenerAsesoresConAreas();


}
