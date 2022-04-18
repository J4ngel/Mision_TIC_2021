import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("\n////////////////BIENVENIDO, NÚMEROS PRIMOS ENTRE UN RANGO DETERMINADO////////////////\n");
        System.out.print("Numero 1: ");
        int num_1 = input.nextInt();
        System.out.print("Numero 2: ");
        int num_2 = input.nextInt();
        if(num_1 < num_2){
            for (int i = num_1; i <= num_2; i++) {
                if (i%2 != 0) {
                    System.out.print(i+" ");
                }
            }
        }else{
            System.out.println("Error, el valor del segundo numero a digitar (Numero 2) debe ser mayor que el primero (Numero 1)!!");
        }
        

        input.close();
    }
}
