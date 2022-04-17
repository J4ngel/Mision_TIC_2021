/* Realice un programa en Java que que llene una matriz de forma automatica con la 
siguiente secuencia:
    | 1 | 2 | 2 | 2 |
    | 2 | 2 | 2 | 2 |
    | 3 | 4 | 5 | 6 |
    | 2 | 2 | 2 | 7 |
    | 2 | 2 | 2 | 8 |
*/
public class App {
    public static void main(String[] args) throws Exception {
        int matriz[][] = new int[5][4], num = 1;

        for(int i = 0; i <5;i++){
            System.out.print("|");
            for(int j = 0; j < 4; j++){
                if((i < 2 & j > 0) | (i > 2 & j < 3)){matriz[i][j] = 2;}
                else{
                    matriz[i][j] = num;
                    num++;}
                System.out.printf(" %d |",matriz[i][j]);
            }
            System.out.println();
        }
    }
}
