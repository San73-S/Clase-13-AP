package Persistencias;

import Entidades.Departamento;

import java.util.ArrayList;
import java.util.Collection;

public class DepartamentoDAO extends DAO{

    public void save(Departamento departamento) throws Exception{
        try {
            if(departamento == null){
                throw new Exception("Ingrese un departamento");
            }

            String sql = "INSERT INTO Departamento(nombre_departamento, presupuesto)" +
                    departamento.getNombre_departamento() + "' , '" +
                    departamento.getPresupuesto() + "');";

            insertUpdateDelete(sql);
        } catch (Exception ex){
            System.out.println("Error al crear departamento.");
            throw ex;
        } finally {
            disconnectDataBase();
        }
    }

    public void deleteDepartmentName(String nombre) throws Exception{
        try {
            String sql = "DELETE FROM Departamento WHERE nombre_departamento = '" + nombre+ "';";
            insertUpdateDelete(sql);
        } catch (Exception e){
            throw e;
        } finally {
            disconnectDataBase();
        }
    }

    public Collection<Departamento> listDepartment() throws Exception{
        try {
            String sql = "SELECT nombre_departamento FROM Departamento ORDER BY nombre_departamento ASC;";
            queryDataBase(sql);

            Collection<Departamento> listaDepartamentos = new ArrayList<>();
            Departamento departamento = null;

            while (resultSet.next()){
                departamento = new Departamento();
                departamento.setNombre_departamento(resultSet.getString(1));
                listaDepartamentos.add(departamento);
            }
            disconnectDataBase();
            return listaDepartamentos;
        } catch (Exception e){
            disconnectDataBase();
            throw e;
        }
    }






}
