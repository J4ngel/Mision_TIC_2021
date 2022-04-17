import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        int n;
        System.out.print("Digite el número de productos: ");
        n = leer.nextInt();
        int Codigos[] = new int[n];
        int C_bodega[] = new int[n];
        int C_requerida[] = new int[n];

        for (int i = 0; i < n; i++){
            System.out.print("\nDigite el código del producto "+(i+1)+": ");
            Codigos[i] = leer.nextInt();
            System.out.print("Digite la cantidad en bodega del producto "+(i+1)+": ");
            C_bodega[i] = leer.nextInt();
            System.out.print("Digite la cantidad minima requerida del producto "+(i+1)+": ");
            C_requerida[i] = leer.nextInt();
        }
        int menor = C_bodega[0], mayor = C_bodega[0], c_menor = Codigos[0], c_mayor = Codigos[0];
        boolean requiere = false;

        System.out.println("\nCódigos de productos que son necesario pedir:");
        for (int i = 0; i < n; i++){
            if (C_bodega[i] < C_requerida[i]){
                requiere = true;
                System.out.println(Codigos[i]);
            }

            if (mayor < C_bodega[i]){
                mayor = C_bodega[i];
                c_mayor = Codigos[i];
            }

            if (menor > C_bodega[i]){
                menor = C_bodega[i];
                c_menor = Codigos[i];
            }
        }
        if (!requiere){
            System.out.println("Ninguno");
        }
        System.out.println("Código con mayor número de unidades en bodega: "+c_mayor);
        System.out.println("Código con menor número de unidades en bodega: "+c_menor);
        leer.close();
    }
}
