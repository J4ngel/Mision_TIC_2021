import java.util.Scanner;

public class Act_6 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int tipo, cantidad, precio_u, v_total = 0;
        System.out.print("Cantidad de tipo de productos: ");
        tipo = leer.nextInt();
        for (int i = 0; i < tipo; i++) {
            System.out.print("Cantidad del producto "+(i+1)+" : ");
            cantidad = leer.nextInt();
            System.out.print("Valor del producto "+(i+1)+" : $");
            precio_u = leer.nextInt();
            v_total += (cantidad * precio_u);
        }
        System.out.println("Total de la factura: $"+v_total);

        leer.close();
    }
}
