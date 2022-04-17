import java.util.ArrayList;
import java.util.Arrays;

public class temp {
    static int[][] table = new int[4][4];
        public static void main(String[] args) throws Exception {
            llenarTableroAletorio();
            imprimirTablero();
        }

        static public void imprimirTablero(){
            for (int i = 0; i<table.length;i++){
                System.out.println();
                System.out.println("--------------------");
                for( int j = 0;j<table[i].length;j++){
                    System.out.print("| ");
                    System.out.printf("%-3.10s", table[i][j]);
                }
                System.out.print("|");
            }
        }

        static public void llenarTableroAletorio(){
            ArrayList<Integer> numeros_usados = new ArrayList<Integer>();
            for (int i = 0; i<table.length;i++){
                for( int j = 0;j<table[i].length;j++){
                    Boolean activador = true;
                    while(activador){
                        activador = false;
                        int random_int = (int)Math.floor(Math.random()*(90-1+1)+1);
                        for (Integer integer : numeros_usados) {
                            if(integer == random_int){
                                activador = true;
                            }
                        }
                        if(activador == false){
                            table[i][j] = random_int;
                            numeros_usados.add(random_int);
                        }
                    }
                }
            }
            for (int i = 0; i<table.length;i++){
                Arrays.sort(table[i]);
            }
        }   
}
