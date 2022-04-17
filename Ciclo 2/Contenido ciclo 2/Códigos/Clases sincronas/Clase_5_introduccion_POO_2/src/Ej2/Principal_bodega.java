package Ej2;
import java.util.Scanner;

public class Principal_bodega {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        Producto p1 = new Producto();

        System.out.print("Digite el código: ");
        p1.Cod = leer.nextLine();
        System.out.print("Digite el precio del producto: $");
        p1.p_u = Integer.parseInt(leer.nextLine());
        System.out.print("Digite la cantidad en bodega: ");
        p1.c_b = Integer.parseInt(leer.nextLine());
        System.out.print("Digite la cantidad minima requerida: ");
        p1.c_r = Integer.parseInt(leer.nextLine());

        if(p1.S_pedido()){System.out.println("\nAlerta!!, se requiere solicitar producto");}
        else{System.out.println("\nNo se requiere solicitar producto");}
        leer.close();
    }
}
