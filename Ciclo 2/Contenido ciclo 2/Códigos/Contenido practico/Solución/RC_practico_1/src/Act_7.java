import java.util.Scanner;

public class Act_7 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int tipo, cantidad, precio_u,n_cliente = 1;
        double v_total, v_facturado = 0;
        String atender = "S";

        while (atender.equalsIgnoreCase("S")){
            v_total = 0;
            System.out.println("\nCliente "+n_cliente+":");
            System.out.print("Cantidad de tipo de productos: ");
            tipo = leer.nextInt();
            for (int i = 0; i < tipo; i++) {
                System.out.print("Cantidad del producto "+(i+1)+" : ");
                cantidad = leer.nextInt();
                System.out.print("Valor del producto "+(i+1)+" : $");
                precio_u = leer.nextInt();
                v_total += (cantidad * precio_u);
            }
            if (v_total > 100000){
                v_total -= (v_total*0.1);
            }
            System.out.printf("Total de la factura: $%.0f.\n",v_total);
            v_facturado += v_total;
            
            System.out.print("\nAtender a otro cliente (S/N): ");
            atender = leer.next();
            n_cliente ++;
        }
        System.out.printf("\nTotal vendido: $%.0f\n",v_facturado);
        leer.close();
    }
}
