import java.util.Scanner; //Para importar todos los elementos de la libreria util: java.util.*
// final int constante = 7 //Con final se declaran las constantes
public class switch_case {
    public static void main(String[] args){
        double l1, l2;
        int opcion;
        Scanner leer = new Scanner(System.in);
        System.out.println("----------------->Bienvenido");
        System.out.println("1) Calcular el area de un cuadrado");
        System.out.println("2) Calcular el area de un rectangulo");
        System.out.println("3) Calcular el area de un triangulo");
        System.out.println("4) Calcular el area de un circulo");
        System.out.print("Digite una opción del menú: ");
        opcion = leer.nextInt();
        System.out.println();
        
        switch (opcion){
            case 1: //A cuadrado
                System.out.print("Digite el valor de un lado del cuadrado: ");
                l1 = leer.nextDouble();
                System.out.printf("El área del cuadrado es: %.2f", Math.pow(l1,2));
                break;

            case 2: //A rectangulo
                System.out.print("Digite el valor de la base del rectangulo: ");
                l1 = leer.nextDouble();
                System.out.print("Digite el valor de la altura del rectangulo: ");
                l2 = leer.nextDouble();
                System.out.printf("El área del rectangulo es: %.2f", l1*l2);
                break;

            case 3: //A Triangulo
                System.out.print("Digite el valor de la base del triangulo: ");
                l1 = leer.nextDouble();
                System.out.print("Digite el valor de la altura del triangulo: ");
                l2 = leer.nextDouble();
                System.out.printf("El área del triangulo es: %.2f", ((l1*l2)/2));
                break;

            case 4: //A circulo
                System.out.print("Digite el valor del radio del circulo: ");
                l1 = leer.nextDouble();
                System.out.printf("El área del circulo es: %.2f", Math.PI*Math.pow(l1,2));
                break;
            
            default: //Si la opción no es valida
                System.out.println("Error, opción no valida!!");
                break;
        }
        
        leer.close();
    }
}
