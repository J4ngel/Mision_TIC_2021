public class Persona {
    private String Nombre;
    private int ID, Edad;
    
    public Persona(String nombre, int iD, int edad) {
        Nombre = nombre;
        ID = iD;
        Edad = edad;
    }

    @Override
    public String toString() {
        String mensaje ="La persona se llama "+Nombre+" con identificación "+ID+" y tiene "+Edad+" años";
        return mensaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
