package com.comedorinfantil.interfaz;

import com.comedorinfantil.adapters.out.NinoRepositoryAdapter;
import com.comedorinfantil.application.services.NinoServiceImpl;
import com.comedorinfantil.conexionBD.Conexion;
import com.comedorinfantil.conexionBD.Desconexion;
import com.comedorinfantil.dominio.modelo.*;
import com.comedorinfantil.dominio.ports.in.NinoServicePort;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection conexionBD = Conexion.ConectarBD("bd_said_alejandro_martelo_diaz_comedor_infantil_22", "saidm"
                , "saidmartelo123");

        NinoRepositoryAdapter ninoRepositoryAdapter = new NinoRepositoryAdapter(conexionBD);
        NinoServicePort ninoServicePort = new NinoServiceImpl(ninoRepositoryAdapter);

        int opcion;
        do {
            System.out.println("\n=============================");
            System.out.println("      MENÚ COMEDOR INFANTIL");
            System.out.println("=============================");
            System.out.println("1. Listar niños con fecha de nacimiento y de baja");
            System.out.println("2. Listar niños dados de baja con fecha de baja");
            System.out.println("3. Ver personas autorizadas para recoger a un niño");
            System.out.println("4. Ver los pagadores y sus ninos");
            System.out.println("5. Ver el costo mensual por cada nino");
            System.out.println("6. Ver los menus y sus platos asignados");
            System.out.println("7. Mostrar ninos con alergia y el ingrediente prohibido");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    List<Nino> ninos = ninoServicePort.obtenerTodosLosNinos();
                    System.out.println("-----------------------LISTA DE NINOS-------------------------");
                    for (Nino nino : ninos) {
                        if ("BAJA".equals(nino.getEstado())) {
                            System.out.println(
                                    "ID: " + nino.getNum_matricula() +
                                            " - NOMBRE: " + nino.getNombre_completo() +
                                            " - FECHA DE NACIMIENTO: " + nino.getFecha_nac() +
                                            " - ESTADO: " + nino.getEstado() +
                                            " (" + nino.getFecha_baja() + ")");
                        } else {
                            System.out.println(
                                    "ID: " + nino.getNum_matricula() +
                                            " - NOMBRE: " + nino.getNombre_completo() +
                                            " - FECHA DE NACIMIENTO: " + nino.getFecha_nac() +
                                            " - ESTADO: " + nino.getEstado());
                        }
                        System.out.println("---------------------------------------------------------------");
                    }

                    System.out.println("----------------------FIN DE LA LISTA--------------------------");
                    break;
                case 2:
                    List<Nino> ninosRetirados = ninoServicePort.obtenerNinosDadosDeBaja();
                    System.out.println("--------- NIÑOS RETIRADOS Y FECHA DE BAJA ---------");
                    for (Nino nino : ninosRetirados) {
                        System.out.println("NOMBRE: " + nino.getNombre_completo() +
                                " - FECHA DE RETIRO: " + nino.getFecha_baja());
                    }
                    System.out.println("----------------------------------------------------");
                    break;

                case 3:
                    System.out.print("Ingrese el número de matrícula del niño: ");
                    int numMatricula = scanner.nextInt();
                    scanner.nextLine();

                    List<PersonaAutorizada> personas = ninoServicePort.obtenerPersonasAutorizadasDeNino(numMatricula);

                    System.out.println("-----LISTA DE PERSONAS AUTORIZADAS-----");
                    for (PersonaAutorizada persona : personas) {
                        System.out.println("DNI: " + persona.getDni_autorizado() +
                                " - NOMBRE: " + persona.getNombre_completo() +
                                " - DIRECCION: " + persona.getDireccion() +
                                " - TELEFONO: " + persona.getTelf_contacto() +
                                " - RELACION CON NINO: " + persona.getRelac_con_nino());
                    }
                    System.out.println("--------------------------------");
                    break;

                case 4:
                    List<Pagador> pagadores = ninoServicePort.obtenerPagadoresConNinos();
                    System.out.println("----- PAGADORES Y SUS NINOS -----");
                    for (Pagador pagador : pagadores) {
                        System.out.println(
                                "DNI PAGADOR: " + pagador.getDni_pagador() +
                                        " - NOMBRE PAGADOR: " + pagador.getNombre_completo() +
                                        " - DIRECCION: " + pagador.getDireccion() +
                                        " - TELEFONO: " + pagador.getTelf_contacto() +
                                        " - Nº CUENTA: " + pagador.getNum_cuenta() +
                                        " - NINO: " + pagador.getNombre_nino() +
                                        " (MATRICULA: " + pagador.getNum_matricula() + ")"
                        );
                    }
                    System.out.println("-----------------------------------");
                    break;

                case 5:
                    List<CostoMensual> costos = ninoServicePort.obtenerCostosMensuales();
                    System.out.println("---------- COSTO MENSUAL POR NIÑO -----------");
                    for (CostoMensual dto : costos) {
                        System.out.println("MATRICULA: " + dto.getNum_matricula() +
                                " | COSTE FIJO: " + dto.getCoste_fijo() +
                                " | COSTO POR DÍA: " + dto.getCosto_por_dia_comida() +
                                " | TOTAL DÍAS: " + dto.getTotal_dias_consumidos() +
                                " | COSTO MENSUAL TOTAL: " + dto.getCosto_total_mensual());
                    }
                    System.out.println("---------------------------------------------");
                    break;

                case 6:
                    List<MenuPlato> menus = ninoServicePort.obtenerMenusConPlatos();
                    System.out.println("---------- MENÚS Y SUS PLATOS ----------");
                    for (MenuPlato menu : menus) {
                        System.out.println("MENÚ: " + menu.getNum_menu() +
                                " - NOMBRE: " + menu.getNombre_menu());
                        System.out.print("PLATOS: ");
                        if (menu.getPlatos().isEmpty()) {
                            System.out.println("Sin platos asignados");
                        } else {
                            for (Integer idPlato : menu.getPlatos()) {
                                System.out.print(idPlato + " ");
                            }
                            System.out.println();
                        }
                        System.out.println("-----------------------------------------");
                    }
                    break;

                case 7:
                    List<NinoAlergia> alergias = ninoServicePort.obtenerNinosConAlergias();
                    System.out.println("----- NIÑOS CON ALERGIAS -----");
                    for (NinoAlergia dto : alergias) {
                        System.out.println("MATRICULA: " + dto.getNum_matricula() +
                                " - NOMBRE: " + dto.getNombre_nino() +
                                " - INGREDIENTE PROHIBIDO: " + dto.getNombre_ingrediente());
                    }
                    System.out.println("--------------------------------");
                    break;


                case 0:
                    System.out.println("SALIENDO");
                    break;

                default: System.out.println("OPCION INVALIDA");
            }
        } while (opcion != 0);


        Desconexion.DesconectarBD(conexionBD);
    }
}
