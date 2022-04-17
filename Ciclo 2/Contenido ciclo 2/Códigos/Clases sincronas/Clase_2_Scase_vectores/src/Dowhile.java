import java.util.Scanner;

public class Dowhile {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        // Math.random() genera un num aleatorio entre 0 y 1
        //double n = Math.random(); //casteo a int: (int)Math.random()
        //System.out.println(n);
        int n1 = (int)(Math.random()*100); // numeros entre 0 y 100
        //System.out.println(n1);
        //-----------------------------
        int num = 0, intentos = 0;
        do{
            intentos++;
            System.out.print("Ingrese número: ");
            num = leer.nextInt();
            if (n1 < num){
                System.out.println("El número es mas bajo");
            }
            else if (n1 > num){
                System.out.println("El número es mas alto");
            }
        }while(num != n1);
        System.out.printf("\nLe atinó!!!, el número de intentos fue: %d\n",intentos);
        leer.close();
    }
}
