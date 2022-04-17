package Ej2.Clases;

public class Profesor extends Persona{
    private String materia;

    public Profesor(String nombre, String materia) {
        super(nombre);
        this.materia = materia;
    }
    //Metodo polimorfico
    public void mostrar() {
        System.out.println("Nombre: "+nombre+" | Materia: "+materia);
    }
    //Getters and Setters
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
