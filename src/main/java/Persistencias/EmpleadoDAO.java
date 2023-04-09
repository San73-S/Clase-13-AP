package Persistencias;

import Entidades.Empleado;

import java.util.ArrayList;
import java.util.Collection;

public class EmpleadoDAO extends DAO{
    public void save(Empleado empleado) throws Exception{
        try {
            if (empleado == null){
                throw new Exception("Ingrese un empleado");
            }

            String sql = "INSERT INTO Empleado(dni, nombre, apellido, nacionalidad, departamento)" +
                    "VALUES ( '" +  empleado.getDni() + "' , '" +
                                    empleado.getNombre() + "' , '" +
                                    empleado.getApellido() + "' , '" +
                                    empleado.getNacionalidad() + "' , '" +
                                    empleado.getDepartamento() + "');";

            insertUpdateDelete(sql);
        } catch (Exception ex){
            System.out.println("Error al crear empleado.");
            throw ex;
        } finally {
            disconnectDataBase();
        }
    }

    public void updateNationality(Empleado empleado) throws Exception{
        try {
            if (empleado == null){
                throw new Exception("Indique el empleado a modificar.");
            }

            String sql = "UPDATE Empleado " +
                    "SET nacionalidad = '" + empleado.getNacionalidad() + "' WHERE dni = '" + empleado.getDni() + "';";

            insertUpdateDelete(sql);
        } catch (Exception ex){
            System.out.println("Error al crear empleado.");
            throw ex;
        } finally {
            disconnectDataBase();
        }
    }

    public Empleado findEmployeeDNI(int dni) throws Exception{
        try {
            String sql = "SELECT * FROM Empleado WHERE dni = '" + dni + "';";
            queryDataBase(sql);
            Empleado empleado = null;

            while (resultSet.next()){
                empleado = new Empleado();
                empleado.setDni(resultSet.getInt(1));
                empleado.setNombre(resultSet.getString(2));
                empleado.setApellido(resultSet.getString(3));
                empleado.setNacionalidad(resultSet.getString(4));
                empleado.setDepartamento(resultSet.getInt(5));
            }
            disconnectDataBase();
            return empleado;
        } catch (Exception e){
            disconnectDataBase();
            throw e;
        }
    }

    public Collection<Empleado> listEmployee() throws Exception{
        try {
            String sql = "SELECT dni, nombre, apellido, nacionalidad, departamento FROM Empleado;";
            queryDataBase(sql);

            Collection<Empleado> listaEmpleados = new ArrayList<>();
            Empleado empleado = null;

            while (resultSet.next()){
                empleado = new Empleado();
                empleado.setDni(resultSet.getInt(1));
                empleado.setNombre(resultSet.getString(2));
                empleado.setApellido(resultSet.getString(3));
                empleado.setNacionalidad(resultSet.getString(4));
                empleado.setDepartamento(resultSet.getInt(5));
                listaEmpleados.add(empleado);
            }
            disconnectDataBase();
            return listaEmpleados;
        } catch (Exception e){
            disconnectDataBase();
            throw e;
        }
    }

    public Collection<Empleado> listEmployeeLogistics() throws Exception{
        try {
            String sql = "SELECT e.nombre, e.apellido FROM Empleado e, Departamento d" +
                    " WHERE e.departamento = d.id AND e.departamento = 1;";
            queryDataBase(sql);

            Collection<Entidades.Empleado> listaEmpleados = new ArrayList<>();
            Entidades.Empleado empleado = null;

            while (resultSet.next()){
                empleado = new Entidades.Empleado();
                empleado.setNombre(resultSet.getString(1));
                empleado.setApellido(resultSet.getString(2));
                listaEmpleados.add(empleado);
            }
            disconnectDataBase();
            return listaEmpleados;
        } catch (Exception e){
            disconnectDataBase();
            throw e;
        }
    }

}
