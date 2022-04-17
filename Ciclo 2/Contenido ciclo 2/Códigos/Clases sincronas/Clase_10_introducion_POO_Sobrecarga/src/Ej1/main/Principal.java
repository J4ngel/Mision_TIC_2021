package Ej1.main;
import Ej1.Clases.*;

public class Principal {
    public static void main(String[] args){
        Suma s1 = new Suma();
        Resta r1 = new Resta();

        System.out.println("Datos de la suma:");
        s1.P_datos();
        s1.sumar();
        System.out.println("El resultado de la suma es: "+s1.mostrar_r());

        System.out.println("\nDatos de la resta:");
        r1.P_datos();
        r1.restar();
        System.out.println("El resultado de la suma es: "+r1.mostrar_r());

    }
}
