import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
        System.out.println("\n////////////////////BIENVENIDO////////////////////");
        System.out.println("Creador de subcadenas inclusivo");
        System.out.print("Digite su oracion: ");
        String str = inp.nextLine();
        System.out.print("Inicio: ");
        int start = inp.nextInt();
        System.out.print("Fin: ");
        int end = inp.nextInt();
        
        if(start<0 || end<0){
            System.out.println("El valor de inicio y final deben ser valores positivos");
        }else if(start>(str.length()-1) || end>(str.length()-1)){
            System.out.println("El valor de inicio y final deben estar entre el tamaño inclusivo de la oracion");
        }else if(start>end){
            System.out.println("El valor de inicio debe ser menor o igual al valor final");
        }else{
            System.out.printf("La subcadena inclusiva de '%s' del indice %d al %d es '",str,start,end);
            for (int i = start; i <= end; i++) {
                System.out.print(str.charAt(i));
            }
            System.out.print("'");
        }

        inp.close();
    }
}
