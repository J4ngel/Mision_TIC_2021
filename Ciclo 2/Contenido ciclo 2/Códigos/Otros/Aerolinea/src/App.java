import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        String[][] asientos = new String[7][4];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                asientos[i][j] = "";
            }
        }        
        
        while(!salir){
            int o = 0;
            do {
                System.out.println("\n/////////////BIENVENIDO A AEROLINIAS PLUS/////////////\n");
                System.out.println("1> Comprar ticket");
                System.out.println("2> Verificar lugar por asiento");
                System.out.println("3> Salir");
                System.out.print("\nDigite una opcion: ");
                o = Integer.parseInt(input.nextLine());
                
                if(o<=0 || o>3){System.out.println("Error. Ingrese una opción valida");}
            } while (o <= 0 || o > 3);

            System.out.println();
            switch (o) {
                case 1:
                    boolean no_cupos = true; 
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 4; j++) {
                            if(asientos[i][j].equals("")){
                                no_cupos=false;
                                break;
                            }
                        }
                    }
                    if(no_cupos){
                        System.out.println("\nLo sentimos, no tenemos cupos disponibles para vender, vuelva mas tarde o verifique los cupos");
                        System.out.print("Presione enter para continuar ");
                        input.nextLine();
                    }else{
                        System.out.println("[V] => asiento libre,  [X] => asiento ocupado\n");
                        System.out.println("   ################");
                        System.out.println("#######-CABINA-#######");
                        for (int i = 0; i < 7; i++) {
                            for (int j = 0; j < 4; j++) {
                                System.out.print(" ");
                                if(asientos[i][j].equals("")){
                                    System.out.print("[V] ");
                                }else{
                                    System.out.print("[X] ");
                                }
                            }
                            System.out.println();                         
                        }
                        int fila =-1;
                        int columna = -1;
                        do {
                            System.out.println("\nRecuerde que las filas comienzan desde la no. 1 y terminan en la no.7 y las columnas comienzan desde la no.1 hasta la no. 4\n");
                            System.out.print("Digite el numero de la fila en la que desea sentarse: ");
                            fila = Integer.parseInt(input.nextLine())-1;
                            System.out.print("Digite el número de la columna en la que desea sentarse: ");
                            columna = Integer.parseInt(input.nextLine())-1;
                            if (fila<0||columna<0) {
                                System.out.println("\n Error!! El valor de las filas o las columnas es menor o igual a 0.\n");
                                System.out.print("Presione enter para continuar ");
                                input.nextLine();
                            } else if(fila>6||columna>3){
                                System.out.println("\n Error!! El valor de las filas o las columnas supera el permitido.\n");
                                System.out.print("Presione enter para continuar ");
                                input.nextLine();
                            }
                        } while (fila<0||columna<0||fila>6||columna>3);

                        if(asientos[fila][columna].equals("")){
                            System.out.print("\nDigite su nombre: ");
                            String nombre = input.nextLine();
                            
                            asientos[fila][columna] = nombre;
                            
                            System.out.println("\n Diagrama de asientos actualizados!\n");
                            System.out.println("[V] => asiento libre,  [X] => asiento ocupado\n");
                            System.out.println("   ################");
                            System.out.println("#######-CABINA-#######");
                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 4; j++) {
                                    System.out.print(" ");
                                    if(asientos[i][j].equals("")){
                                        System.out.print("[V] ");
                                    }else{
                                        System.out.print("[X] ");
                                    }
                                }
                                System.out.println();                         
                            }
                        }
                        else{System.out.println("Ese asiento ya está ocupado!!, por favor seleccione otro");}
                        System.out.print("Presione enter para continuar ");
                        input.nextLine();
                    }
                    break;
                case 2:
                boolean vacio = true;
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 4; j++) {
                            if(!asientos[i][j].equals("")){
                                vacio=false;
                                break;
                            }
                        }
                    }
                    if(vacio){
                        System.out.println("\nNo hay pasajeros registrados!");
                        System.out.print("Presione enter para continuar ");
                        input.nextLine();
                    }else{
                        System.out.println("[V] => asiento libre,  [X] => asiento ocupado\n");
                        System.out.println("   ################");
                        System.out.println("#######-CABINA-#######");
                        for (int i = 0; i < 7; i++) {
                            for (int j = 0; j < 4; j++) {
                                System.out.print(" ");
                                if(asientos[i][j].equals("")){
                                    System.out.print("[V] ");
                                }else{
                                    System.out.print("[X] ");
                                }
                            }
                            System.out.println();                         
                        }
                        int fila =-1;
                        int columna = -1;
                        do {
                            System.out.println("\nRecuerde que las filas comienzan desde la no. 1 y terminan en la no.7 y las columnas comienzan desde la no.1 hasta la no. 4\n");
                            System.out.print("Digite el numero de la fila en la que desea sentarse: ");
                            fila = Integer.parseInt(input.nextLine())-1;
                            System.out.print("Digite el número de la columna en la que desea sentarse: ");
                            columna = Integer.parseInt(input.nextLine())-1;
                            if (fila<0||columna<0) {
                                System.out.println("\n Error!! El valor de las filas o las columnas es menor o igual a 0.\n");
                                System.out.print("Presione enter para continuar ");
                                input.nextLine();
                            } else if(fila>6||columna>3){
                                System.out.println("\n Error!! El valor de las filas o las columnas supera el permitido.\n");
                                System.out.print("Presione enter para continuar ");
                                input.nextLine();
                            }
                        } while (fila<0||columna<0||fila>6||columna>3);

                        System.out.println();
                        
                        if (asientos[fila][columna].equals("")) {
                            System.out.println("Asiento vacio");
                        }else{
                            System.out.printf("\nAsiento reservado a nombre de: %s\n",asientos[fila][columna]);
                        }
                        System.out.print("Presione enter para continuar ");
                        input.nextLine();
                    }
                    break;

                case 3:
                salir = true;
                System.out.println("Gracias por usar nuestro software");
                    break;
                default:
                    break;
            }
        }    
        input.close();
    }
}
