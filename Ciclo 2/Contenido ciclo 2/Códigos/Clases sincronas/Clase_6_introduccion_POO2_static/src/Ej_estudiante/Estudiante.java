package Ej_estudiante;
/*Actividad 2.
Construya una clase denominada estudiante, con los siguientes atributos privados nombre, nota1, nota2, nota3 y definitiva. 
Crea también los métodos Get y Set para cada una de las variables.
Realizar el diagrama de clases
Nota: Calcule la nota definitiva como el promedio simple de las tres notas. (nota1+nota2+nota3)/3
Genera una solución que instancie la clase Estudiante, solicite el nombre y las tres notas al usuario e imprima el nombre y el promedio.*/

public class Estudiante {
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    
    private int codigo;
    private static int cod_consecutivo = 10;

    public Estudiante(String nombre,double nota1,double nota2,double nota3){
        this.nombre=nombre;
        this.codigo = cod_consecutivo;
        cod_consecutivo++;
        this.nota1=nota1;
        this.nota2=nota2;
        this.nota3=nota3;
    }
    
    public double promedio(){
        double prom=(nota1+nota2+nota3)/3;
        return prom;
    }

    public int getCodigo(){
        return codigo;
    }
    public static int getCod_consecutivo(){
        return cod_consecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

}
