package com.comedorinfantil.dominio.ports.in;

import com.comedorinfantil.dominio.modelo.Nino;
import java.util.List;

public interface NinoServicePort {
    List<Nino> obtenerTodosLosNinos();
    List<Nino> obtenerNinosDadosDeBaja();
}
