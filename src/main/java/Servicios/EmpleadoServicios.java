package Servicios;

import Entidades.Empleado;
import Persistencias.EmpleadoDAO;

import java.util.Collection;

public class EmpleadoServicios {

    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public boolean validator(int dni, String nombre, String apellido, String nacionalidad, int departamento) throws Exception {
        if(dni<0 || departamento<0){
            throw new Exception("Solo se admiten numeros enteros");
        }
        if(nombre == null || nombre.trim().isEmpty() ||
                apellido == null || apellido.trim().isEmpty() ||
                nacionalidad == null || nacionalidad.trim().isEmpty()){
            throw new Exception("Los datos ingresados son erroneos");
        }
        return true;
    }

    public void createEmployee(int dni, String nombre, String apellido, String nacionalidad, int departamento) throws Exception{
        try {
            if(validator(dni, nombre, apellido, nacionalidad, departamento)){
                Empleado empleado = new Empleado(dni, nombre, apellido, nacionalidad, departamento);
                empleadoDAO.save(empleado);
            }
        } catch (Exception ex){
            throw ex;
        }
    }

    public void updateNationality(int dni, String nacionalidadActual, String nacionalidadNueva) throws Exception {
        try {
            if (nacionalidadActual == null || nacionalidadNueva == null || nacionalidadActual.equals(nacionalidadNueva)){
                System.out.println("La nacionalidad esta vacio o son iguales.");
            }

            Empleado empleado = findEmployeeDNI(dni);
            empleado.setNacionalidad(nacionalidadNueva);
            empleadoDAO.updateNationality(empleado);
        } catch (Exception ex){
            throw ex;
        }
    }

    private Empleado findEmployeeDNI(int dni) throws Exception {
        try {
            if (dni<0){
                throw new Exception("El dni esta vacio o es nulo.");
            }

            Empleado empleado = empleadoDAO.findEmployeeDNI(dni);
            return empleado;
        } catch (Exception ex){
            throw ex;
        }
    }

    public Collection<Empleado> listEmployees() throws Exception{
        try {
            Collection<Empleado> empleadosLista = empleadoDAO.listEmployee();
            return empleadosLista;
        } catch (Exception ex){
            throw ex;
        }
    }

    public void printListEmployees()throws Exception{
        try {
            Collection<Empleado> empleadoLista = listEmployees();
            if (empleadoLista.isEmpty()){
                throw new Exception("No hay Empleados registrados");
            } else {
                for (Empleado e:empleadoLista) {
                    System.out.println(e);
                }
            }
        } catch (Exception ex){
            throw ex;
        }
    }

    public Collection<Empleado> listEmployeesLogistics() throws Exception{
        try {
            Collection<Empleado> empleadosLogistica = empleadoDAO.listEmployeeLogistics();
            return empleadosLogistica;
        } catch (Exception ex){
            throw ex;
        }
    }

    public void printListEmployeesLogistics()throws Exception{
        try {
            Collection<Empleado> empleadoLista = listEmployeesLogistics();
            if (empleadoLista.isEmpty()){
                throw new Exception("No hay Empleados registrados");
            } else {
                for (Empleado e:empleadoLista) {
                    System.out.println(e);
                }
            }
        } catch (Exception ex){
            throw ex;
        }
    }
}
