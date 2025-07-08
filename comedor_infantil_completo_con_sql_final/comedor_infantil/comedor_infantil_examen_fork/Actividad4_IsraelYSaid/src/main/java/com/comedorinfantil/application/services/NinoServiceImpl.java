package com.comedorinfantil.application.services;

import com.comedorinfantil.dominio.modelo.Nino;
import com.comedorinfantil.dominio.ports.in.NinoServicePort;
import com.comedorinfantil.dominio.ports.out.NinoRepositoryPort;

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
}

