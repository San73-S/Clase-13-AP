package Servicios;

import Entidades.Departamento;
import Entidades.Empleado;
import Persistencias.DepartamentoDAO;

import java.util.Collection;

public class DepartamentoServicios {

    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    public void createDepartment(String nombre_departamento, float presupuesto) throws Exception{
        try {
            if(nombre_departamento == null || nombre_departamento.trim().isEmpty()){
                throw new Exception("No ingreso un departamento.");
            }
            if(presupuesto<0){
                throw new Exception("No ingreso un presupuesto.");
            }

            Departamento departamento = new Departamento(nombre_departamento,presupuesto);
            departamentoDAO.save(departamento);

        } catch (Exception ex){
            throw ex;
        }
    }

    public void deleteDepartment(String nombre) throws Exception{
        try {
            if (nombre == null || nombre.trim().isEmpty()){
                throw new Exception("No ingreso un nombre.");
            }
            departamentoDAO.deleteDepartmentName(nombre);
        } catch (Exception ex){
            throw ex;
        }
    }

    public Collection<Departamento> listDepartments() throws Exception{
        try {
            Collection<Departamento> departamentoLista = departamentoDAO.listDepartment();
            return departamentoLista;
        } catch (Exception ex){
            throw ex;
        }
    }

    public void printListDepartments()throws Exception{
        try {
            Collection<Departamento> departamentosLista = listDepartments();
            if (departamentosLista.isEmpty()){
                throw new Exception("No hay Departamentos registrados");
            } else {
                System.out.println("Impresion de departamentos orden ascendente\n");
                for (Departamento d:departamentosLista) {
                    System.out.println(d.getNombre_departamento());
                }
            }
        } catch (Exception ex){
            throw ex;
        }
    }
}
