package com.comedorinfantil.dominio.ports.out;

import com.comedorinfantil.dominio.modelo.Nino;

import java.util.List;

public interface NinoRepositoryPort {
    List<Nino> findAll();
    List<Nino> findAllBaja();
}
