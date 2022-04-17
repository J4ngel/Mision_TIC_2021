package Ej3;

public class Estudiante {
    private String Nombre;
    private float Nota1,Nota2,Nota3,Definitiva;
    
    public Estudiante(){
        this.Nombre = "";
        this.Nota1 = 0;
        this.Nota2 = 0;
        this.Nota3 = 0;
    }
    public Estudiante(String Nombre, float Nota1, float Nota2, float Nota3) {
        this.Nombre = Nombre;
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
    }

    public String getNombre() {return Nombre;}
    
    public void setNombre(String nombre) {Nombre = nombre;}
    public void setNota1(float nota1) {Nota1 = nota1;}
    public void setNota2(float nota2) {Nota2 = nota2;}
    public void setNota3(float nota3) {Nota3 = nota3;}
    
    public float Calculo_definitiva(){
        Definitiva = (Nota1+Nota2+Nota3)/3;
        return Definitiva;
    }
    
}
