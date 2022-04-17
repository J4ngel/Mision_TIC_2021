import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite el número de productos de tipo prendas de vestir a manejar: ");
        int tam1 = Integer.parseInt(sc.nextLine());
        System.out.print("Digite el número de productos de tipo calzado a manejar: ");
        int tam2 = Integer.parseInt(sc.nextLine());

        P_vestir Catalogo1[] = new P_vestir[tam1];
        Calzado Catalogo2[] = new Calzado[tam2];

        info_pvestir(Catalogo1, tam1, sc);
        info_calzado(Catalogo2, tam2, sc);
        
        boolean salir = false, encontrado;
        String cod ="", tipo ="";
        int unidades;
        while(!salir){
            System.out.println("\n-------->Bienvenido");
            System.out.println("1> Verificar productos a pedir");
            System.out.println("2> Calzado con mayor cantidad de unidades");
            System.out.println("3> Prenda con mayor cantidad de unidades");
            System.out.println("4> Modificar cantidad minima requerida en bodega");
            System.out.println("5> Vender producto");
            System.out.println("6> Salir");
            System.out.print("Digite una opción del menú: ");
            String o = sc.nextLine();
            System.out.println();

            switch (o){
                case "1":
                    System.out.println("Prendas de vestir:\n");
                    for (Producto articulo : Catalogo1) {
                        if(articulo.S_pedido()){System.out.println("Alerta!! debe solicitar pedido al proveedor de la prenda con código "+articulo.getCodigo());}
                        else{System.out.println("No es necesario solicitar pedido al proveedor de la prenda con código "+articulo.getCodigo());}
                    }
                    System.out.println("\nCalzado:\n");
                    for (Producto articulo : Catalogo2) {
                        if(articulo.S_pedido()){System.out.println("Alerta!! debe solicitar pedido al proveedor del calzado con código "+articulo.getCodigo());}
                        else{System.out.println("No es necesario solicitar pedido al proveedor del calzado con código "+articulo.getCodigo());}
                    }
                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "2":
                    Calzado mayor2 = C_mayor2(Catalogo2,tam2);
                    System.out.printf("El Calzado con código %s tiene la mayor cantidad de unidades en bodega(%d)\n",mayor2.getCodigo(), mayor2.getC_bodega());
                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;
                
                case "3":
                    P_vestir mayor1 = C_mayor1(Catalogo1,tam1);
                    System.out.printf("La prenda de vestir con código %s tiene la mayor cantidad de unidades en bodega(%d)\n",mayor1.getCodigo(), mayor1.getC_bodega());
                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();    
                    break;

                case "4":
                    System.out.print("Digite el código del producto a cambiar su cantidad minima requerida: ");
                    cod = sc.nextLine();
                    do{
                        System.out.print("Digite el tipo del producto (Prenda/Calzado): ");
                        tipo = sc.nextLine();
                        if(!tipo.equalsIgnoreCase("prenda") && !tipo.equalsIgnoreCase("calzado")){
                            System.out.print("Entrada no valida, por favor digite unicamente prenda o calzado!!\nPresione enter para continuar");
                            sc.nextLine();
                        }
                    }while(!tipo.equalsIgnoreCase("prenda") && !tipo.equalsIgnoreCase("calzado"));
                    
                    encontrado = false;
                    if(tipo.equalsIgnoreCase("prenda")){
                        for (P_vestir articulo : Catalogo1) {
                            if(cod.equals(articulo.getCodigo())){
                                System.out.print("Digite la cantidad nueva cantidad minima requerida: ");
                                int c_minima = Integer.parseInt(sc.nextLine());
                                encontrado = true;
                                articulo.setC_requerida(c_minima);
                                System.out.printf("El cambio se realizó con exito, la nueva cantidad minima requerida para la prenda con código %s es: %d unidades\n",articulo.getCodigo(),articulo.getC_requerida());
                                break;
                            }
                        }
                    }
                    else{
                        for (Calzado articulo : Catalogo2) {
                            if(cod.equals(articulo.getCodigo())){
                                System.out.print("Digite la cantidad nueva cantidad minima requerida: ");
                                int c_minima = Integer.parseInt(sc.nextLine());
                                encontrado = true;
                                articulo.setC_requerida(c_minima);
                                System.out.printf("El cambio se realizó con exito, la nueva cantidad minima requerida para el calzado con código %s es: %d unidades\n",articulo.getCodigo(),articulo.getC_requerida());
                                break;
                            }
                        }
                    }      
                    if(!encontrado){System.out.println("Error!! Código no encontrado");}

                    System.out.print("Presione enter para continuar...");
                    sc.nextLine();
                    break;

                case "5":
                    System.out.print("Digite el código del producto a vender: ");
                    cod = sc.nextLine();
                    do{
                        System.out.print("Digite el tipo del producto (Prenda/Calzado): ");
                        tipo = sc.nextLine();
                        if(!tipo.equalsIgnoreCase("prenda") && !tipo.equalsIgnoreCase("calzado")){
                            System.out.print("Entrada no valida, por favor digite unicamente prenda o calzado!!\nPresione enter para continuar");
                            sc.nextLine();
                        }
                    }while(!tipo.equalsIgnoreCase("prenda") && !tipo.equalsIgnoreCase("calzado"));
                    encontrado = false;
                    
                    if(tipo.equalsIgnoreCase("prenda")){
                        for (P_vestir articulo : Catalogo1) {
                            if(cod.equals(articulo.getCodigo())){
                                System.out.print("Digite la cantidad de unidades a vender: ");
                                unidades = Integer.parseInt(sc.nextLine());
                                encontrado = true;
                                
                                if(unidades <= articulo.getC_bodega()){
                                    System.out.printf("Valor de factura sin descuento: $%d\n",(articulo.getP_venta()*unidades));
                                    System.out.printf("Valor de factura con descuento: $%.0f\n\n",((articulo.getP_venta()*unidades)-(Producto.getDescuento()*articulo.getP_venta()*unidades)));
                                    articulo.setC_bodega(articulo.getC_bodega()-unidades);
                                    System.out.printf("Cantidad en bodega despues de la compra: %d\n",articulo.getC_bodega());
                                }
                                else{
                                    System.out.printf("No se pudo completar la operación, las unidades solicitadas (%d) sobrepasan la cantidad en bodega (%d) de la prenda con código %s\n",unidades, articulo.getC_bodega(), articulo.getCodigo());
                                }
                                break;
                            }
                        }
                    }
                    else{
                        for (Calzado articulo : Catalogo2) {
                            if(cod.equals(articulo.getCodigo())){
                                System.out.print("Digite la cantidad de unidades a vender: ");
                                unidades = Integer.parseInt(sc.nextLine());
                                encontrado = true;
                                
                                if(unidades <= articulo.getC_bodega()){
                                    System.out.printf("Valor de factura sin descuento: $%d\n",(articulo.getP_venta()*unidades));
                                    System.out.printf("Valor de factura con descuento: $%.0f\n\n",((articulo.getP_venta()*unidades)-(Producto.getDescuento()*articulo.getP_venta()*unidades)));
                                    articulo.setC_bodega(articulo.getC_bodega()-unidades);
                                    System.out.printf("Cantidad en bodega despues de la compra: %d\n",articulo.getC_bodega());
                                }
                                else{
                                    System.out.printf("No se pudo completar la operación, las unidades solicitadas (%d) sobrepasan la cantidad en bodega (%d) del calzado con código %s\n",unidades, articulo.getC_bodega(), articulo.getCodigo());
                                }
                                break;
                            }
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
    public static void info_pvestir(P_vestir inventario[],int tam, Scanner sc){
        System.out.println("Información prendas de vestir: ");
        for(int i = 0; i < tam; i++){
            System.out.println("\nPrenda "+(i+1)+":");
            inventario[i] = new P_vestir();
            System.out.print("Digite el código del producto: ");
            inventario[i].setCodigo(sc.nextLine());

            System.out.print("Digite la descripción producto: ");
            inventario[i].setDescripcion(sc.nextLine());

            System.out.print("Digite el precio de compra del producto: $");
            inventario[i].setP_compra(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite el precio de venta del producto: $");
            inventario[i].setP_venta(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad en bodega: ");
            inventario[i].setC_bodega(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad minima requerida: ");
            inventario[i].setC_requerida(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad máxima permitida: ");
            inventario[i].setC_maxima(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la talla: ");
            inventario[i].setTalla(sc.nextLine());

            String planchado;
            do{
                System.out.print("Digite S si permite planchado o N de lo contrario: ");
                planchado = sc.nextLine();
                if(!planchado.equalsIgnoreCase("s")&&!planchado.equalsIgnoreCase("n")){
                    System.out.print("Entrada no valida, digite solo s ó n\nPresione enter para continuar...");
                    sc.nextLine();
                }
            }while(!planchado.equalsIgnoreCase("s")&&!planchado.equalsIgnoreCase("n"));
            
            if(planchado.equalsIgnoreCase("s")){inventario[i].setPermite_planchado(true);}
            else{inventario[i].setPermite_planchado(false);}  
        }
    }

    public static void info_calzado(Calzado inventario[], int tam, Scanner sc){
        System.out.println("Información calzado: ");
        for(int i = 0; i < tam; i++){
            System.out.println("\nCalzado "+(i+1)+":");
            inventario[i] = new Calzado();
            System.out.print("Digite el código del producto: ");
            inventario[i].setCodigo(sc.nextLine());

            System.out.print("Digite la descripción producto: ");
            inventario[i].setDescripcion(sc.nextLine());

            System.out.print("Digite el precio de compra del producto: $");
            inventario[i].setP_compra(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite el precio de venta del producto: $");
            inventario[i].setP_venta(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad en bodega: ");
            inventario[i].setC_bodega(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad minima requerida: ");
            inventario[i].setC_requerida(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la cantidad máxima permitida: ");
            inventario[i].setC_maxima(Integer.parseInt(sc.nextLine()));

            System.out.print("Digite la talla: ");
            inventario[i].setTalla(Integer.parseInt(sc.nextLine()));
        }
    }

    public static P_vestir C_mayor1(P_vestir inventario[], int tam){
        P_vestir mayor = inventario[0];
        for (P_vestir articulo : inventario) {
            if(mayor.getC_bodega() < articulo.getC_bodega()){mayor = articulo;}
        }
        return mayor;
    }
    
    public static Calzado C_mayor2(Calzado inventario[], int tam){
        Calzado mayor = inventario[0];
        for (Calzado articulo : inventario) {
            if(mayor.getC_bodega() < articulo.getC_bodega()){mayor = articulo;}
        }
        return mayor;
    }
}
