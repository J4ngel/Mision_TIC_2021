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

        boolean salir = false, encontrado;
        String cod ="";
        int unidades;
        while(!salir){
            System.out.println("\n-------->Bienvenido");
            System.out.println("1> Verificar productos a pedir");
            System.out.println("2> Producto con mayor cantidad de unidades");
            System.out.println("3> Total a pagar por pedido a realizar");
            System.out.println("4> Modificar cantidad minima requerida en bodega");
            System.out.println("5> Vender producto");
            System.out.println("6> Salir");
            System.out.print("Digite una opción del menú: ");
            String o = sc.nextLine();
            System.out.println();

            switch (o){
                case "1":
                    for (Producto articulo : Inventario) {
                        if(articulo.S_pedido()){System.out.println("Alerta!! debe solicitar pedido al proveedor del producto con código "+articulo.getCodigo());}
                        else{System.out.println("No es necesario solicitar pedido al proveedor del producto con código "+articulo.getCodigo());}
                    }
                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "2":
                    Producto mayor = Inventario[0];

                    for (Producto articulo : Inventario) {
                        if(mayor.getC_bodega() < articulo.getC_bodega()){mayor = articulo;}
                    }
                    System.out.printf("\nEl producto con código %s tiene la mayor cantidad de unidades en bodega(%d)\n",mayor.getCodigo(), mayor.getC_bodega());
                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "3":
                    System.out.print("\nDigite el código del producto a comprar: ");
                    cod = sc.nextLine();
                    System.out.print("Digite la cantidad de unidades a comprar: ");
                    unidades = Integer.parseInt(sc.nextLine());
                    encontrado = false;
            
                    for (Producto articulo : Inventario) {
                        if(cod.equals(articulo.getCodigo())){
                            encontrado = true;
                            if(unidades <= articulo.getC_maxima()){System.out.printf("Total a pagar: $%.0f\n",articulo.T_pagar(unidades));}
                            else{System.out.println("No se puede completar la operación, la cantidad de unidades solicitadas sobrepasa la cantidad maxima permitida");}
                            break;
                        }
                    }
                    if(!encontrado){System.out.println("Error!! Código no encontrado");}

                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "4":
                    System.out.print("\nDigite el código del producto a cambiar su cantidad minima requerida: ");
                    cod = sc.nextLine();
                    System.out.print("Digite la cantidad nueva cantidad minima requerida: ");
                    int c_minima = Integer.parseInt(sc.nextLine());
                    encontrado = false;
            
                    for (Producto articulo : Inventario) {
                        if(cod.equals(articulo.getCodigo())){
                            encontrado = true;
                            articulo.setC_requerida(c_minima);
                            System.out.printf("El cambio se realizó con exito, la nueva cantidad minima requerida para el producto con código %s es: %d unidades\n",articulo.getCodigo(),articulo.getC_requerida());
                            break;
                        }
                    }
                    if(!encontrado){System.out.println("Error!! Código no encontrado");}

                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "5":
                    System.out.print("\nDigite el código del producto a vender: ");
                    cod = sc.nextLine();
                    System.out.print("Digite la cantidad de unidades a vender: ");
                    unidades = Integer.parseInt(sc.nextLine());
                    encontrado = false;
            
                    for (Producto articulo : Inventario) {
                        if(cod.equals(articulo.getCodigo())){
                            encontrado = true;
                            
                            if(unidades <= articulo.getC_bodega()){
                                System.out.printf("Valor de factura sin descuento: $%d\n",(articulo.getP_venta()*unidades));
                                System.out.printf("Valor de factura con descuento: $%.0f\n\n",((articulo.getP_venta()*unidades)-(Producto.getDescuento()*articulo.getP_venta()*unidades)));
                                articulo.setC_bodega(articulo.getC_bodega()-unidades);
                                System.out.printf("Cantidad en bodega despues de la compra: %d\n",articulo.getC_bodega());
                            }
                            else{
                                System.out.printf("No se pudo completar la operación, las unidades solicitadas (%d) sobrepasan la cantidad en bodega (%d) del producto con código %s\n",unidades, articulo.getC_bodega(), articulo.getCodigo());
                            }
                            break;
                        }
                    }
                    if(!encontrado){System.out.println("Error!! Código no encontrado");}

                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "6":
                    salir = true;
                    System.out.print("Gracias por usar nuestro software!!\nPresione enter para salir...");
                    sc.nextLine();
                    break;

                default:
                    System.out.print("Error, opción no valida!!\nPresione enter para continuar...");
                    sc.nextLine();
                    break;    
            }
        }
        sc.close();
    }
}
