import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite la cantidad de productos en su inventario: ");
        int tam = Integer.parseInt(sc.nextLine());
        Producto Inventario[] = new Producto[tam];

        for (int i = 0; i < tam; i++){
            Inventario[i] = new Producto();
            System.out.print("\nCódigo: ");
            Inventario[i].setCodigo(sc.nextLine());
            System.out.print("Precio de compra: $");
            Inventario[i].setP_compra(Integer.parseInt(sc.nextLine()));
            System.out.print("Cantidad de unidades en bodega: ");
            Inventario[i].setC_bodega(Integer.parseInt(sc.nextLine()));
            System.out.print("Cantidad minima requerida: ");
            Inventario[i].setC_requerida(Integer.parseInt(sc.nextLine()));
        }
        System.out.println();
        String cod = Inventario[0].getCodigo();
        int max = Inventario[0].getC_bodega();
        for (Producto articulo : Inventario) {
            if(articulo.S_pedido()){System.out.println("Alerta!! debe solicitar pedido al provedor del producto con código "+articulo.getCodigo());}
            else{System.out.println("NO debe solicitar pedido al provedor del producto con código "+articulo.getCodigo());}

            if(max < articulo.getC_bodega()){
                max = articulo.getC_bodega();
                cod = articulo.getCodigo();
            }
        }
        System.out.printf("El producto con código %s tiene la mayor candidad de unidades en bodega con %d unidades\n",cod,max);
        System.out.println("\nDigite un código de producto a consultar y una cantidad de compra separados por espacios: ");
        String consulta[] = sc.nextLine().split(" ");
        for (Producto articulo : Inventario) {
            if((articulo.getCodigo()).equals(consulta[0])){
                System.out.println("El total a pagar es: $"+articulo.Total_a_pagar(Integer.parseInt(consulta[1])));
            }
        }
        sc.close();
    }
}
