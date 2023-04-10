package org.example;

import Servicios.DepartamentoServicios;
import Servicios.EmpleadoServicios;

public class Main {
    public static void main(String[] args) {
        EmpleadoServicios ES = new EmpleadoServicios();
        DepartamentoServicios DS = new DepartamentoServicios();

        try {
            //Puntos 3.a 3.b 3.c ESTAN COMENTADOS YA QUE ESOS DATOS FORMAN PARTE DE LA BASE DE DATOS YA
            //3.a
            // ES.createEmployee(41258745,"Gaston", "Muller", "Noruega", 3);
            //3.b
            //ES.updateNationality(41258745, "Noruega", "Alemana");
            //3.c
            //DS.createDepartment("Ingenieria", 5500000f);
            //DS.deleteDepartment("Ingenieria");

            //Puntos 3.d 3.e
            //3.d
            ES.printListEmployeesLogistics();
            //3.e
            System.out.println();
            DS.printListDepartments();

            ES.printListEmployees();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}