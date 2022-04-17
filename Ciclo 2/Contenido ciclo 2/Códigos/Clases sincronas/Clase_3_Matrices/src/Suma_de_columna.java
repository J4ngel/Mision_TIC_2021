import java.util.Scanner;

public class Suma_de_columna {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);

        int tam = 0, suma = 0,c;
        System.out.print("Digite el tamaño de la matriz: ");
        tam = leer.nextInt();

        int A[][] = new int[tam][tam];
        System.out.printf("Matriz aleatoria de %dX%d:\n",tam,tam);
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                A[i][j] = (int)(Math.random()*100);
                c = (int)(Math.random()*100);
                if(c < 50){A[i][j] *= -1;}
                System.out.print("\t"+A[i][j]);
            }
            System.out.println();
        }
    
        System.out.print("Digite la columna de la cual quiere sumar los valores: ");
        c = leer.nextInt();
        if(c<1 | c>tam){ System.out.println("Columna no valida!!");}
        else{
            for(int i=0; i<tam; i++){
                suma += A[i][c-1];
            }
            System.out.println("La sumatoria de valores de la columna "+c+" es: "+suma);
        }
        //-------------------------------------------------------------------
        int min = A[0][0], max = A[0][0];
        int p_min[] = {1,1}, p_max[] = {1,1};

        for (int i=0; i<tam; i++){
            for (int j=0; j<tam; j++){
                if(min > A[i][j]){
                    min = A[i][j];
                    p_min[0] = i+1;
                    p_min[1] = j+1;
                }
                if(max < A[i][j]){
                    max = A[i][j];
                    p_max[0] = i+1;
                    p_max[1] = j+1;
                }
            }
        }
        System.out.printf("El valor minimo de la matriz es: %d, en la posicion: fila: %d columna: %d.\n",min,p_min[0],p_min[1]);
        System.out.printf("El valor maximo de la matriz es: %d, en la posicion: fila: %d columna: %d.\n",max,p_max[0],p_max[1]);
        leer.close();
    }    
}
