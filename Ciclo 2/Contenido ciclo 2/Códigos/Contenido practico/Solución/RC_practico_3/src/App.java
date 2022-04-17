import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        String Codigos[]    = leer.nextLine().split(" ");
        String fila1[]      = leer.nextLine().split(";");
        String fila2[]      = leer.nextLine().split(";");
        int C_bodega[][]    = new int[fila1.length][Codigos.length];
        int C_requerida[][] = new int[fila1.length][Codigos.length];
        //---------Cargar matriz---------------------
        for(int i = 0; i<fila1.length; i++){
            String columna1[] = fila1[i].split(" ");
            String columna2[] = fila2[i].split(" ");
            for(int j = 0; j<Codigos.length;j++){
                String num1 = columna1[j];
                String num2 = columna2[j];
                C_bodega[i][j]    = Integer.parseInt(num1);
                C_requerida[i][j] = Integer.parseInt(num2);
            }
        }          
        //----------Mostrar datos-------------------
        System.out.println("\nCódigos:");
        System.out.print("|");
        for (String codigo : Codigos) {
            System.out.printf("\t%s\t|",codigo);
        }
        System.out.println("\nCantidad en bodega:");
        for (int sede[] : C_bodega) {
            System.out.print("|");
            for (int numero : sede) {
                System.out.printf("\t%d\t|",numero);
            }
            System.out.println();
        }
        System.out.println("\nCantidad minima requerida:");
        for (int sede[] : C_requerida){
            System.out.print("|");
            for (int numero : sede) {
                System.out.printf("\t%d\t|",numero);
            }
            System.out.println();
        }
        //-------------Procesamiento de datos
        double prom[] = new double[fila1.length], sum = 0;
        for (int i = 0; i < fila1.length; i++){
            sum = 0;
            for (int j = 0; j < Codigos.length; j++){
                sum += C_bodega[i][j];
                if (C_bodega[i][j] < C_requerida[i][j]){
                    System.out.printf("Se debe solicitar producto %s en sede %d\n", Codigos[j],i); //i+1 para pseudocódigo como debería ser
                }
            }
            prom[i] = sum/fila1.length;
        }
        System.out.println();
        for (int i=0; i < prom.length; i++) {System.out.printf("El promedio de productos en la sede %s es %.2f\n",(i),prom[i]);}
        leer.close();
    }
}
