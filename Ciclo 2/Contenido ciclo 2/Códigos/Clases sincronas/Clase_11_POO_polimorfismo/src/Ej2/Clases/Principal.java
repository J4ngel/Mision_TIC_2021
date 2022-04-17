package Ej2.Clases;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del profesor: ");
        String nom = sc.nextLine();
        System.out.print("Ingrese la materia que dicta el profesor: ");
        String mat = sc.nextLine();
        Profesor p1 = new Profesor(nom, mat);
        p1.mostrar();

        Estudiante p2 = new Estudiante();
        //p2.mostrar();
        System.out.print("Ingrese el nombre del estudiante: ");
        nom = sc.nextLine();
        System.out.print("Ingrese la carrera del estudiante: ");
        String car = sc.nextLine();
        p2.setNombre(nom);
        p2.setCarrera(car);
        p2.mostrar();
        
        sc.close();
    }
}
