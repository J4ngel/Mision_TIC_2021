package Ej2.Clases;

public abstract class Persona {
    protected String nombre;

    //Constructores
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    public Persona(){
        this.nombre = "Daniela";
    }

    //Metodo abstracto
    public abstract void mostrar();
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
