import java.util.Scanner;

public class Act_2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int C_bodega, C_minima;
        System.out.print("Digite la cantidad en bodega: ");
        C_bodega = leer.nextInt();
        System.out.print("Digite la cantidad minima requerida: ");
        C_minima = leer.nextInt();
        
        if (C_bodega < C_minima){
            System.out.println("Se requiere solicitar pedido al proveedor");    
        }
        else if (C_bodega == C_minima){
            System.out.println("No es requerido un pedido al proveedor");
        }
        else{
            System.out.println("No es requerido un pedido al proveedor");
        }
        leer.close();
    }
}
