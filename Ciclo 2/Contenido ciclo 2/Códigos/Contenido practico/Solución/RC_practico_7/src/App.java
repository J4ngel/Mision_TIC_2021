import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite el número de productos a manejar en su inventario: ");
        int tam = Integer.parseInt(sc.nextLine());
        Producto Inventario[] = new Producto[tam];

        for(int i = 0; i < tam; i++){
            Inventario[i] = new Producto();
            System.out.print("\nDigite el código del producto: ");
            Inventario[i].setCodigo(sc.nextLine());

            System.out.print("Digite el precio de compra del producto: $");
            Inventario[i].setP_compra(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite el precio de venta del producto: $");
            Inventario[i].setP_venta(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad en bodega: ");
            Inventario[i].setC_bodega(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad minima requerida: ");
            Inventario[i].setC_requerida(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad máxima permitida: ");
            Inventario[i].setC_maxima(Integer.parseInt(sc.nextLine()));
        }

        Producto mayor = Inventario[0];
        System.out.println();

        for (Producto articulo : Inventario) {
            if(articulo.S_pedido()){System.out.println("Alerta!! debe solicitar pedido al proveedor del producto con código "+articulo.getCodigo());}
            else{System.out.println("No es necesario solicitar pedido al proveedor del producto con código "+articulo.getCodigo());}
            
            if(mayor.getC_bodega() < articulo.getC_bodega()){mayor = articulo;}
        }
        
        System.out.printf("\nEl producto con código %s tiene la mayor cantidad de unidades en bodega(%d)\n",mayor.getCodigo(), mayor.getC_bodega());
        
        System.out.print("\nDigite el código del producto a comprar: ");
        String cod = sc.nextLine();
        System.out.print("Digite la cantidad de unidades a comprar: ");
        int unidades = Integer.parseInt(sc.nextLine());
        boolean encontrado = false;

        for (Producto articulo : Inventario) {
            if(cod.equals(articulo.getCodigo())){
                encontrado = true;
                if(unidades <= articulo.getC_maxima()){System.out.println("Total a pagar: $"+articulo.T_pagar(unidades));}
                else{System.out.println("No se puede completar la operación, la cantidad de unidades solicitadas sobrepasa la cantidad maxima permitida");}
            }
        }
        if(!encontrado){System.out.println("Error!! Código no encontrado");}

        System.out.print("\nDigite el código del producto a cambiar su cantidad minima requerida: ");
        cod = sc.nextLine();
        System.out.print("Digite la cantidad nueva cantidad minima requerida: ");
        int c_minima = Integer.parseInt(sc.nextLine());
        encontrado = false;

        for (Producto articulo : Inventario) {
            if(cod.equals(articulo.getCodigo())){
                encontrado = true;
                articulo.setC_requerida(c_minima);
            }
        }
        if(!encontrado){System.out.println("Error!! Código no encontrado");}

        sc.close();
    }
}
