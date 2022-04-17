package Ej_estudiante;
import java.util.*;
public class App {
    public static void main(String[] args)  {
        Scanner leer=new Scanner(System.in);
        Estudiante es  = new Estudiante("Juan", 1.0, 4.2, 3.5);
        Estudiante es2 = new Estudiante("Daniela", 5.0, 5.0, 4.9);

        /* System.out.print("Digita tu nombre: ");
        es.setNombre(leer.nextLine());
        System.out.print("Digita tu nota 1: ");
        es.setNota1(leer.nextDouble());
        System.out.print("Digita tu nota 2: ");
        es.setNota2(leer.nextDouble());
        System.out.print("Digita tu nota 3: ");
        es.setNota3(leer.nextDouble()); */
        

        System.out.printf("Codigo %d: %s tu promedio es: %.2f\n",es.getCodigo(),es.getNombre(),es.promedio());
        System.out.printf("Codigo %d: %s tu promedio es: %.2f\n",es2.getCodigo(),es2.getNombre(),es2.promedio());
        //System.out.println(Estudiante.getCod_consecutivo());
        leer.close();
    }
}
