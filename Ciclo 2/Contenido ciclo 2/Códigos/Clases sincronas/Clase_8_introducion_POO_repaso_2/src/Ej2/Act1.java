package Ej2;

import java.util.Scanner;

public class Act1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //C_max_equipos parametriza cuantos equipos se pueden agregar como maximo
        int C_max_equipos = 4;//Integer.parseInt(sc.nextLine());
        Equipo_de_futbol Torneo[] = new Equipo_de_futbol[C_max_equipos]; //Arreglo de objetos instanciados, por defecto 4 equipos
        boolean Salir = false; //Variable de control para salir del menú
        int creados = 0; // Conteo de equipos creados hasta el momento

        while(!Salir){ //Menú
            System.out.println("\n------------>Bienvenido");
            System.out.println("1. Ingresar equipo");
            System.out.println("2. Ingresar resultados");
            System.out.println("3. Estadisticas");
            System.out.println("4. Salir");
            System.out.print("Digite una opcion del menú: ");
            int o = Integer.parseInt(sc.nextLine());
            
            switch (o) {
                case 1://Agregar un equipo
                    if(creados < C_max_equipos){
                        Torneo[creados] = new Equipo_de_futbol(); //Instancia un equipo nuevo en el arreglo
                        System.out.print("Digite el nombre del nuevo equipo: ");
                        Torneo[creados].setNombre(sc.nextLine());   //Le agrega nombre al equipo recien creado
                        creados++;
                    }else{
                        System.out.printf("Ya hay %d equipos registrados, no se pueden ingresar mas!!\nPresione enter para continuar...",C_max_equipos);
                        sc.nextLine();
                    }
                    break;
                case 2: //Ingresar estadisticas
                    if(creados == 0){//Si no hay equipos creados en el arreglo
                        System.out.print("No hay equipos registrados\nPresione enter para continuar...");
                        sc.nextLine();
                    }
                    else{
                        System.out.print("Digite el nombre del equipo a ingresar resultados: "); //Lee el nombre del equipo para poder agregar un resultado
                        String nombre = sc.nextLine();
                        boolean encontrar = false;

                        for (int i=0; i < creados; i++) { //Recorre el arreglo hasta el número de equipos creados
                            if(nombre.equalsIgnoreCase(Torneo[i].getNombre())){ //Busca el equipo que tenga el mismo nombre ingresado
                                encontrar = true;
                                while(true){ //Segundo menú para definir el resultado del partido
                                    System.out.println("1. Ganó");
                                    System.out.println("2. Perdió");
                                    System.out.println("3. Empató");
                                    System.out.print("Digite la opción del resultado: ");
                                    int r = Integer.parseInt(sc.nextLine());

                                    if(r == 1){
                                        Torneo[i].setGanados();
                                        break;
                                    }else if(r == 2){
                                        Torneo[i].setPerdidos();
                                        break;
                                    }else if(r == 3){
                                        Torneo[i].setEmpatados();
                                        break;
                                    }else{
                                        System.out.print("Error!!, opcion no valida, trate de nuevo\nPresione enter para continuar...");
                                        sc.nextLine();
                                    }
                                }
                            }
                        }
                        if(!encontrar){
                            System.out.print("El equipo digitado no existe\nPresione enter para continuar...");
                            sc.nextLine();
                        }
                    }
                    break;
                case 3://Mostrar estadisticas
                    if(creados == 0){ //Si no hay equipos creados en el arreglo
                        System.out.println("No hay equipos registrados!!");
                    }
                    else{
                        for (int i=0 ; i< creados; i++) { //Recorra todos los equipos creados hasta el momento y muestre las estadisticas de cada uno
                            Torneo[i].verEstadisticas();
                        }
                    }
                    System.out.print("Presione enter para continuar...");
                    sc.nextLine(); //Pausa para que la persona vea el mensaje y luego me imprima otra vez el menú
                    break;
                case 4://Salir
                    Salir = true;
                    break;
                default://Opción no valida
                    System.out.print("Error, opción no valida!!\nPresione enter para continuar...");
                    sc.nextLine();
                    break;
            }
        }
        sc.close();
    }
}
