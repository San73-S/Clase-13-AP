package Entidades;

public class Departamento {

    private int id;
    private String nombre_departamento;
    private float presupuesto;

    public Departamento() {
    }

    public Departamento(String nombre_departamento, float presupuesto) {
        this.nombre_departamento = nombre_departamento;
        this.presupuesto = presupuesto;
    }

    public Departamento(int id, String nombre_departamento, float presupuesto) {
        this.id = id;
        this.nombre_departamento = nombre_departamento;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre_departamento='" + nombre_departamento + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
