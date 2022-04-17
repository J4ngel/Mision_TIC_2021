import java.util.Scanner;
//Split hace parte de la clase String, podemos generar un array apartir de una cadena
public class Split {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        System.out.print("Frase: ");
        String cadena = leer.nextLine();
        String palabras[] = cadena.split(" ");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
        leer.close();
    }
}
