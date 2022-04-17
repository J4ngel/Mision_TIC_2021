package Ej1.main;
import java.util.Scanner;
import Ej1.Clases.Estudiante;

public class Principal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Estudiante alumno = new Estudiante();
        alumno.pedir_datos();
        System.out.print("Digite el código: ");
        alumno.setCodigo(sc.nextLine());
        System.out.print("Digite la nota 1: ");
        alumno.setN1(Double.parseDouble(sc.nextLine()));
        System.out.print("Digite la nota 2: ");
        alumno.setN2(Double.parseDouble(sc.nextLine()));
        System.out.print("Digite la nota 3: ");
        alumno.setN3(Double.parseDouble(sc.nextLine()));
        
        alumno.imprimir_superclase();
        System.out.printf("con código %s tiene promedio %.2f\n",alumno.getCodigo(),alumno.promedio());

        sc.close();
    }
}
