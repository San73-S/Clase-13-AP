package org.example;

import Servicios.DepartamentoServicios;
import Servicios.EmpleadoServicios;

public class Main {
    public static void main(String[] args) {
        EmpleadoServicios ES = new EmpleadoServicios();
        DepartamentoServicios DS = new DepartamentoServicios();

        try {
            ES.printListEmployees();
            System.out.println();
            DS.printListDepartments();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}