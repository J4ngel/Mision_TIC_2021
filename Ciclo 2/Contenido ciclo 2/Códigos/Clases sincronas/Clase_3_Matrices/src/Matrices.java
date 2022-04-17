import java.util.Scanner;
/*
Sintaxis

int Matriz[][] = new int[3][3];     vacía
int A[][] = {{1,2,3},{4,5,6}}; valores pre definidos
*/
public class Matrices {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);

        int A[][] = {{1,2,3},
                     {4,5,6}};
        
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                System.out.print("\t"+ A[i][j]);  // \t para tabular, dar un espacio entre cada elem
            }
            System.out.println();
        }
        //----------------------------------------
        int fila, columna;
        
        System.out.print("Digite el número de filas: ");
        fila = leer.nextInt();
        System.out.print("Digite el número de columnas: ");
        columna = leer.nextInt();
        int B[][] = new int[fila][columna];

        for(int i=0; i<fila; i++){
            for(int j=0; j<columna; j++){
                System.out.print("Digite el valor a almacenar en la posición ["+(i+1)+","+(j+1)+"]:");
                B[i][j] = leer.nextInt();
            }
        }

        for(int i=0; i<fila; i++){
            for(int j=0; j<columna; j++){
                System.out.print("\t"+B[i][j]);
            }
            System.out.println();
        }
        leer.close();
    }
}
