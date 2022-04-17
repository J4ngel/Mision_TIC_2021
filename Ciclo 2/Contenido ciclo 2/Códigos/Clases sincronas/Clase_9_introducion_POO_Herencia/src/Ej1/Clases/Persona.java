package Ej1.Clases;

import java.util.Scanner;

public class Persona {
    protected String nombre, apellido;
    Scanner sc = new Scanner(System.in);

    public void pedir_datos(){
        System.out.print("Digite el nombre: ");
        nombre = sc.nextLine();
        System.out.print("Digite el apellido: ");
        apellido = sc.nextLine();
    }
}
