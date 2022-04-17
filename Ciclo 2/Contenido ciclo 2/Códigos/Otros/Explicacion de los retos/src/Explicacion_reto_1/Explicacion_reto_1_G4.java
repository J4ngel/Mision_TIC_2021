package Explicacion_reto_1;

import java.util.Scanner;

public class Explicacion_reto_1_G4 {
    public static void main(String[] args){
        Scanner leer    = new Scanner(System.in);
        /* double  n1   = Double.parseDouble(linea[3]); 
        int n = Integer.parseInt(leer.nextLine());
        for (String valor : linea) {
            System.out.println(valor);
        } */
        System.out.print("Digite la cantidad de registros a leer: ");
        int tam = Integer.parseInt(leer.nextLine());
        String nombres[] = {"armando","nicolas","daniel","maria","marcela","alexandra"};
        String clase[]   = {"geografia","matematicas","informatica"};
        double matriz[][]  = new double[tam][4];

        //lectura y guardado de datos en la matriz
        for(int i= 0; i< tam; i++){
            String linea[] = leer.nextLine().split(" ");
            for(int j=0; j<4;j++){
                matriz[i][j] = Double.parseDouble(linea[j]);
            } 
        }
        
        //Este for solo es para que USTEDES vean la tabla, borrar los system.out y hacer el procesado de datos ahí
        double max = matriz[0][3];
        int etiqueta_mejor_desempeno = ((int)(matriz[0][0]))-1;//PARA HALLAR EL INDICE SE CONVIERTE EN ENTERO Y LUEGO SE LE RESTA UNO POR LAS ETIQUETAS
        for (int fila = 0;fila< tam;fila++) {
            System.out.print("|");
            for (int columna= 0; columna < 4; columna++) {
                if(columna == 0 | columna == 2){
                    int temp = ((int)(matriz[fila][columna]))-1; //PARA HALLAR EL INDICE SE CONVIERTE EN ENTERO Y LUEGO SE LE RESTA UNO POR LAS ETIQUETAS
                    if(columna == 0){System.out.printf(" %s |",nombres[temp]);}
                    else{System.out.printf(" %s |",clase[temp]);}
                }
                else{System.out.printf(" %.2f |",matriz[fila][columna]);}
                
                //FILTRO PARA LA MATERIA DE GEOGRAFIA
                if(matriz[fila][2] == 1.0){   //Se compara el valor que hay en la posicion de la matriz[fila][2] (2 porque es la columna de clases) y se compara con la etiqueta 1
                    if(max < matriz[fila][3]){//Se hace el proceso para hallar el número mayor
                        max = matriz[fila][3];//Se actualiza el número mayor
                        etiqueta_mejor_desempeno = ((int)(matriz[fila][0]))-1;//Se actualiza la etiqueta que contiene el nombre
                    }
                }
            }
            System.out.println();
        }

        //PEQUEÑO FRAGMENTO DEL MANEJO DE LOS RANGOS
        double nota = Double.parseDouble(leer.nextLine()); //ESTO NO VA
        if(nota > 4.5 & nota <= 5.0){System.out.println("Usted está en el rango excelente");}
        else if(nota > 3.5 & nota <= 4.5){System.out.println("Usted está en el rango sobresaliente");}

        //------------------->SALIDAS
        //FALTA LAS DEMÁS SALIDAS
        //ULTIMA SALIDAS 
        System.out.println(nombres[etiqueta_mejor_desempeno]+" Tiene el mejor desempeño en geografia");//para imprimir el texto que contiene el nombre usamos el arreglo nombres de la linea 13 y se le pone como indice la variable etiqueta_mejor_desempeno
        leer.close();
    }
}
