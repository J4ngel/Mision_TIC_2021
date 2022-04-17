import java.util.Scanner;

public class Repaso2_for_arreglos_matrices {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /* 
        //System.out.print("Digite el tamaño del arreglo: ");
        final int  tam = 3;    //Filas
        final int  tam2 = 4;   //Columnas
        
        String linea[] = new String[tam2];
        String Datos[][] = new String[tam][tam2];
        
        for (int i = 0; i<tam; i++) {
            System.out.println("Digite la "+(i+1)+" linea: ");
            linea = sc.nextLine().split("-");
            for(int j = 0; j<tam2; j++){
                Datos[i][j] = linea[j];
            }
        }
        System.out.println("\nDatos de estudiantes: ");
        for(int fila = 0; fila<tam; fila++){
            for(int columna = 0; columna < tam2; columna++){
                System.out.printf("\t%s",Datos[fila][columna]);
            }
            System.out.println();
        }
        double promedio = 0;

        for(int i = 0; i<tam; i++){
            promedio = promedio + Double.parseDouble(Datos[i][3]);
        }
        promedio = promedio/tam;

        System.out.printf("El promedio del curso es: %.3f",promedio); */


        String Nom[]      = {"Armando","Daniela"};
        String Materias[] = {"Ingles","Fisica"};
        String Datos[][]  = new String[2][2];

        Datos[0][0] = Nom[0];
        Datos[0][1] = Materias[0];
        Datos[1][0] = Nom[1];
        Datos[1][1] = Materias[1];

        for(int i=0; i<2; i++){
            for(int j=0; j<2;j++){
                System.out.printf("\t%s",Datos[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
