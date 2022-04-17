package Ej2.Clases;

public class Estudiante extends Persona{
    private String carrera;

    public Estudiante(String nombre, String carrera) {
        super(nombre);
        this.carrera = carrera;
    }

    public Estudiante() {
        super();
        this.carrera = "Ing.electrónica";
    }
    //Metodo polimorfico
    public void mostrar(){
        System.out.println("Nombre: "+nombre+" | Carrera: "+carrera);
    }
    //Getters and Setters
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
