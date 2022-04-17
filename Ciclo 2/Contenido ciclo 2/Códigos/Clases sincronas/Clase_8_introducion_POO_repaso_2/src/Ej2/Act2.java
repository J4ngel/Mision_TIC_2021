package Ej2;

import java.util.Scanner;

public class Act2 {
    public static void main(String[] args) {
        final int capacidad = 3;
        Scanner sc = new Scanner(System.in);
        String titulos[]    = {"Programacion 1", "Cocina 1", "Ingles 1"}, autor[] = {"Smith A", "Paez D", "UN"};
        String tematica[]  = {"Programación","Cocina","Ingles"}, resumen[] = {"Resumen 1","Resumen 2","Resumen 3"};
        int C_ejemplates[] = {6, 3 , 0};
        Libro Biblioteca[] = new Libro[capacidad];
        for (int i = 0; i < capacidad; i++) {Biblioteca[i] = new Libro(titulos[i],autor[i],tematica[i],resumen[i],C_ejemplates[i]);}

        boolean Salir = false, encontrar;
        String Titulo = "";
        int cantidad = 0;
        while(!Salir){
            System.out.println("\n--------->Bienvenido");
            System.out.println("1> Adquisiciones");
            System.out.println("2> Préstamos");
            System.out.println("3> Devoluciones");
            System.out.println("4> Salir");
            System.out.print("Digite una opcion del menú: ");
            String op = sc.nextLine();
            
            switch (op) {
                case "1": //Adquisiciones
                    System.out.print("Digite el titulo del ejemplar: ");
                    Titulo = sc.nextLine();
                    
                    encontrar = false;
                    for (Libro libro : Biblioteca) {
                        if(Titulo.equalsIgnoreCase(libro.getTitulo())){
                            System.out.print("Digite la cantidad a agregar: ");
                            cantidad = Integer.parseInt(sc.nextLine());
                            encontrar = true;
                            System.out.printf("Hay %d ejemplares del libro\nPresione enter para continuar...",libro.Adquisiciones(cantidad));
                            sc.nextLine();
                            break;
                        }
                    }
                    if(!encontrar){
                        System.out.printf("El titulo %s NO existe en la base de datos!!\nPresione enter para continuar...",Titulo);
                        sc.nextLine();
                    }
                    break;
                    
                case "2": //Prestamos
                    System.out.print("Digite el titulo del ejemplar: ");
                    Titulo = sc.nextLine();
                    encontrar = false;
                    for (Libro libro : Biblioteca) {
                        if(Titulo.equalsIgnoreCase(libro.getTitulo())){
                            encontrar = true;
                            System.out.println(libro.Prestamo());
                            System.out.print("Presione enter para continuar...");
                            sc.nextLine();
                            break;
                        }
                    }
                    if(!encontrar){
                        System.out.printf("El titulo %s NO existe en la base de datos!!\nPresione enter para continuar...",Titulo);
                        sc.nextLine();
                    }
                    break;

                case "3": //Devoluciones
                    System.out.print("Digite el titulo del ejemplar: ");
                    Titulo = sc.nextLine();
                    encontrar = false;
                    for (Libro libro : Biblioteca) {
                        if(Titulo.equalsIgnoreCase(libro.getTitulo())){
                            encontrar = true;
                            System.out.println(libro.Devoluciones());
                            System.out.print("Presione enter para continuar...");
                            sc.nextLine();
                            break;
                        }
                    }
                    if(!encontrar){
                        System.out.printf("El titulo %s NO existe en la base de datos!!\nPresione enter para continuar...",Titulo);
                        sc.nextLine();
                    }
                    break;
 
                case "4": //Salir
                    Salir = true;
                    System.out.print("\nGracias por usar nuestro software!!\nPresione enter para salir...");
                    sc.nextLine();
                    break;

                default:
                    System.out.print("Opción no valida, intente de nuevo\nPresione enter para continuar...");
                    sc.nextLine();
                    break;
            }
        }
        sc.close();
    }
}
