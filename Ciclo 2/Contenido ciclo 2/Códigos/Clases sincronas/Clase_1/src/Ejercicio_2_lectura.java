import java.util.Scanner;
public class Ejercicio_2_lectura {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.print("Ingresa un nombre: ");
        String nombre = leer.nextLine();
        
        System.out.print("Hola " + nombre + " digite su edad: ");
        int edad = leer.nextInt();
        
        System.out.println("Nombre: "+nombre+" Edad: "+ edad);
        System.out.println(String.format("Nombre: %s Edad: %d", nombre,edad));
        System.out.printf("Nombre: %s Edad: %d", nombre,edad);
        leer.close();   //Este close va al final
        System.out.printf("\n%.2f %n", 12.1);
        System.out.printf("%.3f %n", 55.489302);
    }
}
