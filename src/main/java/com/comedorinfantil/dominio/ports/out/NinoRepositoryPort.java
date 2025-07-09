package com.comedorinfantil.dominio.ports.out;

import com.comedorinfantil.dominio.modelo.*;

import java.sql.Date;
import java.util.List;

public interface NinoRepositoryPort {
    List<Nino> findAll();
    List<Nino> findAllBaja();
    List<PersonaAutorizada> findPersonasAutorizadasByNino(int numMatricula);
    List<Pagador> findAllPagadoresConNinos();
    List<CostoMensual> obtenerCostosMensuales();
    List<MenuPlato> obtenerMenusConPlatos();
    List<NinoAlergia> obtenerNinosConAlergias();
    List<HistorialConsumo> obtenerHistorialConsumo(int numMatricula, Date fechaInicio, Date fechaFin);
    List<AlergiaPlato> findAlergiasPlatosPorNino();
    List<AsesorAreaDTO> findAllAsesoresWithAreas();

}
