package com.comedorinfantil.application.services;

import com.comedorinfantil.dominio.modelo.*;
import com.comedorinfantil.dominio.ports.in.NinoServicePort;
import com.comedorinfantil.dominio.ports.out.NinoRepositoryPort;

import java.sql.Date;
import java.util.List;

public class NinoServiceImpl implements NinoServicePort {
    private final NinoRepositoryPort ninoRepositoryPort;

    public NinoServiceImpl(NinoRepositoryPort ninoRepositoryPort) {
        this.ninoRepositoryPort = ninoRepositoryPort;
    }

    @Override
    public List<Nino> obtenerTodosLosNinos() {
        return ninoRepositoryPort.findAll();
    }

    @Override
    public List<Nino> obtenerNinosDadosDeBaja() {
        return ninoRepositoryPort.findAllBaja();
    }

    public List<PersonaAutorizada> obtenerPersonasAutorizadasDeNino(int numMatricula) {
        return ninoRepositoryPort.findPersonasAutorizadasByNino(numMatricula);
    }

    @Override
    public List<Pagador> obtenerPagadoresConNinos() {
        return ninoRepositoryPort.findAllPagadoresConNinos();
    }

    @Override
    public List<CostoMensual> obtenerCostosMensuales() {
        return ninoRepositoryPort.obtenerCostosMensuales();
    }

    @Override
    public List<MenuPlato> obtenerMenusConPlatos() {
        return ninoRepositoryPort.obtenerMenusConPlatos();
    }

    @Override
    public List<NinoAlergia> obtenerNinosConAlergias() {
        return ninoRepositoryPort.obtenerNinosConAlergias();
    }

    @Override
    public List<HistorialConsumo> obtenerHistorialConsumo(int numMatricula, Date fechaInicio, Date fechaFin) {
        return ninoRepositoryPort.obtenerHistorialConsumo(numMatricula, fechaInicio, fechaFin);
    }

    @Override
    public List<AlergiaPlato> obtenerAlergiasPlatosPorNino() {
        return ninoRepositoryPort.findAlergiasPlatosPorNino();
    }

    @Override
    public List<AsesorAreaDTO> obtenerAsesoresConAreas() {
        return ninoRepositoryPort.findAllAsesoresWithAreas();
    }

}

