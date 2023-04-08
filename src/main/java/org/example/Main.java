package org.example;

import Servicios.EmpleadoServicios;

public class Main {
    public static void main(String[] args) {
        EmpleadoServicios ES = new EmpleadoServicios();

        try {
            ES.printListEmployees();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}