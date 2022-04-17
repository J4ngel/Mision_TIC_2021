package Ej3;

import java.util.Scanner;

/* Actividad 2.
Construya una clase denominada estudiante, con los siguientes atributos privados nombre, nota1, nota2, nota3 y definitiva. 
Crea también los métodos Get y Set para cada una de las variables.
Realizar el diagrama de clases
Nota: Calcule la nota definitiva como el promedio simple de las tres notas. (nota1+nota2+nota3)/3 ----> como un metodo
Genera una solución que instancie la clase Estudiante, solicite el nombre y las tres notas al usuario e imprima el nombre y el promedio. */
public class Principal_estudiante {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        /* Estudiante E1 = new Estudiante();

        System.out.print("Nombre: ");
        E1.setNombre(leer.nextLine());
        System.out.print("Nota 1: ");
        E1.setNota1(Float.parseFloat(leer.nextLine()));
        System.out.print("Nota 2: ");
        E1.setNota2(Float.parseFloat(leer.nextLine()));
        System.out.print("Nota 3: ");
        E1.setNota3(Float.parseFloat(leer.nextLine()));

        System.out.printf("|Nombre: %s | Definitiva: %.2f|\n",E1.getNombre(),E1.Calculo_definitiva());
         */
        Estudiante curso[] = new Estudiante[3];

        for(int i = 0; i < curso.length; i++){
            curso[i] = new Estudiante();
            System.out.print("\nNombre: ");
            curso[i].setNombre(leer.nextLine());
            System.out.print("Nota 1: ");
            curso[i].setNota1(Float.parseFloat(leer.nextLine()));
            System.out.print("Nota 2: ");
            curso[i].setNota2(Float.parseFloat(leer.nextLine()));
            System.out.print("Nota 3: ");
            curso[i].setNota3(Float.parseFloat(leer.nextLine()));
        }

        for (Estudiante estudiante : curso) {
            System.out.printf("|Nombre: %s | Definitiva: %.2f|\n",estudiante.getNombre(),estudiante.Calculo_definitiva());
        }

        leer.close();
    }
}
