import java.util.Arrays;
public class Vectores {
    public static void main(String[] args) {
        //Arreglo vacío
        int arreglo[] = new int[5];   //String, float, double
        //Arreglo con valores definidos
        int ar1[] = {1,2,3,4,5,7,8,9,10};

        for (int i = 0; i<5; i++){
            arreglo[i] = (int)(Math.random()*100);
            System.out.println(arreglo[i]);
        }
        System.out.println("----------------------");
        for (int i = 0; i<ar1.length; i++){
            System.out.println(ar1[i]);
        }    
        System.out.println("----------------------");
        //Imprimir arreglo con la librería array
        System.out.println(Arrays.toString(ar1));

        System.out.println("----------------------");
        //For each como el de python que tome los elementos del arreglo
        for (int num: ar1){
            System.out.print(num + " ");
        }
    }
}
