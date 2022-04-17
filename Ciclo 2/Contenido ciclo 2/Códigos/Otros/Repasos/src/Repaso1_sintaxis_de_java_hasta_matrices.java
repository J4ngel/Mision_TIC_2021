import java.util.Scanner;

public class Repaso1_sintaxis_de_java_hasta_matrices {
    public static void main(String[] args){
        //TODO AQUI SE EJECUTA
        Scanner leer = new Scanner(System.in);
        var a = 5;   //Para usar var SI o SI se requiere asignar un valor o genera error
        int b,c;     //De esta forma no se pueden crear variables con var
        var numero = "31";
        b = 10;
        c = a + b;
        System.out.printf("La suma de %d con %d es equivalente a %d\n\n",a,b,c);
        System.out.printf("La variable numero es: %s\n\n",numero);
        a = Integer.parseInt(numero);
        System.out.printf("La variable numero es: %d\n",a);

        //--------------------Arreglos
        System.out.println("\nArreglos, presentacion de un arreglo predefinido: ");
        int arreglo1[] = new int[4];
        int arreglo2[] = {6,15,14,100};
        
        for(int i =0; i<arreglo2.length; i++){
            System.out.println(arreglo2[i]);
        }
        System.out.println("Ahora vamos a llenar un arreglo de 4 espacios que está vacío:");
        for(int i =0; i<4; i++){
            System.out.print("Valor para la posición "+(i+1)+": ");
            arreglo1[i] = leer.nextInt();
        }
        System.out.println("\nPresentacion de los valores en el arreglo recien llenado: ");
        for (int num : arreglo1) {
            System.out.println(num);
        }

        //------------Matrices
        System.out.print("Dimension de la matriz: ");
        int tam = leer.nextInt();
        int matriz[][]   = new int[tam][tam];
        int mat_diagonal[][] = new int[tam][tam];

        for (int i = 0; i <tam; i++){
            for (int j = 0; j <tam; j++){
                if (i == j){
                    mat_diagonal[i][j] = 1;
                }else{
                    mat_diagonal[i][j] = 0;
                }
            }
        }

        for (int i =0; i<tam;i++){
            for (int j =0; j<tam; j++){
                System.out.print("Valor para ["+(i+1)+","+(j+1)+"]: ");
                matriz[i][j] = leer.nextInt();
            }
        }
        System.out.println("\nValores de la matriz recien ingresada: ");
        for (int i =0; i<tam; i++){
            for (int j =0; j<tam; j++){
                System.out.printf(" %d |",matriz[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("\nValores de la matriz con solo los valores en su dagonal: ");
        for (int i =0; i<tam; i++){
            for (int j =0; j<tam; j++){
                matriz[i][j] *= mat_diagonal[i][j];  // matriz[i][j] = matriz[i][j] * mat_diagonal[i][j]; 
                System.out.printf(" %d |",matriz[i][j]);
            }
            System.out.println();
        }

        leer.close();
    }
}
