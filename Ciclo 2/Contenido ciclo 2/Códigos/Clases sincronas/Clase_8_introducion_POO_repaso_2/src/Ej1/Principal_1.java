package Ej1;

import java.util.Scanner;

public class Principal_1 {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite la cantidad de productos: ");
        int n = Integer.parseInt(leer.nextLine());
        Producto inventario[] = new Producto[n];
        for (int i = 0; i < n; i++){
            System.out.print("\nDigite el código del producto: ");
            String cod = leer.nextLine();
            System.out.print("Digite el p/u del producto: $");
            int p_compra = Integer.parseInt(leer.nextLine());
            System.out.print("Digite el precio de venta del producto: $");
            int p_venta = Integer.parseInt(leer.nextLine());
            System.out.print("Digite la cantidad en bodega del producto: ");
            int bodega = Integer.parseInt(leer.nextLine());
            System.out.print("Digite la cantidad minima requerida del producto: ");
            int requerida = Integer.parseInt(leer.nextLine());
            System.out.print("Digite la cantidad maxima permitida del producto: ");
            int maxima = Integer.parseInt(leer.nextLine());

            inventario[i] = new Producto(cod,p_compra,p_venta,bodega,requerida,maxima);
        }

        System.out.println();
        Producto P_mayor = inventario[0];
        for (int i = 0; i < n; i++){
            if(inventario[i].S_pedido()){System.out.println("Alerta!! debe solicitar pedido del producto con código "+inventario[i].getCodigo());}
            else{System.out.println("No es necesario solicitar pedido del producto con código "+inventario[i].getCodigo());}

            if(P_mayor.getC_bodega() < inventario[i].getC_bodega()){P_mayor = inventario[i];}
        }
        System.out.printf("\nEl producto con código %s tiene la mayor cantidad de unidades en bodega(%d)\n",P_mayor.getCodigo(),P_mayor.getC_bodega());
        
        System.out.print("\nDigite el código del producto a consultar: ");
        String cod = leer.nextLine();
        System.out.print("Digite la cantidad de unidades a comprar: ");
        int unidades = Integer.parseInt(leer.nextLine());
        boolean no_encontrado = true;

        for(int i=0; i<n; i++){
            if(cod.equals(inventario[i].getCodigo())){
                if(unidades < inventario[i].getC_maxima()){System.out.println("Total a pagar: "+inventario[i].Total_pagar(unidades));}
                else{System.out.println("Error, excede la cantidad maxima permitida");}
                no_encontrado = false;
                break;
            }
        }
        if(no_encontrado){System.out.println("Código no encontrado");}

        System.out.print("\nDigite el código del producto a cambiar su cantidad minima requerida: ");
        cod = leer.nextLine();
        System.out.print("Digite la nueva cantidad minima requerida: ");
        int c_requerida = Integer.parseInt(leer.nextLine());
        no_encontrado = true;
        int indice_cambio = 0;

        for(int i=0; i<n; i++){
            if(cod.equals(inventario[i].getCodigo())){
                if(c_requerida < inventario[i].getC_maxima()){inventario[i].setC_requerida(c_requerida);;}
                else{System.out.println("Error, excede la cantidad maxima permitida");}
                no_encontrado = false;
                indice_cambio = i;
                break;
            }
        }
        if(no_encontrado){System.out.println("Código no encontrado");}
        else{System.out.printf("La nueva cantidad minima requerida en bodega del producto %d es: %d\n",inventario[indice_cambio].getCodigo(),inventario[indice_cambio].getC_requerida());}

        leer.close();
    }
}
