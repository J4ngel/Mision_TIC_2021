import java.util.Scanner;

public class Act_4 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int C_bodega, C_minima, C_actual, C_requerida;
        int V_caja,V_compra,Precio_u; 
        System.out.print("Digite la cantidad en bodega: ");
        C_bodega = leer.nextInt();
        System.out.print("Digite la cantidad minima requerida: ");
        C_minima = leer.nextInt();
        
        if (C_bodega < C_minima){
            System.out.print("Digite la cantidad de compra deseada: ");
            C_requerida = leer.nextInt();
            System.out.print("Digite el valor por unidad del producto: ");
            Precio_u = leer.nextInt();
            System.out.print("Digite el valor en caja: ");
            V_caja = leer.nextInt();

            V_compra = Precio_u * C_requerida;
            System.out.printf("Se requiere solicitar pedido al proveedor. Cantidades de compra deseada: %d. Valor de compra: %d. Valor en caja: %d.", C_requerida, Precio_u, V_caja);
            if (V_caja < V_compra){
                System.out.println(" No es posible realizar el pedido");
            }else{
                System.out.println(" Si es posible realizar el pedido");
            }    
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
