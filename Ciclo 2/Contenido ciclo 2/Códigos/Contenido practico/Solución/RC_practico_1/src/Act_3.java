import java.util.Scanner;

public class Act_3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int C_bodega, C_minima, C_actual;
        System.out.print("Digite la cantidad en bodega: ");
        C_bodega = leer.nextInt();
        System.out.print("Digite la cantidad minima requerida: ");
        C_minima = leer.nextInt();
        
        if (C_bodega < C_minima){
            System.out.println("Se requiere solicitar pedido al proveedor");    
        }else{
            C_actual = C_bodega - C_minima;
            System.out.print("No es requerido un pedido al proveedor. Unidades que faltan por vender: "+C_actual);
            if (C_actual < 10){
                System.out.println(" Alerta!!");
            }
        }
        leer.close();
    }
}
