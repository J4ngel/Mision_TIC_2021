import java.util.Scanner;

public class Ejercicio_3_cadenas {
    public static void main(String[] args){
        String nombre_1 = "", nombre_2 = "";
        Scanner leer = new Scanner(System.in);
        
        System.out.print("Ingrese el primer nombre: ");
        nombre_1 = leer.nextLine();
        System.out.print("Ingrese el segundo nombre: ");
        nombre_2 = leer.nextLine();
        
        if (nombre_1.equalsIgnoreCase(nombre_2)){
            System.out.println("Los nombres son iguales");
        } else {
            System.out.println("Los nombres son diferentes!!");
        }

        leer.close();
    }
}
